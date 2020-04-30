package com.eadp.config;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import com.slyak.spring.jpa.GenericJpaRepository;
import com.slyak.spring.jpa.GenericJpaRepositoryImpl;
import io.springlets.data.jpa.repository.DetachableJpaRepository;

public class MyJpaRepositoryImpl<T, ID extends Serializable> extends GenericJpaRepositoryImpl<T, ID>
		implements GenericJpaRepository<T, ID>, DetachableJpaRepository<T, ID>, Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public MyJpaRepositoryImpl(JpaEntityInformation<T, ID> eif, EntityManager em) {
		super(eif, em);
		this.em = em;
	}


	@Override
	public T findOneDetached(ID id) {
		T entity = findOne(id);
		if (entity != null) {
			em.detach(entity);
		}
		return entity;
	}
}