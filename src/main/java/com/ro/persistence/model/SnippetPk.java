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
public class SnippetPk implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    private long id;
    @Basic(optional = false)
    @Column(name = "id_student")
    private long idStudent;

    public SnippetPk() {
    }

    public SnippetPk(long id, long idStudent) {
        this.id = id;
        this.idStudent = idStudent;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SnippetPk{" +
                "id=" + id +
                ", idStudent=" + idStudent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnippetPk snippetPk = (SnippetPk) o;
        return Objects.equal(id, snippetPk.id) &&
                Objects.equal(idStudent, snippetPk.idStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, idStudent);
    }
}
