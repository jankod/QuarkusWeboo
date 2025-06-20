package hr.ja.ui.widgets.impl;

import lombok.Getter;

@Getter
public class Column<M> {
    private final String name;
    private final ColumnRender<M, Object> columnValue;

    public Column(String name, ColumnRender<M, Object> columnValue) {
        this.name = name;
        this.columnValue = columnValue;
    }
}


