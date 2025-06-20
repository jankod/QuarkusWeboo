package hr.ja.ui.widgets;


import hr.ja.utils.WebooUtil;

import java.util.Map;

public interface HasAttributes {
    Map<String, Object> getAttributes();

    default Object getAttribute(String name) {
        return getAttributes().get(name);
    }

    default void setAttribute(String name, Object value) {
        getAttributes().put(name, value);
    }

    default String toHtmlAttributes() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : getAttributes().entrySet()) {
            sb.append(entry.getKey()).append("=\"").append(WebooUtil.htmlEscape(entry.getValue().toString())).append("\" ");
        }
        return sb.toString().trim();
    }

    default String toHtmlAttribute(String attributeName) {
        Object attributeValue = getAttributes().get(attributeName);
        if (attributeValue != null) {
            return attributeName + "=\"" + WebooUtil.htmlEscape(attributeValue.toString()) + "\"";
        } else {
            return "";
        }
    }
}
