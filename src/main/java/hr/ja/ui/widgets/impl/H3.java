package hr.ja.ui.widgets.impl;


import hr.ja.ui.widgets.CompositeWidget;
import hr.ja.ui.widgets.HasClasses;
import hr.ja.utils.QuteUtil;
import lombok.Getter;

@Getter
public class H3 extends CompositeWidget implements HasClasses {

    private final String text;

    public H3(String text) {
        this.text = text;
    }

    @Override
    public String toHtml() {
        return QuteUtil.quteThis(
                """
                        <h3 id="${widgetId}" >
                            {this.text}
                            ${children.raw}
                        </h3>
                        """, this);

    }

    public static void main(String[] args) {
        H3 h3 = new H3("My H3");
        h3.add(new Div("Hello"));
        System.out.println(h3.toHtml());
    }
}
