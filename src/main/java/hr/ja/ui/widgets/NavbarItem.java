package hr.ja.ui.widgets;

import hr.ja.ui.widgets.impl.Icon;
import hr.ja.utils.QuteUtil;
import lombok.Getter;
import lombok.Setter;
import org.intellij.lang.annotations.Language;

@Getter
@Setter
public class NavbarItem extends Widget {

    private String text;

    private Icon icon;

    private String href = "#";

    private boolean isActive = false;

    public NavbarItem(String text, String href, Icon icon) {
        this.text = text;
        this.href = href;
        this.icon = icon;
    }

    @Override
    public String toHtml() {

        @Language("HTML") String html = """
                <li class="nav-item {isActive ? 'active' : ''}">
                    <a class="nav-link" href="{href}">
                        {#if icon}
                        <span class="nav-link-icon">
                            {icon}
                        </span>
                        {/if}
                        <span class="nav-link-title"> {text} </span>
                    </a>
                </li>""";

        return QuteUtil.quteThis(html, this);
    }

    public static void main(String[] args) {
        NavbarItem item = new NavbarItem("Test", "", Icon.home());
        item.setActive(true);
        item.setIcon(Icon.home());
        System.out.println(item.toHtml());
    }
}
