package com.example.sample.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="item") // postgres (name="item", schema="public")
@XmlRootElement
public class Item implements Serializable {

    @Id
    @Column(name="ID")
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEMID_SEQ")
    // @SequenceGenerator(name = "ITEMID_SEQ", sequenceName = "ITEMID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO) // for Postgres and MySQL
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Long id;

    @Column(name="NAME", length = 20)
    private String name;

    @Column(name="PRICE")
    private int price;

    @Column(name="MEMO", length = 20)
    private String memo;

    @Column(name="FLAG")
    private Boolean flag;

    /* For your Information
     * @Column(name = "updated", columnDefinition="DATETIME")
     * private LocalDateTime updated;
     */

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "CREATED", columnDefinition="TIMESTAMP")
    private LocalDateTime created;

    /*
    @org.springframework.data.annotation.Version
    private Integer version;


    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

}
