package com.eadp.service;
import com.eadp.entity.Clazz;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = ClazzService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Clazz.class)
public interface ClazzService extends EntityResolver<Clazz, Long>, ValidatorService<Clazz> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Clazz
     */
    public abstract Clazz findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     */
    public abstract void delete(Clazz clazz);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Clazz> save(Iterable<Clazz> entities);

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
     * @return Clazz
     */
    public abstract Clazz save(Clazz entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Clazz
     */
    public abstract Clazz findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Clazz> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Clazz> findAll();

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
    public abstract Page<Clazz> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Clazz> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @param studentsToAdd
     * @return Clazz
     */
    public abstract Clazz addToStudents(Clazz clazz, Iterable<Long> studentsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @param studentsToRemove
     * @return Clazz
     */
    public abstract Clazz removeFromStudents(Clazz clazz, Iterable<Long> studentsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @param students
     * @return Clazz
     */
    public abstract Clazz setStudents(Clazz clazz, Iterable<Long> students);
}
