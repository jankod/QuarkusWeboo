package hr.ja.ui.layout;


import hr.ja.ui.Page;
import hr.ja.ui.widgets.Widget;
import hr.ja.utils.WebooUtil;

import java.util.Objects;

public abstract class Layout extends Page {

    String createScriptJsCode() {
        String scriptCode = "";
        if (WebooUtil.isDebug()) {
            String callerInfoJson = "";
            callerInfoJson = "const WEBOO_WIDGETS_INFO = " + WebooUtil.toJson(getWidgets().stream()
                    .map(Widget::getDebugCallerInfo)
                    .filter(Objects::nonNull)
                    .toList()) + ";";
            scriptCode = """
                    <script>
                        %s
                    </script>
                    """.formatted(callerInfoJson);
        }
        return scriptCode;
    }

}
