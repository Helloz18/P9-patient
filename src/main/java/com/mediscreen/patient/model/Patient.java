package com.mediscreen.patient.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *  Les informations personnelles des patients sont : 
 *- prénom
 *- nom
 *- date de naissance
 *- genre
 *- adresse postale
 *- numéro de téléphone
 */
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String birthdate;
    private String gender;
    private String address;
    private String phoneNumber;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String birthdate, String gender, String address,
    String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Patient [address=" + address + ", birthdate=" + birthdate + ", firstName=" + firstName + ", gender="
                + gender + ", id=" + id + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + "]";
    }
}
