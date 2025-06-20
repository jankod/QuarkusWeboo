package hr.ja.ui.form;

import com.fasterxml.jackson.core.JsonProcessingException;
import hr.ja.utils.WebooUtil;
import jakarta.validation.ConstraintViolation;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class FormData {

    public String getValue(String fieldName) {
       // return Context.req().queryParams(fieldName);
        return "???M;issing???";
    }

    public <T> ValidationResult<T> bindAndValidate(Class<T> clazz) {
        ValidationResult<T> validationResult = new ValidationResult<T>();
        //String json = Context.req().body();
        String json = "{\"name\":\"Marko\",\"role\":\"ADMIN\"}";
        //  log.debug("Json body: {}", json);
        try {
            T obj = WebooUtil.fromJson(json, clazz);
            validationResult.setModel(obj);
            //Set<ConstraintViolation<T>> constraintViolations = WebooUtil.validate(obj);
            Set<ConstraintViolation<T>> constraintViolations = null;
            AjaxFormResult ajaxResult = new AjaxFormResult(constraintViolations);
            validationResult.setAjaxResult(ajaxResult);

        } catch (JsonProcessingException e) {
            log.debug("Error ", e);
            validationResult.addFormError("Error on processing form: "+ e.getMessage() + ".");
        }
        return validationResult;

    }

}
