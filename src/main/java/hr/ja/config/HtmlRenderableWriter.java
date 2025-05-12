package hr.ja.config;

import hr.ja.ui.HtmlRenderable;
import hr.ja.ui.Page;
import hr.ja.ui.WebPageContext;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

@Provider
@Slf4j
//@Produces(MediaType.TEXT_HTML)          // ⇦ za klijente koji traže text/html
public class HtmlRenderableWriter implements MessageBodyWriter<Page> {

    @Context
    UriInfo uriInfo;

    @Override                    // radi li naš writer za traženi tip?
    public boolean isWriteable(Class<?> type, Type gType,
                               Annotation[] ann, MediaType mediaType) {
        return Page.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Page page, Class<?> type, Type gType,
                        Annotation[] ann, MediaType mediaType) {
        return -1;               // veličina nepoznata (OK od JAX-RS 2.0)
    }

    @Override
    public void writeTo(Page page, Class<?> type, Type gType,
                        Annotation[] ann, MediaType mediaType,
                        MultivaluedMap<String, Object> headers,
                        OutputStream os)
            throws IOException, WebApplicationException {
        log.debug("uri {}", uriInfo.getRequestUri());
        log.debug("header {}", headers);

        // ako želiš automatski dodati charset:
        headers.putSingle("Content-Type", "text/html; charset=utf-8");

        WebPageContext context = new WebPageContext();
        //render(headers, uriInfo);
        os.write(page.toHtml().getBytes(StandardCharsets.UTF_8));
    }
}