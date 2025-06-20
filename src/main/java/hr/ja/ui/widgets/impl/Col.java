package hr.ja.ui.widgets.impl;


import hr.ja.ui.widgets.Widget;

public class Col extends SimpleTag {

    public Col(String text) {
        this(new JustText(text));
    }

    public Col(Widget... widgets) {
        super("div", widgets);
    }

}
