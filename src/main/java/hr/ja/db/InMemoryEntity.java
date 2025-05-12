package hr.ja.db;

import java.io.Serializable;

public interface InMemoryEntity<ID> extends Serializable {
    ID getId();

    void setId(ID id);
}