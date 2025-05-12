package hr.ja.ui;

import hr.ja.ui.widgets.HasChildren;
import hr.ja.ui.widgets.Widget;
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
