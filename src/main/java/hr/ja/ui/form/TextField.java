package hr.ja.ui.form;


import hr.ja.ui.widgets.HasClasses;
import hr.ja.utils.QuteUtil;

import java.beans.PropertyDescriptor;
import java.util.Map;

public class TextField extends FormFieldWidget implements HasClasses {

    public TextField(String name, String label) {
        this.name = name;
        this.label = label;
    }

    @Override
    public String toHtml() {
        addClass("mb-3");

        String html = """
              <div {attr.raw}>
                  <label for="{name}" class="form-label">{label}</label>
                  <input type="text" class="form-control {errorClass}" id="{name}" name="{name}" {autofocus} value='{value}' placeholder='{placeholder}'>
                  {#for err in errorMessages}
                  <div class="invalid-feedback">
                      {err}
                  </div>
                  {/for}
              </div>
                           """;
//        return WebooUtil.qute(html, Map.of(
//              "id", this.getWidgetId(),
//              "attr", getIdClassStyleAttr(),
//              "name", name,
//              "label", label,
//              "errorMessages", errorMessages,
//              "errorClass", getErrorClass(),
//              "value", value,
//              "autofocus", isAutofocus() ? "autofocus" : "",
//              "placeholder", placeholder
//        ));
        return QuteUtil.quteThis(html, this);

    }

//    public String getSubmitedValue() {
//        return Context.req().queryParams(name);
//    }

    @Override
    public void bindTo(Object modelObject) {
//        String value = Context.req().queryParams(name);
//        try {
//            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name, modelObject.getClass());
//            propertyDescriptor.getWriteMethod().invoke(modelObject, value);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
