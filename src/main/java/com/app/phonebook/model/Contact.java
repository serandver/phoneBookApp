package com.app.phonebook.model;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class Contact {

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

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch= FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
