package com.eadp.controller;
import com.eadp.entity.Clazz;
import com.eadp.service.ClazzService;
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
 * = ClazzDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Clazz.class)
@JsonComponent
public class ClazzDeserializer extends JsonObjectDeserializer<Clazz> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ClazzService clazzService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param clazzService
     * @param conversionService
     */
    @Autowired
    public ClazzDeserializer(@Lazy ClazzService clazzService, ConversionService conversionService) {
        this.clazzService = clazzService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ClazzService
     */
    public ClazzService getClazzService() {
        return clazzService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazzService
     */
    public void setClazzService(ClazzService clazzService) {
        this.clazzService = clazzService;
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
     * @return Clazz
     */
    public Clazz deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Clazz clazz = clazzService.findOne(id);
        if (clazz == null) {
            throw new NotFoundException("Clazz not found");
        }
        return clazz;
    }
}
