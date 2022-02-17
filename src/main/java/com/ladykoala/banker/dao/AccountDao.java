package com.ladykoala.banker.dao;
import javax.persistence.*;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "account")
public class AccountDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String uname;
    @Column
    private String pword;

    @Column
    private String lastname;
    @Column
    private String firstname;
    @Column
    private String middlename;

    @Column
    private String email;
    @Column
    private String contactNo;
    @Column
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column
    private String gender;
    @Column
    private String maritalStatus;
    @Column
    private String title;
    @Column
    private String fatherName;
    @Column
    private String motherName;
    @Column
    private String nationality;

    @Column
    private String address;
    @Column
    private String permanentAddress;
    @Column
    private String proofAddress;

    @Column
    private String sourceIncome;
    @Column
    private String occupation;
    @Column
    private String grossIncome;

    @Column
    private String account;
    @Column
    private float balance;


    @Column
    private String cordakycid;

}

