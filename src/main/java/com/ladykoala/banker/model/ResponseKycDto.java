package com.ladykoala.banker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseKycDto {
    
    private String lastname;
    private String firstname;
    
    private String email;
    private String contactNo;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date birthday;
    
    private String gender;
    private String title;
    private String fatherName;
    private String Nationality;
    
    private String address;
    private String proofOfAddress;
    
    private String sourceOfIncome;
    private String occupation;
    private String grossIncome;

    private String bankName;
    private String bankAccount;
}
