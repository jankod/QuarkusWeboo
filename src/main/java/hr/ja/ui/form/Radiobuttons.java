package hr.ja.ui.form;

import org.intellij.lang.annotations.Language;

public class Radiobuttons extends FormFieldWidget {


    @Override
    public String toHtml() {
        @Language("HTML")
        String template = """
                {#for item in options}
                <div class="form-check" {autofocus}>
                    <input class="form-check-input" type="radio" name="{item.key}" s>
                    <label class="form-check-label" for="{name}">
                        {item.label}
                    </label>
                </div>
                {/for}
                """;
        return template;
    }

    @Override
    public void bindTo(Object modelObject) {
        throw new RuntimeException("not implemented yet");
    }
}
