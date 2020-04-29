package com.eadp.dto;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.format.annotation.NumberFormat;
import io.springlets.format.EntityFormat;

/**
 * = StudentDTO
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDTO
@RooJavaBean
@EntityFormat
public class StudentDTO {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long clazzId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer gender;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String name;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer age;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer age1;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer age2;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String address;

    /**
     * Gets clazzId value
     *
     * @return Long
     */
    public Long getClazzId() {
        return this.clazzId;
    }

    /**
     * Sets clazzId value
     *
     * @param clazzId
     * @return StudentDTO
     */
    public StudentDTO setClazzId(Long clazzId) {
        this.clazzId = clazzId;
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
     * @return StudentDTO
     */
    public StudentDTO setGender(Integer gender) {
        this.gender = gender;
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
     * @return StudentDTO
     */
    public StudentDTO setName(String name) {
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
     * @return StudentDTO
     */
    public StudentDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    /**
     * Gets age1 value
     *
     * @return Integer
     */
    public Integer getAge1() {
        return this.age1;
    }

    /**
     * Sets age1 value
     *
     * @param age1
     * @return StudentDTO
     */
    public StudentDTO setAge1(Integer age1) {
        this.age1 = age1;
        return this;
    }

    /**
     * Gets age2 value
     *
     * @return Integer
     */
    public Integer getAge2() {
        return this.age2;
    }

    /**
     * Sets age2 value
     *
     * @param age2
     * @return StudentDTO
     */
    public StudentDTO setAge2(Integer age2) {
        this.age2 = age2;
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
     * @return StudentDTO
     */
    public StudentDTO setAddress(String address) {
        this.address = address;
        return this;
    }
}
