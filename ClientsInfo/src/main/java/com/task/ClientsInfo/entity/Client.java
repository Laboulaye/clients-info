package com.task.ClientsInfo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ElementCollection
    @CollectionTable(name="client_emails")
    @Column(name = "email")
    private Set<String> emails;
    @ElementCollection
    @CollectionTable(name = "client_phones")
    @Column(name = "phone_number")
    private Set<String> phones;
}
