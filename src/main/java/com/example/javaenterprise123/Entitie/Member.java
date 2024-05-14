package com.example.javaenterprise123.Entitie;

import com.example.javaenterprise123.Entitie.Address;
import jakarta.persistence.*;

// Entity-klass som representerar en medlem i databasen
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 25, nullable = false)  // Ange explicit kolumnnamn
    private String firstName;

    @Column(name = "last_name", length = 35, nullable = false)   // Ange explicit kolumnnamn
    private String lastName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    @Column(name = "email", length = 40, nullable = false)       // Ange explicit kolumnnamn
    private String email;

    @Column(name = "phone", length = 25)                         // Ange explicit kolumnnamn
    private String phone;

    @Column(name = "date_of_birth", length = 15, nullable = false) // Ange explicit kolumnnamn
    private String dateOfBirth;

    // Standardkonstruktor
    public Member() {
    }

    // Konstruktor som används för att skapa en medlem
    public Member(String firstName, String lastName, Address address, String email, String phone, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters och Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
