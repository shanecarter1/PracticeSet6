package domain;


import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;

public class PersonDomainModel {

    private  String firstName;
    private  String lastName;
    private  String street;
    private  Integer postalCode;
    private  String city;
    private  ObjectProperty<LocalDate> birthday;

    /**
     * Default constructor.
     */

    String newFirst = null;
    String newLast = null;
    int newPostal = 0;
    String newStreet = null;
    String newCity = null;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
         newFirst = this.firstName;
    }

    public String firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        newLast = this.lastName;
    }

    public String lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        newStreet = this.street;
    }

    public String streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        newPostal = this.postalCode;
    }

    public Integer postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        newCity = this.city;
    }

    public String cityProperty() {
        return city;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
}