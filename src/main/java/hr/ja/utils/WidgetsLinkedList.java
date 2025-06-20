package hr.ja.utils;

import hr.ja.ui.widgets.HtmlRender;
import hr.ja.ui.widgets.Widget;

import java.util.Iterator;
import java.util.LinkedList;

public class WidgetsLinkedList extends LinkedList<Widget> implements HtmlRender {

    @Override
    public String toString() {
        return toHtml();
    }

    @Override
    public String toHtml() {
        Iterator<Widget> it = iterator();
        if (!it.hasNext())
            return "";

        StringBuilder sb = new StringBuilder();
        for (; ; ) {
            Widget widget = it.next();
            sb.append(widget.toHtml());
            if (!it.hasNext())
                return sb.toString();
            sb.append('\n').append(' ');
        }
    }
}
