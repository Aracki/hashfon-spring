package com.ro.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ognjen on 23.10.15..
 */

@Entity
@Table(name = "kompanija")
public class Kompanija implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ime;
    private String opis;
    private String slika;
    private String email;
    private String adresa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kompanija")
    private List<OglasKompanije> oglasKompanijeList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kompanija")
    private List<Hr> hrList;

    public Kompanija() {
    }

    public Kompanija(Long id, String ime, String opis, String slika, String email, String adresa) {
        this.id = id;
        this.ime = ime;
        this.opis = opis;
        this.slika = slika;
        this.email = email;
        this.adresa = adresa;
    }

    @JsonIgnore
    public List<Hr> getHrList() {
        return hrList;
    }

    public void setHrList(List<Hr> hrList) {
        this.hrList = hrList;
    }

    @JsonIgnore
    public List<OglasKompanije> getOglasKompanijeList() {
        return oglasKompanijeList;
    }

    public void setOglasKompanijeList(List<OglasKompanije> oglasKompanijeList) {
        this.oglasKompanijeList = oglasKompanijeList;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Kompanija{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", opis='" + opis + '\'' +
                ", slika='" + slika + '\'' +
                ", email='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kompanija kompanija = (Kompanija) o;
        return Objects.equal(id, kompanija.id) &&
                Objects.equal(ime, kompanija.ime) &&
                Objects.equal(opis, kompanija.opis) &&
                Objects.equal(slika, kompanija.slika) &&
                Objects.equal(email, kompanija.email) &&
                Objects.equal(adresa, kompanija.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, ime, opis, slika, email, adresa);
    }
}
