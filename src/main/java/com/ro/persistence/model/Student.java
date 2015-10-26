package com.ro.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by ivan on 23.10.15..
 */

@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ime;
    private String prezime;
    private String password;
    private String telefon;
    private String email;
    private String slika;
    private String adresa;

    @Column(name = "datum_rodjenja")
    private Date datumRodjenja;
    @Column(name = "dodatne_informacije")
    private String dodatneInformacije;
    private String token;
    @Column(name = "godina_diplomiranja")
    private Integer godinaDiplomiranja;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<Snippet> snippets;

    public Student(Long id, String ime, String prezime, String password, String telefon, String email, String slika, String adresa, Date datumRodjenja, String dodatneInformacije, String token, Integer godinaDiplomiranja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.password = password;
        this.telefon = telefon;
        this.email = email;
        this.slika = slika;
        this.adresa = adresa;
        this.datumRodjenja = datumRodjenja;
        this.dodatneInformacije = dodatneInformacije;
        this.token = token;
        this.godinaDiplomiranja = godinaDiplomiranja;
    }

    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Set<Snippet> getSnippets() {
        return snippets;
    }

    public void setSnippets(Set<Snippet> snippets) {
        this.snippets = snippets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getDodatneInformacije() {
        return dodatneInformacije;
    }

    public void setDodatneInformacije(String dodatneInformacije) {
        this.dodatneInformacije = dodatneInformacije;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getGodinaDiplomiranja() {
        return godinaDiplomiranja;
    }

    public void setGodinaDiplomiranja(Integer godinaDiplomiranja) {
        this.godinaDiplomiranja = godinaDiplomiranja;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", password='" + password + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", slika='" + slika + '\'' +
                ", adresa='" + adresa + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", dodatneInformacije='" + dodatneInformacije + '\'' +
                ", token='" + token + '\'' +
                ", godinaDiplomiranja=" + godinaDiplomiranja +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equal(id, student.id) &&
                Objects.equal(ime, student.ime) &&
                Objects.equal(prezime, student.prezime) &&
                Objects.equal(password, student.password) &&
                Objects.equal(telefon, student.telefon) &&
                Objects.equal(email, student.email) &&
                Objects.equal(slika, student.slika) &&
                Objects.equal(adresa, student.adresa) &&
                Objects.equal(datumRodjenja, student.datumRodjenja) &&
                Objects.equal(dodatneInformacije, student.dodatneInformacije) &&
                Objects.equal(token, student.token) &&
                Objects.equal(godinaDiplomiranja, student.godinaDiplomiranja);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, ime, prezime, password, telefon, email, slika, adresa, datumRodjenja, dodatneInformacije, token, godinaDiplomiranja);
    }
}
