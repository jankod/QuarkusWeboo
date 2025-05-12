package hr.ja.ui;



import hr.ja.ui.layout.Layout;
import hr.ja.ui.widgets.Widget;
import hr.ja.utils.CallerInfo;
import hr.ja.utils.WebooUtil;
import hr.ja.utils.WidgetsLinkedList;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


@Slf4j
@Data
public abstract class Page implements HtmlRenderable {

    private String pageId = WebooUtil.createPageId();

    private String title = "";

    private final WidgetsLinkedList widgets = new WidgetsLinkedList();

    private Layout layout;

    protected void dump(Object object) {
        String json = WebooUtil.toJson(object);
        log.debug("Dumping object: {}", json);
    }

    public <T extends Widget> T add(T widget) {
        widgets.add(widget);
        if (WebooUtil.isDebug()) {
//            if (widget instanceof CompositeWidget) {
//                return widget;
//            }
            CallerInfo callerInfo = WebooUtil.getCallerInfo(3);
            callerInfo.setWidgetId(widget.widgetId());
            callerInfo.setWidgetName(widget.getClass().getSimpleName());
            widget.setDebugCallerInfo(callerInfo);
        }
        return widget;
    }
//    @Override
//    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//
//        WebPageContext context = new WebPageContext();
//        context.setModel(model);
//        context.setRequest(request);
//        context.setResponse(response);
//
//        render(context);
//
//        if (WebooUtil.isDebug()) {
//
//            // add before and after widget html comment with widget id and name
//            for (Widget widget : widgets) {
//
//                String comment = "<!-- " + widget.getClass().getSimpleName() + " id: " + widget.widgetId() + " --> ";
//                //   String html = pageWidgets.stream().map(Widget::toHtml).collect(Collectors.joining(comment));
//            }
//        }
//
//        if (layout == null) {
//            layout = new TablerLayout();
//        }
//
//        String html = layout.toHtml(context, this);
//
//        response.getWriter().write(html);
//    }



}
