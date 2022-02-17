package com.ladykoala.banker.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestLoanDto {
    private String cordaKycId;
    private String cordaRequestLoan;
}
