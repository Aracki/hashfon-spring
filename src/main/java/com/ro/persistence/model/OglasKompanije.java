package com.ro.persistence.model;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ognjen on 23.10.15..
 */

@Entity
@Table(name = "oglas_kompanije")
public class OglasKompanije implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected OglasKompanijePk oglasKompanijePk;

    private String oglas;
    private String naziv;

    public OglasKompanije() {
    }

    public OglasKompanije(OglasKompanijePk oglasKompanijePk) {
        this.oglasKompanijePk = oglasKompanijePk;
    }

    public OglasKompanije(Long idKompanije, Long id) {
        this.oglasKompanijePk = new OglasKompanijePk(idKompanije, id);
    }

    public OglasKompanije(OglasKompanijePk oglasKompanijePk, String oglas, String naziv) {
        this.oglasKompanijePk = oglasKompanijePk;
        this.oglas = oglas;
        this.naziv = naziv;
    }

    public OglasKompanijePk getOglasKompanijePk() {
        return oglasKompanijePk;
    }

    public void setOglasKompanijePk(OglasKompanijePk oglasKompanijePk) {
        this.oglasKompanijePk = oglasKompanijePk;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOglas() {
        return oglas;
    }

    public void setOglas(String oglas) {
        this.oglas = oglas;
    }

    @Override
    public String toString() {
        return "OglasKompanije{" +
                "oglasKompanijePk=" + oglasKompanijePk +
                ", oglas='" + oglas + '\'' +
                ", naziv='" + naziv + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OglasKompanije that = (OglasKompanije) o;
        return Objects.equal(oglasKompanijePk, that.oglasKompanijePk) &&
                Objects.equal(oglas, that.oglas) &&
                Objects.equal(naziv, that.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(oglasKompanijePk, oglas, naziv);
    }
}