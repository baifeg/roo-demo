package com.eadp.controller;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooLinkFactory;
import io.springlets.web.mvc.util.MethodLinkFactory;
import io.springlets.web.mvc.util.SpringletsMvcUriComponentsBuilder;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

/**
 * = StudentsSearchJsonLinkFactory
 *
 * TODO Auto-generated class documentation
 *
 */
@RooLinkFactory(controller = StudentsSearchJsonController.class)
@Component
public class StudentsSearchJsonLinkFactory implements MethodLinkFactory<StudentsSearchJsonController> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYAGEGREATERTHAN = "byAgeGreaterThan";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYNAMELIKE = "byNameLike";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYAGELESSTHAN = "byAgeLessThan";

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<StudentsSearchJsonController> getControllerClass() {
        return StudentsSearchJsonController.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param methodName
     * @param parameters
     * @param pathVariables
     * @return UriComponents
     */
    public UriComponents toUri(String methodName, Object[] parameters, Map<String, Object> pathVariables) {
        if (methodName.equals(BYNAMELIKE)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byNameLike(null, null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYAGEGREATERTHAN)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byAgeGreaterThan(null, null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYAGELESSTHAN)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byAgeLessThan(null, null, null)).buildAndExpand(pathVariables);
        }
        throw new IllegalArgumentException("Invalid method name: " + methodName);
    }
}
