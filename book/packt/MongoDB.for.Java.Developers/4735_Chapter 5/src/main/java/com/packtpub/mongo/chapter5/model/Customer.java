package com.packtpub.mongo.chapter5.model;

import javax.persistence.*;
import java.util.List;
import static javax.persistence.FetchType.EAGER;
import org.hibernate.annotations.GenericGenerator;

@Entity

public class Customer   {

    @Id 
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String country;
    private String name;

    @OneToMany(mappedBy = "customerFK", fetch = EAGER)
    private List<Item> items;

    public Customer() {     }

	
   // Getter/Setters omitted for brevity

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
