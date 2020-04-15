package com.eadp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eadp.entity.Student;

public interface IStudentDao extends JpaRepository<Student, Long> {

//	@TemplateQuery
//	Page<Student> findByName(@Param("name") String name, Pageable pageable);
//
//	@TemplateQuery
//	StudentVO findById(@Param("id") Long id);

	@Query(value = "select s from Student s where s.name like %:name%")
	Page<Student> findByNameLike(@Param("name") String name, Pageable pageable);

	@Query(value = "select * from student s left join clazz c on c.id=s.clazz_id where s.name like %:name%", nativeQuery = true)
	List<Student> findByNameNative(@Param("name") String name);

	@Query(value = "select s,c from Student s, Clazz c where c.id=s.clazz.id and s.name like %:name%")
	Page<Student> findByNameHahaah(@Param("name") String name, Pageable pageable);
}
