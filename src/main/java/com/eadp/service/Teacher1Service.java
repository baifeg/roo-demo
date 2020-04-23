package com.eadp.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooService;

import com.eadp.entity.Teacher1;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;

/**
 * = Teacher1Service
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Teacher1.class)
public interface Teacher1Service extends EntityResolver<Teacher1, Long>, ValidatorService<Teacher1> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Teacher1
     */
    public abstract Teacher1 findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1
     */
    public abstract void delete(Teacher1 teacher1);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Teacher1> save(Iterable<Teacher1> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Teacher1
     */
    public abstract Teacher1 save(Teacher1 entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Teacher1
     */
//    public abstract Teacher1 findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Teacher1> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Teacher1> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Teacher1> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Teacher1> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
