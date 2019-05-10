package com.wayonsys.account.common.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: allen
 * @Description:
 * @Date: created in 2018/11/12 16:31
 * @Modified By:
 */
@MappedSuperclass
public abstract class IdEntity implements Serializable {

    private static final long serialVersionUID = -1031722836545455425L;
    protected Long id;


    public static List<String> asStringList(List<? extends IdEntity> list) {
        List<String> results = new ArrayList<>();
        for (IdEntity o : list) {
            results.add(o.getId().toString());
        }
        return results;
    }

    public static List<Long> asList(List<? extends IdEntity> list) {
        List<Long> results = new ArrayList<>();
        for (IdEntity o : list) {
            results.add(o.getId());
        }
        return results;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    @Transient
    public Boolean isNew() {
        return id == null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdEntity idEntity = (IdEntity) o;
        if (idEntity.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, idEntity.id);
    }

}
