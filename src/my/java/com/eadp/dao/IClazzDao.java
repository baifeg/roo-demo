package com.eadp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.eadp.dto.StudentDTO;
import com.eadp.entity.Clazz;
import com.slyak.spring.jpa.GenericJpaRepository;
import com.slyak.spring.jpa.TemplateQuery;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

public interface IClazzDao extends GenericJpaRepository<Clazz, Long>, DetachableJpaRepository<Clazz, Long> {
//	@TemplateQuery
//	Page<StudentWithClazz> xxxMyName(@Param("name") String name, Pageable pageable);

	@TemplateQuery
	Page<StudentWithClazz> xxxMyName(StudentDTO student, Pageable pageable);

	@TemplateQuery
	Page<Clazz> xxxClazzWithStudents(@Param("id") Long id, Pageable pageable);
}
