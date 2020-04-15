package com.eadp.controller;
import com.eadp.entity.Teacher1;
import com.eadp.service.Teacher1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = Teacher1Deserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Teacher1.class)
@JsonComponent
public class Teacher1Deserializer extends JsonObjectDeserializer<Teacher1> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private Teacher1Service teacher1Service;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param teacher1Service
     * @param conversionService
     */
    @Autowired
    public Teacher1Deserializer(@Lazy Teacher1Service teacher1Service, ConversionService conversionService) {
        this.teacher1Service = teacher1Service;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Teacher1Service
     */
    public Teacher1Service getTeacher1Service() {
        return teacher1Service;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1Service
     */
    public void setTeacher1Service(Teacher1Service teacher1Service) {
        this.teacher1Service = teacher1Service;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return Teacher1
     */
    public Teacher1 deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Teacher1 teacher1 = teacher1Service.findOne(id);
        if (teacher1 == null) {
            throw new NotFoundException("Teacher1 not found");
        }
        return teacher1;
    }
}
