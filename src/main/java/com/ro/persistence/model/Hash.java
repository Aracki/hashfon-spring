package com.ro.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by ognjen on 23.10.15..
 */

@Entity
@Table(name = "hash")
public class Hash implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tag;

    @OneToMany(mappedBy = "hash", cascade = CascadeType.ALL)
    private List<Snippet> snippets;

    public Hash() {
    }

    public Hash(Long id) {
        this.id = id;
    }

    public Hash(Long id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    @JsonIgnore
    public List<Snippet> getSnippets() {
        return snippets;
    }

    public void setSnippets(List<Snippet> snippets) {
        this.snippets = snippets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Hash{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hash hash = (Hash) o;
        return Objects.equal(id, hash.id) &&
                Objects.equal(tag, hash.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, tag);
    }
}
