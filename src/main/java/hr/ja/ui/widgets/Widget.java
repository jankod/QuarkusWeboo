package hr.ja.ui.widgets;

import hr.ja.ui.js.DualSideEvent;
import hr.ja.utils.CallerInfo;
import hr.ja.utils.WebooUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Slf4j
public abstract class Widget implements HtmlRender {

    private String widgetId = null;

    private final List<DualSideEvent> dualSideEvents = new ArrayList<>();

    public DualSideEvent on(String eventName) {
        DualSideEvent clientEvent = new DualSideEvent(eventName, widgetId);
        dualSideEvents.add(clientEvent);
        return clientEvent;
    }

    @Getter
    @Setter
    private CallerInfo debugCallerInfo;

    public String widgetId() {
        if (widgetId == null) {
            widgetId = WebooUtil.wigetNewId(this.getClass());
        }
        return widgetId;
    }

    public String getWidgetId() {
        return widgetId();
    }

//    public abstract String toHtml();

    public String toString() {
        return toHtml();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getWidgetId());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Widget) {
            return widgetId().equals(((Widget) obj).widgetId());
        }
        return false;
    }
}
