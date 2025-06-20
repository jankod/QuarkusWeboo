package hr.ja.ui;


import hr.ja.ui.layout.Layout;
import hr.ja.ui.widgets.HtmlRender;
import hr.ja.ui.widgets.Widget;
import hr.ja.utils.CallerInfo;
import hr.ja.utils.WebooUtil;
import hr.ja.utils.WidgetsLinkedList;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Data
public abstract class Page implements HtmlRender {

    private String pageId = WebooUtil.createPageId();

    private String title = "";

    private final WidgetsLinkedList widgets = new WidgetsLinkedList();

    private Layout layout;

    public <T extends Widget> T add(T widget) {
        widgets.add(widget);
        if (WebooUtil.isDebug()) {
            CallerInfo callerInfo = WebooUtil.getCallerInfo(3);
            callerInfo.setWidgetId(widget.widgetId());
            callerInfo.setWidgetName(widget.getClass().getSimpleName());
            widget.setDebugCallerInfo(callerInfo);
        }
        return widget;
    }

}
