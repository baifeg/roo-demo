package com.eadp.service.impl;
import com.eadp.service.ClazzService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.eadp.dao.ClazzDao;
import com.eadp.dao.ClazzRepository;
import com.eadp.entity.Clazz;
import com.eadp.entity.Student;
import com.eadp.service.StudentService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = ClazzServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = ClazzService.class)
@Service
@Transactional(readOnly = true)
public class ClazzServiceImpl implements ClazzService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ClazzDao clazzDao;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private StudentService studentService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ClazzRepository clazzRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param clazzRepository
     * @param studentService
     */
    @Autowired
    public ClazzServiceImpl(ClazzRepository clazzRepository, @Lazy StudentService studentService) {
        setClazzRepository(clazzRepository);
        setStudentService(studentService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ClazzRepository
     */
    public ClazzRepository getClazzRepository() {
        return clazzRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazzRepository
     */
    public void setClazzRepository(ClazzRepository clazzRepository) {
        this.clazzRepository = clazzRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ClazzDao
     */
    public ClazzDao getClazzDao() {
        return clazzDao;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazzDao
     */
    public void setClazzDao(ClazzDao clazzDao) {
        this.clazzDao = clazzDao;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return StudentService
     */
    public StudentService getStudentService() {
        return studentService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param studentService
     */
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Clazz clazz) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @param studentsToAdd
     * @return Clazz
     */
    @Transactional
    public Clazz addToStudents(Clazz clazz, Iterable<Long> studentsToAdd) {
        List<Student> students = getStudentService().findAll(studentsToAdd);
        clazz.addToStudents(students);
        return getClazzRepository().save(clazz);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @param studentsToRemove
     * @return Clazz
     */
    @Transactional
    public Clazz removeFromStudents(Clazz clazz, Iterable<Long> studentsToRemove) {
        List<Student> students = getStudentService().findAll(studentsToRemove);
        clazz.removeFromStudents(students);
        return getClazzRepository().save(clazz);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @param students
     * @return Clazz
     */
    @Transactional
    public Clazz setStudents(Clazz clazz, Iterable<Long> students) {
        List<Student> items = getStudentService().findAll(students);
        List<Student> currents = clazz.getStudents();
        Set<Student> toRemove = new HashSet<Student>();
        for (Iterator<Student> iterator = currents.iterator(); iterator.hasNext(); ) {
            Student nextStudent = iterator.next();
            if (items.contains(nextStudent)) {
                items.remove(nextStudent);
            } else {
                toRemove.add(nextStudent);
            }
        }
        clazz.removeFromStudents(toRemove);
        clazz.addToStudents(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        clazz.setVersion(clazz.getVersion() + 1);
        return getClazzRepository().save(clazz);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     */
    @Transactional
    public void delete(Clazz clazz) {
        // Clear bidirectional one-to-many parent relationship with Student
        for (Student item : clazz.getStudents()) {
            item.setClazz(null);
        }
        getClazzRepository().delete(clazz);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Clazz> save(Iterable<Clazz> entities) {
        return getClazzRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Clazz> toDelete = getClazzRepository().findAll(ids);
        getClazzRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Clazz
     */
    @Transactional
    public Clazz save(Clazz entity) {
        return getClazzRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Clazz
     */
    public Clazz findOne(Long id) {
        return getClazzRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Clazz
     */
    public Clazz findOneForUpdate(Long id) {
        return getClazzRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Clazz> findAll(Iterable<Long> ids) {
        return getClazzRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Clazz> findAll() {
        return getClazzRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getClazzRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Clazz> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getClazzRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Clazz> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getClazzRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Clazz> getEntityType() {
        return Clazz.class;
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
