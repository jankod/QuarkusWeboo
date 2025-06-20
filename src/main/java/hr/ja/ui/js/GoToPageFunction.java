package hr.ja.ui.js;

import hr.ja.ui.Page;
import jakarta.ws.rs.Path;
import lombok.Getter;

@JavaScript("""
      window.location.replace(this.path);
      """)
@Getter
public class GoToPageFunction extends JavaScriptFunction {

    private final String path;

    public GoToPageFunction(Class<? extends Page> page) {
        //path = Weboo.getPath(page);
        path = page.getAnnotation(Path.class).value();
    }

}
