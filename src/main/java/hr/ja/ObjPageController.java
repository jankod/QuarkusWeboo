package hr.ja;

import hr.ja.ui.layout.TablerLayout;
import hr.ja.ui.widgets.H3;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/obj-page") // Define the path for this resource
@RequestScoped
public class ObjPageController extends TablerLayout {


    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get() {
        add(new H3("Obj Page"));
        return toHtml();
    }
}
