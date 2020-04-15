package com.eadp.dao;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.eadp.entity.Teacher1;
import com.eadp.entity.QTeacher1;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = Teacher1RepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = Teacher1RepositoryCustom.class)
@Transactional(readOnly = true)
public class Teacher1RepositoryImpl extends QueryDslRepositorySupportExt<Teacher1> implements Teacher1RepositoryCustom {

    /**
     * Default constructor
     */
    Teacher1RepositoryImpl() {
        super(Teacher1.class);
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
    public Page<Teacher1> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QTeacher1 teacher1 = QTeacher1.teacher1;
        JPQLQuery<Teacher1> query = from(teacher1);
        Path<?>[] paths = new Path<?>[] { teacher1.name, teacher1.age, teacher1.address };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, teacher1.name).map(AGE, teacher1.age).map(ADDRESS, teacher1.address);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, teacher1);
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
        QTeacher1 teacher1 = QTeacher1.teacher1;
        JPQLQuery<Teacher1> query = from(teacher1);
        Path<?>[] paths = new Path<?>[] { teacher1.name, teacher1.age, teacher1.address };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(teacher1.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(NAME, teacher1.name).map(AGE, teacher1.age).map(ADDRESS, teacher1.address);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, teacher1);
    }
}
