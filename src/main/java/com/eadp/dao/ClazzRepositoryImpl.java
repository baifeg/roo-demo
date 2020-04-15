package com.eadp.dao;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.eadp.entity.Clazz;
import com.eadp.entity.QClazz;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = ClazzRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = ClazzRepositoryCustom.class)
@Transactional(readOnly = true)
public class ClazzRepositoryImpl extends QueryDslRepositorySupportExt<Clazz> implements ClazzRepositoryCustom {

    /**
     * Default constructor
     */
    ClazzRepositoryImpl() {
        super(Clazz.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String TEACHER_ID = "teacherId";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String NAME = "name";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Clazz> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QClazz clazz = QClazz.clazz;
        JPQLQuery<Clazz> query = from(clazz);
        Path<?>[] paths = new Path<?>[] { clazz.name, clazz.teacherId };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, clazz.name).map(TEACHER_ID, clazz.teacherId);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, clazz);
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
        QClazz clazz = QClazz.clazz;
        JPQLQuery<Clazz> query = from(clazz);
        Path<?>[] paths = new Path<?>[] { clazz.name, clazz.teacherId };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(clazz.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(NAME, clazz.name).map(TEACHER_ID, clazz.teacherId);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, clazz);
    }
}
