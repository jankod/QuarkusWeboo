package hr.ja.ui.widgets;

import hr.ja.utils.WidgetsLinkedList;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompositeWidget extends DefaultWidget implements HasChildren {

    private final WidgetsLinkedList children = new WidgetsLinkedList();

    @Override
    public String toHtml() {
        StringBuilder html = new StringBuilder();
        for (Widget widget : getChildren()) {
            html.append(widget.toHtml()).append("\n");
        }
        return html.toString();
    }
}
