package de.summer.sampleapplayerv1.domain;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Slf4j
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "categorysequence")
    @SequenceGenerator(name = "categorysequence",sequenceName = "categorysequence",initialValue = 1,allocationSize = 1)
    private Long id;
    private String categoryname;
    private String categorydescr;
    private String createdby;
    private String updatedby;


    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getCategorydescr() {
        return categorydescr;
    }

    public void setCategorydescr(String categorydescr) {
        this.categorydescr = categorydescr;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }


    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
