package hr.ja.ui.layout;

import hr.ja.ui.Page;
import hr.ja.ui.WebPageContext;
import hr.ja.ui.widgets.Widget;
import hr.ja.utils.QuteUtil;
import hr.ja.utils.WebooUtil;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.intellij.lang.annotations.Language;

@Slf4j
public class TablerLayout extends Layout {

    @Setter
    private String title;

    @Getter
    private String bodyHtml;
    @Getter
    private String scriptCode;


    @Override
    public String toHtml() {
        bodyHtml = WebooUtil.widgetToHtml(getWidgets());
        scriptCode = createScriptJsCode();
        this.title = getTitle();

        @Language("HTML") String t = """
                <!doctype html>
                <html lang="en">
                
                <head>
                  <meta charset="utf-8" />
                  <meta name="viewport" content="width=device-width, initial-scale=1" />
                  <title>{title}</title>
                  <link rel="stylesheet" href="/tabler.min.css" />
                  <link rel="stylesheet" href="/all.css" />
                  {scriptCode.raw or ""}
                  {headSlot or ""}
                </head>
                
                <body>
                    {bodyTopSlot or ""}
                    {topBody or ""}
                    <div class="container">
                        {bodyHtml.raw}
                    </div>
                    {boodyFooterSlot or ""}
                  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
                    
                  <script src="tabler.min.js"></script>
                  <script src="all.js"></script>
                </body>
                
                </html>
                """;

        return QuteUtil.quteThis(t, this);
    }
}
