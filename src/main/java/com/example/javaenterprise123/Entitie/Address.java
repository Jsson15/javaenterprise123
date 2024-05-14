package com.example.javaenterprise123.Entitie;

import jakarta.persistence.*;

// Entity-klass som representerar en adress i databasen
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String street;

    @Column(name = "postal_code", length = 20)  // Ange kolumnnamnet här
    private String postalCode;

    @Column(length = 25)
    private String city;

    // Standardkonstruktor
    public Address() {
    }

    // Konstruktor som används för att skapa en adress med gatunamn, postnummer och stad
    public Address(String street, String postalCode, String city) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    // Getter och setter för gatunamn
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    // Getter och setter för postnummer
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // Getter och setter för stad
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getter och setter för ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
