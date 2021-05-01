package com.mediscreen.patient.model;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.DynamicUpdate;


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
@DynamicUpdate
public class Patient {


// LocalDate today = LocalDate.now();                          //Today's date
// LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);  //Birth date
 
// Period p = Period.between(birthday, today);
 
// //Now access the values as below
// System.out.println(p.getDays());
// System.out.println(p.getMonths());
// System.out.println(p.getYears());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   // private LocalDate birthday;
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
        //this.birthday = birthday;
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
    // public LocalDate getBirthday() {
    //     return birthday;
    // }
    // public void setBirthday(LocalDate birthday) {
    //     this.birthday = birthday;
    // }
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
