package com.ladykoala.banker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestCordaKYC {

    private long accountId;
    private String lastname;
    private String firstname;
    private String middlename;
    private String birthday;
    private String permanentAddress;
    private String currentAddress;
    private String fathername;
    private String mothername;
    private String gender;
    private String contactNo;
    private String maritalStatus;
    private String nationality;
    private String occupation;
    private String income;
    private String otherParty;

}
