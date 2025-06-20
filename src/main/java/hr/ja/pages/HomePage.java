package hr.ja.pages;

import hr.ja.ui.layout.PageLayoutTabler;
import hr.ja.ui.widgets.impl.H3;
import hr.ja.ui.widgets.impl.Row;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

import static hr.ja.ui.widgets.Widgets.*;

@Slf4j
@RequestScoped
@Path(value = HomePage.URL)
public class HomePage extends PageLayoutTabler {

    public static final String URL = "/";

    @GET()
    public HomePage get() {

        setTitle("Home page");
        getNavbar().getUsersItem().setActive(true);

        add(new H3("Home Page"));

        Row r = row(
              col(h3("Col 1")), col(h3("Col 2"))
        );

        add(r).addClass("border border-primary");


        return this;
    }
}


