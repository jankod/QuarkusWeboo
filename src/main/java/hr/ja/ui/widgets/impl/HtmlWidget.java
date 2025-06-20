package hr.ja.ui.widgets.impl;


import hr.ja.ui.widgets.Widget;

public class HtmlWidget extends Widget {
    private final String html;

    public HtmlWidget(String html) {
        this.html = html;
    }

    @Override
    public String toHtml() {
        return html;
    }
}
