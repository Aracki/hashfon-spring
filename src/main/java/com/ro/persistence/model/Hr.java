package com.ro.persistence.model;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ognjen on 23.10.15..
 */

@Entity
@Table(name = "hr")
public class Hr implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected HrPk hrPk;

    private String email;
    private String password;
    private String ime;
    private String prezime;
    private String token;

    @ManyToOne(optional = false)
    private Kompanija kompanija;

    public Hr() {
    }

    public Hr(HrPk hrPk) {
        this.hrPk = hrPk;
    }

    public Hr(HrPk hrPK, String email, String password, String ime, String prezime) {
        this.hrPk = hrPK;
        this.email = email;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Hr(long idKompanije, long id) {
        this.hrPk = new HrPk(idKompanije, id);
    }

    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }

    public HrPk getHrPk() {
        return hrPk;
    }

    public void setHrPk(HrPk hrPk) {
        this.hrPk = hrPk;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Hr{" +
                "hrPk=" + hrPk +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hr hr = (Hr) o;
        return Objects.equal(hrPk, hr.hrPk) &&
                Objects.equal(email, hr.email) &&
                Objects.equal(password, hr.password) &&
                Objects.equal(ime, hr.ime) &&
                Objects.equal(prezime, hr.prezime) &&
                Objects.equal(token, hr.token);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hrPk, email, password, ime, prezime, token);
    }
}
