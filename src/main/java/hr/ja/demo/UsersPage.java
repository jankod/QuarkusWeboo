package hr.ja.demo;

import hr.ja.ui.Page;
import hr.ja.ui.layout.PageLayoutTabler;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

import static hr.ja.ui.widgets.Widgets.h3;

@Slf4j
@RequestScoped
@Path(value = UsersPage.URL)

public class UsersPage extends PageLayoutTabler {
    public static final String URL = "/users";

    public UsersPage() {
        setTitle("Users page");
        getNavbar().getUsersItem().setActive(true);
    }

    @GET
    public Page get() {


        add(h3("Users page"));

        return this;
    }
}
