package com.eadp.entity;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import io.springlets.format.EntityFormat;
import java.util.Objects;
import javax.persistence.Entity;
import org.springframework.util.Assert;

/**
 * = Clazz
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity
@RooEquals(isJpaEntity = true)
@Entity
@EntityFormat
public class Clazz {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Version
    private Integer version;

    /**
     * 名称
     */
    private String name;

    /**
     * 班主任ID
     */
    private String teacherId;

    /**
     * 学生列表
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "clazz")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private List<Student> students = new ArrayList<Student>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * Gets id value
     *
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets id value
     *
     * @param id
     * @return Clazz
     */
    public Clazz setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Gets version value
     *
     * @return Integer
     */
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Sets version value
     *
     * @param version
     * @return Clazz
     */
    public Clazz setVersion(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Gets name value
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name value
     *
     * @param name
     * @return Clazz
     */
    public Clazz setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets teacherId value
     *
     * @return String
     */
    public String getTeacherId() {
        return this.teacherId;
    }

    /**
     * Sets teacherId value
     *
     * @param teacherId
     * @return Clazz
     */
    public Clazz setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    /**
     * Gets students value
     *
     * @return List
     */
    public List<Student> getStudents() {
        return this.students;
    }

    /**
     * Sets students value
     *
     * @param students
     * @return Clazz
     */
    public Clazz setStudents(List<Student> students) {
        this.students = students;
        return this;
    }

    /**
     * This `equals` implementation is specific for JPA entities and uses
     * the entity identifier for it, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // instanceof is false if the instance is null
        if (!(obj instanceof Clazz)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Clazz) obj).getId());
    }

    /**
     * This `hashCode` implementation is specific for JPA entities and uses a fixed `int` value to be able
     * to identify the entity in collections after a new id is assigned to the entity, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @return Integer
     */
    public int hashCode() {
        return 31;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "Clazz {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", teacherId='" + teacherId + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param studentsToAdd
     */
    public void addToStudents(Iterable<Student> studentsToAdd) {
        Assert.notNull(studentsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Student item : studentsToAdd) {
            this.students.add(item);
            item.setClazz(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param studentsToRemove
     */
    public void removeFromStudents(Iterable<Student> studentsToRemove) {
        Assert.notNull(studentsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Student item : studentsToRemove) {
            this.students.remove(item);
            item.setClazz(null);
        }
    }
}
