package com.naldojesse.group_languages.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "languages")
public class Language implements java.io.Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Size(min=2, max=20)
    private String name;

    @Column
    @Size(min=2, max=20)
    private String creator;

    @Column
    @NotEmpty(message="Version cannot be empty")
    private String version;

    @Column(updatable=false)
    @DateTimeFormat (pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;

    @Column
    @DateTimeFormat (pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;

    public Language() {
    }

    public Language(String name, String creator, String version) {
        this.name = name;
        this.creator = creator;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getId() {return id;}


    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


}
