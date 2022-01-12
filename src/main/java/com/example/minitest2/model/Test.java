package com.example.minitest2.model;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCity;
    private int acreage;
    private int population;
    private int gDP;
    private String description;
    @ManyToOne
    @JoinColumn(name = "test2_id")
    private Test2 test2;

    public Test() {
    }

    public Test(Long id, String nameCity, int acreage, int population, int gDP, String description) {
        this.id = id;
        this.nameCity = nameCity;
        this.acreage = acreage;
        this.population = population;
        this.gDP = gDP;
        this.description = description;
    }

    public Test(Long id, String nameCity, int acreage, int population, int gDP, String description, Test2 test2) {
        this.id = id;
        this.nameCity = nameCity;
        this.acreage = acreage;
        this.population = population;
        this.gDP = gDP;
        this.description = description;
        this.test2 = test2;
    }

    public Test(String nameCity, int acreage, int population, int gDP, String description, Test2 test2) {
        this.nameCity = nameCity;
        this.acreage = acreage;
        this.population = population;
        this.gDP = gDP;
        this.description = description;
        this.test2 = test2;
    }

    public Test2 getTest2() {
        return test2;
    }

    public void setTest2(Test2 test2) {
        this.test2 = test2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getgDP() {
        return gDP;
    }

    public void setgDP(int gDP) {
        this.gDP = gDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
