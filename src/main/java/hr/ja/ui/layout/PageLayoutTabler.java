package hr.ja.ui.layout;

import hr.ja.ui.widgets.Navbar;
import hr.ja.utils.QuteUtil;
import hr.ja.utils.WebooUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.intellij.lang.annotations.Language;

@Slf4j
@Getter
@Setter
public class PageLayoutTabler extends Layout {

    private String title;

    private String bodyHtml;

    private String scriptCode;

    private Navbar navbar = new Navbar();


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
                    {navbar}
                
                    {bodyTopSlot or ""}
                    {topBody or ""}
                    <div class="container">
                        {bodyHtml.raw}
                    </div>
                    {boodyFooterSlot or ""}
                  <script src="bootstrap.bundle.min.js"></script>
                  <script src="tabler.min.js"></script>
                  <script src="all.js"></script>
                </body>
                
                </html>
                """;

        return QuteUtil.quteThis(t, this);
    }
}
