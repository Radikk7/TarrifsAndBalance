package com.example.tarrifsandbalance.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="card")
@XmlAccessorType(XmlAccessType.FIELD)
public class Card {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "number")
    private String number;

    public Card(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Card() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
