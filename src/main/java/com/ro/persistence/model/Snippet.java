package com.ro.persistence.model;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ognjen on 23.10.15..
 */

@Entity
@Table(name = "snipet")
public class Snippet implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SnippetPk snippetPk;

    private String code;

    public Snippet(SnippetPk snippetPk, String code) {
        this.snippetPk = snippetPk;
        this.code = code;
    }

    public Snippet() {
    }

    public Snippet(SnippetPk snippetPK) {
        this.snippetPk = snippetPK;
    }

    public SnippetPk getSnippetPk() {
        return snippetPk;
    }

    public void setSnippetPk(SnippetPk snippetPk) {
        this.snippetPk = snippetPk;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Snippet{" +
                "snippetPk=" + snippetPk +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snippet snippet = (Snippet) o;
        return Objects.equal(snippetPk, snippet.snippetPk) &&
                Objects.equal(code, snippet.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(snippetPk, code);
    }
}
