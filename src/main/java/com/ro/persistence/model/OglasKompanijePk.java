package com.ro.persistence.model;

import com.google.common.base.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by ognjen on 23.10.15..
 */

@Embeddable
public class OglasKompanijePk implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "id_kompanije")
    private Long idKompanije;

    @Basic(optional = false)
    private Long id;

    public OglasKompanijePk() {
    }

    public OglasKompanijePk(Long idKompanije, Long id) {
        this.id = id;
        this.idKompanije = idKompanije;
    }

    public Long getIdKompanije() {
        return idKompanije;
    }

    public void setIdKompanije(Long idKompanije) {
        this.idKompanije = idKompanije;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OglasKompanijePk{" +
                "idKompanije=" + idKompanije +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OglasKompanijePk that = (OglasKompanijePk) o;
        return Objects.equal(idKompanije, that.idKompanije) &&
                Objects.equal(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idKompanije, id);
    }
}
