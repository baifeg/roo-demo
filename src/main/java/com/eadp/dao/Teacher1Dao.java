package com.eadp.dao;
import com.eadp.entity.Teacher1;
import com.slyak.spring.jpa.GenericJpaRepository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = Teacher1Dao
 *
 * TODO Auto-generated class documentation
 *
 */
public interface Teacher1Dao extends GenericJpaRepository<Teacher1, Long>, DetachableJpaRepository<Teacher1, Long> {
}
