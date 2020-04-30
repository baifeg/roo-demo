package com.eadp.dao;
import com.eadp.entity.Student;
import com.slyak.spring.jpa.GenericJpaRepository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = StudentDao
 *
 * TODO Auto-generated class documentation
 *
 */
public interface StudentDao extends GenericJpaRepository<Student, Long>, DetachableJpaRepository<Student, Long> {
}
