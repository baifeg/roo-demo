package com.eadp.service.impl;
import com.eadp.service.Teacher1Service;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.eadp.dao.Teacher1Dao;
import com.eadp.dao.Teacher1Repository;
import com.eadp.entity.Teacher1;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = Teacher1ServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = Teacher1Service.class)
@Service
@Transactional(readOnly = true)
public class Teacher1ServiceImpl implements Teacher1Service {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private Teacher1Repository teacher1Repository;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private Teacher1Dao teacher1Dao;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param teacher1Repository
     */
    @Autowired
    public Teacher1ServiceImpl(Teacher1Repository teacher1Repository) {
        setTeacher1Repository(teacher1Repository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Teacher1Repository
     */
    public Teacher1Repository getTeacher1Repository() {
        return teacher1Repository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1Repository
     */
    public void setTeacher1Repository(Teacher1Repository teacher1Repository) {
        this.teacher1Repository = teacher1Repository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Teacher1Dao
     */
    public Teacher1Dao getTeacher1Dao() {
        return teacher1Dao;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1Dao
     */
    public void setTeacher1Dao(Teacher1Dao teacher1Dao) {
        this.teacher1Dao = teacher1Dao;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Teacher1 teacher1) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1
     */
    @Transactional
    public void delete(Teacher1 teacher1) {
        getTeacher1Repository().delete(teacher1);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Teacher1> save(Iterable<Teacher1> entities) {
        return getTeacher1Repository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Teacher1> toDelete = getTeacher1Repository().findAll(ids);
        getTeacher1Repository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Teacher1
     */
    @Transactional
    public Teacher1 save(Teacher1 entity) {
        return getTeacher1Repository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Teacher1
     */
    public Teacher1 findOne(Long id) {
        return getTeacher1Repository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Teacher1
     */
    public Teacher1 findOneForUpdate(Long id) {
        return getTeacher1Repository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Teacher1> findAll(Iterable<Long> ids) {
        return getTeacher1Repository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Teacher1> findAll() {
        return getTeacher1Repository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getTeacher1Repository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Teacher1> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getTeacher1Repository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Teacher1> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getTeacher1Repository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Teacher1> getEntityType() {
        return Teacher1.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
