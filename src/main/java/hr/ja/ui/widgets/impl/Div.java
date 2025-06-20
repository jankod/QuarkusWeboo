package hr.ja.ui.widgets.impl;


import hr.ja.ui.widgets.HasClasses;
import hr.ja.ui.widgets.Widget;

public class Div extends SimpleTag implements HasClasses {

    public Div(Widget... widgets) {
        super("div", widgets);
    }

    public Div(String text) {
        super("div");
        super.setText(text);
    }

    public Div(String text, String classes) {
        this(text);
        addClass(classes);
    }

    public static void main(String[] args) {
        Div div = new Div(new Col());
        div.setAttribute("title", "value");
        System.out.println(div.toHtml());
    }
}
