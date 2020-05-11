package de.summer.sampleapplayerv1.domain;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Slf4j
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String categoryName;
    private String categoryDescr;



    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescr() {
        return categoryDescr;
    }

    public void setCategoryDescr(String categoryDescr) {
        this.categoryDescr = categoryDescr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
