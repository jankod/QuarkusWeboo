package hr.ja.ui.widgets.impl;


import hr.ja.ui.widgets.Widget;

public class JustText extends Widget {
    private final String text;

    public JustText(String text) {
        this.text = text;
    }

    @Override
    public String toHtml() {
        return text;
    }
}
