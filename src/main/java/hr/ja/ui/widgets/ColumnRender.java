package hr.ja.ui.widgets;

@FunctionalInterface
public interface ColumnRender<M, R> {
    R render(M model);
}
