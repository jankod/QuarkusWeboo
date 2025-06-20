package hr.ja.ui.form;

import hr.ja.ui.js.CustomJavaScript;
import hr.ja.ui.js.DualSideEvent;
import hr.ja.ui.widgets.CompositeWidget;
import hr.ja.ui.widgets.Widget;
import hr.ja.utils.QuteUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static org.apache.commons.lang3.concurrent.UncheckedFuture.on;

@Slf4j
@Getter
public class Form extends CompositeWidget {
    private String eventId;

    @Override
    public String toHtml() {
        // language=HTML
        String template = """
              <form {attr.raw} method='post' >
                {children}
              </form>
              <script>
              weboo.form('{id}');
              </script>
                """;

        return QuteUtil.quteThis(template, this);

//        return QuteUtil.quteMap(template, Map.of(
//              "id", this.getWidgetId(),
//              "children",toChildrenHtml(),
//              "attr", getIdClassStyleAttr()));
    }

    public void onSubmit(SubmitHandler handler) {
        DualSideEvent clientEvent = on("submit");
        clientEvent.handleOnClient(new CustomJavaScript("""
              console.log(" this.",  this);
              this.event.preventDefault();
              this.event.stopPropagation();
              alert("form submit!");
              """, "widgetId", getWidgetId()));

        clientEvent.setServerHandler(handler::submitForm);
    }

    public FormConfigurer configure() {
        // TODO: like spring security
        return new FormConfigurer(this);
    }

    public static void main(String[] args) {
        Form form = new Form();

        System.out.println(form.toHtml());
    }

}

