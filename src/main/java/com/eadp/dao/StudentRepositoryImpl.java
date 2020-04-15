package com.eadp.dao;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.eadp.entity.Student;
import com.eadp.dto.StudentDTO;
import com.eadp.entity.Clazz;
import com.eadp.entity.QStudent;
import com.eadp.vo.StudentVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * = StudentRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = StudentRepositoryCustom.class)
@Transactional(readOnly = true)
public class StudentRepositoryImpl extends QueryDslRepositorySupportExt<Student> implements StudentRepositoryCustom {

    /**
     * Default constructor
     */
    StudentRepositoryImpl() {
        super(Student.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ADDRESS = "address";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String GENDER = "gender";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CLAZZ = "clazz";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ID = "id";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String NAME = "name";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String AGE = "age";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Student> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QStudent student = QStudent.student;
        JPQLQuery<Student> query = from(student);
        Path<?>[] paths = new Path<?>[] { student.name, student.age, student.address, student.gender, student.clazz };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, student.name).map(AGE, student.age).map(ADDRESS, student.address).map(GENDER, student.gender).map(CLAZZ, student.clazz);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, student);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Student> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QStudent student = QStudent.student;
        JPQLQuery<Student> query = from(student);
        Path<?>[] paths = new Path<?>[] { student.name, student.age, student.address, student.gender, student.clazz };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(student.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(NAME, student.name).map(AGE, student.age).map(ADDRESS, student.address).map(GENDER, student.gender).map(CLAZZ, student.clazz);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, student);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Student> findByClazz(Clazz clazz, GlobalSearch globalSearch, Pageable pageable) {
        QStudent student = QStudent.student;
        JPQLQuery<Student> query = from(student);
        Assert.notNull(clazz, "clazz is required");
        query.where(student.clazz.eq(clazz));
        Path<?>[] paths = new Path<?>[] { student.name, student.age, student.address, student.gender, student.clazz };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, student.name).map(AGE, student.age).map(ADDRESS, student.address).map(GENDER, student.gender).map(CLAZZ, student.clazz);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, student);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<StudentVO> findByNameLike(StudentDTO formBean, GlobalSearch globalSearch, Pageable pageable) {
        QStudent student = QStudent.student;
        JPQLQuery<Student> query = from(student);
        if (formBean != null) {
            BooleanBuilder searchCondition = new BooleanBuilder();
            if (formBean.getName() != null) {
                searchCondition.and(student.name.like(formBean.getName()));
            }
            if (searchCondition.hasValue()) {
                query.where(searchCondition);
            }
        }
        Path<?>[] paths = new Path<?>[] { student.id, student.name, student.age, student.address, student.clazz, student.gender };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(ID, student.id).map(NAME, student.name).map(AGE, student.age).map(ADDRESS, student.address).map(CLAZZ, student.clazz).map(GENDER, student.gender);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, Projections.constructor(StudentVO.class, student.id, student.name, student.age, student.address, student.clazz, student.gender));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<StudentVO> findByAgeGreaterThan(StudentDTO formBean, GlobalSearch globalSearch, Pageable pageable) {
        QStudent student = QStudent.student;
        JPQLQuery<Student> query = from(student);
        if (formBean != null) {
            BooleanBuilder searchCondition = new BooleanBuilder();
            if (formBean.getAge() != null) {
                searchCondition.and(student.age.gt(formBean.getAge()));
            }
            if (searchCondition.hasValue()) {
                query.where(searchCondition);
            }
        }
        Path<?>[] paths = new Path<?>[] { student.id, student.name, student.age, student.address, student.clazz, student.gender };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(ID, student.id).map(NAME, student.name).map(AGE, student.age).map(ADDRESS, student.address).map(CLAZZ, student.clazz).map(GENDER, student.gender);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, Projections.constructor(StudentVO.class, student.id, student.name, student.age, student.address, student.clazz, student.gender));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<StudentVO> findByAgeLessThan(StudentDTO formBean, GlobalSearch globalSearch, Pageable pageable) {
        QStudent student = QStudent.student;
        JPQLQuery<Student> query = from(student);
        if (formBean != null) {
            BooleanBuilder searchCondition = new BooleanBuilder();
            if (formBean.getAge() != null) {
                searchCondition.and(student.age.lt(formBean.getAge()));
            }
            if (searchCondition.hasValue()) {
                query.where(searchCondition);
            }
        }
        Path<?>[] paths = new Path<?>[] { student.id, student.name, student.age, student.address, student.clazz, student.gender };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(ID, student.id).map(NAME, student.name).map(AGE, student.age).map(ADDRESS, student.address).map(CLAZZ, student.clazz).map(GENDER, student.gender);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, Projections.constructor(StudentVO.class, student.id, student.name, student.age, student.address, student.clazz, student.gender));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByNameLike(StudentDTO formBean) {
        QStudent student = QStudent.student;
        JPQLQuery<Student> query = from(student);
        BooleanBuilder searchCondition = new BooleanBuilder();
        if (formBean.getName() != null) {
            searchCondition.and(student.name.like(formBean.getName()));
        }
        if (searchCondition.hasValue()) {
            query.where(searchCondition);
        }
        return query.fetchCount();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByAgeGreaterThan(StudentDTO formBean) {
        QStudent student = QStudent.student;
        JPQLQuery<Student> query = from(student);
        BooleanBuilder searchCondition = new BooleanBuilder();
        if (formBean.getAge() != null) {
            searchCondition.and(student.age.gt(formBean.getAge()));
        }
        if (searchCondition.hasValue()) {
            query.where(searchCondition);
        }
        return query.fetchCount();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByAgeLessThan(StudentDTO formBean) {
        QStudent student = QStudent.student;
        JPQLQuery<Student> query = from(student);
        BooleanBuilder searchCondition = new BooleanBuilder();
        if (formBean.getAge() != null) {
            searchCondition.and(student.age.lt(formBean.getAge()));
        }
        if (searchCondition.hasValue()) {
            query.where(searchCondition);
        }
        return query.fetchCount();
    }
}
