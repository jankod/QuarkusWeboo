package hr.ja.ui.form;

import hr.ja.ui.widgets.DefaultWidget;
import hr.ja.ui.widgets.Widget;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public abstract class FormFieldWidget extends DefaultWidget {

    protected String name = "";
    protected String label = "";
    protected String value = "";

    protected String placeholder = "";

    private boolean autofocus = false;

    protected List<String> errorMessages = new ArrayList<>();

    public void addErrorMessage(String errorMessage) {
        errorMessages.add(errorMessage);
    }

    public void autofocus() {
        this.autofocus = true;
    }

    public String getErrorClass() {
        String errorClass = "";
        if (errorMessages == null || errorMessages.isEmpty()) {
            errorClass = "is-valid";
        }

        return errorClass;
    }

    public abstract void bindTo(Object modelObject);
}
