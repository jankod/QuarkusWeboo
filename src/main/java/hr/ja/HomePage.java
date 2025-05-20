package hr.ja;

import hr.ja.ui.layout.TablerLayout;
import hr.ja.ui.widgets.H3;
import hr.ja.ui.widgets.Row;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/")
@RequestScoped
public class HomePage extends TablerLayout {


    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get() {
        setTitle("Home page");

        add(new H3("title"));

        Row row = new Row(
                new H3("Hello"),
                new H3("World")
        );
        row.addClass("border-bottom");
        add(row);

        return toHtml();
    }
}
