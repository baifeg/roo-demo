package com.eadp.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryAsMap(String nativeSql, Map<String, Object> params) {
		SQLQuery query = em.createNativeQuery(nativeSql).unwrap(SQLQuery.class);
		fillSqlQueryByMap(query, params);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	private void fillSqlQueryByMap(SQLQuery sqlQuery, Map<String, Object> params) {
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				if (obj instanceof Collection<?>)
					sqlQuery.setParameterList(key, (Collection<?>) obj);
				else if (obj instanceof Object[])
					sqlQuery.setParameterList(key, (Object[]) obj);
				else
					sqlQuery.setParameter(key, obj);
			}
		}
	}
}
