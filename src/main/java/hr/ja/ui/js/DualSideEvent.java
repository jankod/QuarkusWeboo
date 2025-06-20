package hr.ja.ui.js;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;


/***
 * After requst split to server (hold on server) and client (send to client and forgot)...
 */
@Data
@Accessors(chain = true)
public class DualSideEvent {

    private final String eventName;

    private final String widgetId;

    /**
     * event.preventDefault();
     * event.stopPropagation();
     */
    private boolean stopPropagation = true;

    @JsonIgnore
    private ServerHandler serverHandler;

    private JavaScriptFunction jsFunction;

    public DualSideEvent(String eventName, String widgetId) {
        this.eventName = eventName;
        this.widgetId = widgetId;
        // napravi komandu za on eventName widgetId
    }

    public DualSideEvent handleOnClient(JavaScriptFunction function) {
        checkExistFunction();
        this.jsFunction = function;
        return this;
    }


    public DualSideEvent handleOnClient(String jsCode, String... jsArgs) {
        checkExistFunction();
        this.jsFunction = new CustomJavaScript(jsCode, jsArgs);
        return this;
    }


    public DualSideEvent handleOnServer(ServerHandler handler) {
        this.serverHandler = handler;
        return this;
    }

    private void checkExistFunction() {
        if (jsFunction != null) {
            throw new RuntimeException("jsFunction not exist!");
        }
    }
}
