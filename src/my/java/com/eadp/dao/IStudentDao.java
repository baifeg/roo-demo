package com.eadp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eadp.entity.Student;
import com.eadp.vo.StudentVO;

public interface IStudentDao extends JpaRepository<Student, Long> {

	// 手动饿汉加载（left join fetch），如果是分页查询，需要额外定义countQuery（去掉fetch），否则报错
	@Query(value = "select s from Student s left join fetch s.clazz where s.name like %:name%", countQuery = "select count(1) from Student s where s.name like %:name%")
	Page<Student> findByNameLike(@Param("name") String name, Pageable pageable);

	// 原生SQL查询，如果需要分页，需要额外定义countQuery，并手动处理pageable
	@Query(value = "select * from student s left join clazz c on c.id=s.clazz_id where s.name like %:name%", nativeQuery = true)
	List<Student> findByNameNative(@Param("name") String name);

	@Query(value = "select s,c from Student s, Clazz c where c.id=s.clazz.id and s.name like %:name%")
	Page<Student> findByNameHahaah(@Param("name") String name, Pageable pageable);

	// 返回自定义对象，不支持原生SQL
	@Query(value = "select new com.eadp.vo.StudentVO(s.id,s.name,s.age,s.address,c,s.gender) from Student s, Clazz c where c.id=s.clazz.id and s.name like %:name%")
	Page<StudentVO> findByNameVO(@Param("name") String name, Pageable pageable);
}
