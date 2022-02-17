package com.ladykoala.banker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseAccountBalanceDto {
    private String account;
    private float balance;
    private String bankName;
    private String bankAccount;
    private String cordaFlowId;
}
