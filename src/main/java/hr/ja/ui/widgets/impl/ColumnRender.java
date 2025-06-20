package hr.ja.ui.widgets.impl;

@FunctionalInterface
public interface ColumnRender<M, R> {
    R render(M model);
}
