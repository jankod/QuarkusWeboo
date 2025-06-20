package hr.ja.ui.form;

import hr.ja.utils.QuteUtil;
import hr.ja.utils.WebooUtil;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Select extends FormFieldWidget {

    private List<Option> options = new ArrayList<>(5);

    private boolean multiselect = false;

    public Select(String fieldName, String label, Object... keyValues) {
        this.name = fieldName;
        this.label = label;

        for (Pair<Object, Object> pair : WebooUtil.toPairs(keyValues)) {
            options.add(new Option(pair.getKey().toString(), pair.getValue().toString(), false));
        }
    }

    public Select(String fieldName, String label, List<Option> options) {
        super();
        this.name = fieldName;
        this.label = label;
        this.options = options;
    }

    public void selected(Object key) {
        this.value = key.toString();
        for (Option option : options) {
            if (option.getKey().equals(key.toString())) {
                option.setSelected(true);
                return;
            }
        }
    }

    @Override
    public String toHtml() {
        String h = """
              <div class="mb-3" id="{id}">
                  <label for="{name}" class="form-label" id="{id}">{label}</label>
                  <select class="form-select {errorClass}" {multiselect ? 'multiple' : ''} name="{name}" id="{name}" {autofocus}>
                     {#for item in options}
                           <option value='{item.key}' {item.selected ? 'selected' : ''} {item.disable ? 'disabled' : ''}  >{item.label}</option>
                      {/for}
                  </select>
                 {#for err in errMsgs}
                      <div class="invalid-feedback">
                          {err}
                      </div>
                  {/for}
              </div>
              """;
        return QuteUtil.quteMap(h, Map.of(
              "name", name,
              "label", label,
              "id", this.getWidgetId(),
              "options", options,
              "multiselect", multiselect,
              "errorClass", getErrorClass(),
              "errMsgs", errorMessages,
              "autofocus", isAutofocus() ? "autofocus" : ""
        ));
    }

    public String getSubmitedValue() {
        com.fasterxml.jackson.databind.DatabindContext s;
//        return Context.req().queryParams(name);
        return "???M;issing???";
    }


    public Option addOption(Object key, String value) {
        Option o = new Option(key.toString(), value, false);
        addOption(o);
        return o;
    }

    public void addOption(Option option) {
        this.options.add(option);
    }

    @Override
    public void bindTo(Object modelObject) {
        if (multiselect) {
       //     String[] values = Context.req().queryParamsValues(name);
        } else {
         //   String value = Context.req().queryParams(name);
        }
    }
}
