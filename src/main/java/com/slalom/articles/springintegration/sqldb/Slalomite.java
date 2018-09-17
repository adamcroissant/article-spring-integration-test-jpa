package com.slalom.articles.springintegration.sqldb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Slalomite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Date startDate;

    protected Slalomite() {}

    public Slalomite(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    protected void setId(long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', startDate='%s']",
                id, name, startDate.toString());
    }
}
