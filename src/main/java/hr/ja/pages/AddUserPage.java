package hr.ja.pages;

import hr.ja.ui.Page;
import hr.ja.ui.layout.PageLayoutTabler;
import hr.ja.ui.widgets.impl.HtmlWidget;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.awt.print.Book;
import java.util.Set;

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
        getNavbar().getUsersItem().setActive(false);
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
        return this;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) // Changed to consume form data
    public String saveUser(@BeanParam @Valid UserForm userForm) {

        log.debug(userForm.toString());
        return "User is valid! It was validated by manual validation.";
    }


    @Data
    public static class UserForm {

        @NotBlank
        @Min(3)
        @FormParam("name")
        private String name;

    }
}


