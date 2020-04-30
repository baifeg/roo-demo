package com.eadp.dao;
import com.eadp.entity.Clazz;
import com.slyak.spring.jpa.GenericJpaRepository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = ClazzDao
 *
 * TODO Auto-generated class documentation
 *
 */
public interface ClazzDao extends GenericJpaRepository<Clazz, Long>, DetachableJpaRepository<Clazz, Long> {
}
