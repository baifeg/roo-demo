package com.eadp.vo;
import com.eadp.entity.Clazz;
import com.eadp.entity.Student;
import io.springlets.format.EntityFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooEntityProjection;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * = StudentVO
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean(settersByDefault = false)
@RooToString
@RooEquals
@RooEntityProjection(entity = Student.class, fields = { "id", "name", "age", "address", "clazz", "gender" })
@EntityFormat
public class StudentVO {

    private Long id;

    /**
     * 姓名
     */
    private String name;

    @NumberFormat
    private Integer age;

    /**
     * 地址
     */
    private String address;

    @EntityFormat
    private Clazz clazz;

    @NumberFormat
    private Integer gender;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param id
     * @param name
     * @param age
     * @param address
     * @param clazz
     * @param gender
     */
    public StudentVO(Long id, String name, Integer age, String address, Clazz clazz, Integer gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.clazz = clazz;
        this.gender = gender;
    }

    /**
     * Gets id value
     *
     * @return Long
     */
    public Long getId() {
        return this.id;
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
     * Gets age value
     *
     * @return Integer
     */
    public Integer getAge() {
        return this.age;
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
     * Gets clazz value
     *
     * @return Clazz
     */
    public Clazz getClazz() {
        return this.clazz;
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
     * TODO Auto-generated method documentation
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof StudentVO)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        StudentVO rhs = (StudentVO) obj;
        return new EqualsBuilder().append(address, rhs.address).append(age, rhs.age).append(clazz, rhs.clazz).append(gender, rhs.gender).append(id, rhs.id).append(name, rhs.name).isEquals();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public int hashCode() {
        return new HashCodeBuilder().append(address).append(age).append(clazz).append(gender).append(id).append(name).toHashCode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "StudentVO {" + "id='" + id + '\'' + ", name='" + name + '\'' + ", age='" + age + '\'' + ", address='" + address + '\'' + ", gender='" + gender + '\'' + "}" + super.toString();
    }
}
