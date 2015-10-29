package com.cmcc.syw;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sunyiwei on 2015/10/29.
 */
@Entity
@Table(name = "simple")
public class Simple {
    public Simple() {
    }

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
