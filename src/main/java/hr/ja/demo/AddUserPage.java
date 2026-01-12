package hr.ja.demo;

import hr.ja.ui.Page;
import hr.ja.ui.layout.PageLayoutTabler;
import hr.ja.ui.widgets.impl.HtmlWidget;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static hr.ja.ui.widgets.Widgets.h3;

@Slf4j
@RequestScoped
@Path(value = AddUserPage.URL)
public class AddUserPage extends PageLayoutTabler {

    @Inject
    Validator validator;

    public static final String URL = "/adduser";

    public AddUserPage() {
        setTitle("Add user page");
        getNavbar().getAddUsersItem().setActive(true);
        add(new HtmlWidget("""
                <h3>Add user</h3>
                <form method='post'>
                    <input name='name' type='text' placeholder='Name' required>
                    <input type='submit' value='Add user'>
                </form>
                
                """));
    }

    @GET
    public Page get() {
        add(h3("Add user page"));
        log.debug("AddUserPage GET request");
        return this;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String saveUser(@BeanParam @Valid UserForm userForm) {

        log.debug(userForm.toString());
        return "User is valid! It was validated by manual validation.";
    }


    @Data
    public static class UserForm {

        @NotBlank
        @Size(min = 3)
        @FormParam("name")
        private String name;

    }
}


