package hr.ja.ui.widgets;

import hr.ja.ui.widgets.impl.Col;
import hr.ja.ui.widgets.impl.H3;
import hr.ja.ui.widgets.impl.Row;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Widgets {

    public Row row(Widget... widgets) {
        return new Row(widgets);
    }

    public static H3 h3(String text) {
        return new H3(text);
    }

    public static Col col(Widget widget) {
        return new Col(widget);
    }
}
