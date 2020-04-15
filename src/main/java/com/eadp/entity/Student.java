package com.eadp.entity;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import org.springframework.format.annotation.NumberFormat;
import io.springlets.format.EntityFormat;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;
import javax.persistence.Entity;

/**
 * = Student
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
public class Student {

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
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    @NumberFormat
    private Integer age;

    /**
     * 地址
     */
    private String address;

    /**
     * 性别
     */
    @NumberFormat
    private Integer gender;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clazzId")
    @EntityFormat
    private Clazz clazz;

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
     * @return Student
     */
    public Student setId(Long id) {
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
     * @return Student
     */
    public Student setVersion(Integer version) {
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
     * @return Student
     */
    public Student setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets age value
     *
     * @return Integer
     */
    public Integer getAge() {
        return this.age;
    }

    /**
     * Sets age value
     *
     * @param age
     * @return Student
     */
    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    /**
     * Gets address value
     *
     * @return String
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets address value
     *
     * @param address
     * @return Student
     */
    public Student setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Gets gender value
     *
     * @return Integer
     */
    public Integer getGender() {
        return this.gender;
    }

    /**
     * Sets gender value
     *
     * @param gender
     * @return Student
     */
    public Student setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Gets clazz value
     *
     * @return Clazz
     */
    public Clazz getClazz() {
        return this.clazz;
    }

    /**
     * Sets clazz value
     *
     * @param clazz
     * @return Student
     */
    public Student setClazz(Clazz clazz) {
        this.clazz = clazz;
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
        if (!(obj instanceof Student)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Student) obj).getId());
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
        return "Student {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", age='" + age + '\'' + ", address='" + address + '\'' + ", gender='" + gender + '\'' + "}" + super.toString();
    }
}
