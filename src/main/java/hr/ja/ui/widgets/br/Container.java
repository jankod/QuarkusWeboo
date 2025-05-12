package hr.ja.ui.widgets.br;


import hr.ja.ui.CompositeWidget;
import hr.ja.utils.WebooUtil;

import java.util.Map;

public class Container extends CompositeWidget {

    @Override
    public String toHtml() {
        String html = """
                <div class="container-fluid" id='{widgetId}'>
                {children}
                </div>
                """;
        return WebooUtil.quteMap(html, Map.of(
        ));

    }
}
