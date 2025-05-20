package hr.ja.ui.widgets;

import hr.ja.ui.DefaultWidget;
import hr.ja.utils.QuteUtil;
import hr.ja.utils.WebooUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Button extends DefaultWidget implements HasClasses {
    private final String label;

    private Color color = Color.PRIMARY;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public String toHtml() {
        addClass("btn btn-" + color.toCssClass());

        String html = """
                <button type="button" class="${classes}"  id="${widgetId}">
                    ${label}
                </button>
                """;
        return QuteUtil.quteThis(html, this);
    }

    public static void main(String[] args) {
        Button button = new Button("Click Me");
        button.addClass("btn-lg");
        System.out.println(button.toHtml());
    }
}
