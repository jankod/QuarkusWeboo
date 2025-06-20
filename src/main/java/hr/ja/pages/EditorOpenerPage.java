package hr.ja.pages;

import hr.ja.utils.WebooUtil;
import hr.ja.utils.WidgetLocation;
import hr.ja.utils.WidgetRegistry;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/open-in-editor")
public class EditorOpenerPage {

    @POST
    @Path("/{widgetId}")
    public void openInEditor(@PathParam("widgetId") String widgetId) {
        if (!WebooUtil.isDebug()) return;
        WidgetLocation loc = WidgetRegistry.getLocation(widgetId);
        if (loc != null) {
            String cmd = "idea --line " + loc.line + " " + loc.file;
           // Runtime.getRuntime().exec(cmd);
        }
    }
}