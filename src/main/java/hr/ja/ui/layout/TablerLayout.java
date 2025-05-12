package hr.ja.ui.layout;

import hr.ja.ui.Page;
import hr.ja.ui.WebPageContext;
import hr.ja.ui.widgets.Widget;
import hr.ja.utils.QuteUtil;
import hr.ja.utils.WebooUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.intellij.lang.annotations.Language;

@Data
@Slf4j
public class TablerLayout extends Layout {

    private Widget headSlot;
    private Widget bodyTopSlot;
    private Widget boodyFooterSlot;

    private String bodyHtml;
    private String scriptCode;
    private String title;


    @Override
    public String toHtml() {
        bodyHtml = WebooUtil.widgetToHtml(getWidgets());
        scriptCode = createScriptJsCode();
        this.title = getTitle();

        @Language("InjectedFreeMarker") String t = """
                <!doctype html>
                <html lang="en">
                
                <head>
                  <meta charset="utf-8" />
                  <meta name="viewport" content="width=device-width, initial-scale=1" />
                  <title>{title}</title>
                  <link rel="stylesheet" href="tabler.min.css" />
                  {scriptCode.raw}
                  {headSlot or ""}
                </head>
                
                <body>
                    {bodyTopSlot or ""}
                    ${topBody()}
                    <div class="container">
                        {bodyHtml.raw}
                    </div>
                    {boodyFooterSlot or ""}
                  <script src="tabler.min.js"></script>
                </body>
                
                </html>
                """;

        return QuteUtil.quteThis(t, this);
    }
}
