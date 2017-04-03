package com.lardi.phonebook.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long contactId;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String mobilePhoneNumber;
    private String homePhoneNumber;
    private String address;
    private String email;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;


    public Contact() {
    }

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Contact(User user, String firstName, String lastName, String patronymic, String mobilePhoneNumber, String homePhoneNumber, String address, String email) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.homePhoneNumber = homePhoneNumber;
        this.address = address;
        this.email = email;
    }


    public long getContactId() {
        return contactId;
    }
    public User getUser() {
        return user;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }
    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }
    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (contactId != contact.contactId) return false;
        if (!user.equals(contact.user)) return false;
        if (!firstName.equals(contact.firstName)) return false;
        if (!lastName.equals(contact.lastName)) return false;
        if (!patronymic.equals(contact.patronymic)) return false;
        if (!mobilePhoneNumber.equals(contact.mobilePhoneNumber)) return false;
        if (homePhoneNumber != null ? !homePhoneNumber.equals(contact.homePhoneNumber) : contact.homePhoneNumber != null)
            return false;
        if (address != null ? !address.equals(contact.address) : contact.address != null) return false;
        return email != null ? email.equals(contact.email) : contact.email == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (contactId ^ (contactId >>> 32));
        result = 31 * result + user.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + patronymic.hashCode();
        result = 31 * result + mobilePhoneNumber.hashCode();
        result = 31 * result + (homePhoneNumber != null ? homePhoneNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
