package com.eadp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.eadp.entity.Clazz;
import com.slyak.spring.jpa.GenericJpaRepository;
import com.slyak.spring.jpa.TemplateQuery;

public interface IClazzDao extends GenericJpaRepository<Clazz, Long> {
	@TemplateQuery
	Page<StudentWithClazz> xxxMyName(@Param("name") String name, Pageable pageable);
}