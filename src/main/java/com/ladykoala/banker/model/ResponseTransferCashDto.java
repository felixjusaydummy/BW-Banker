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
public class ResponseTransferCashDto {
    private String account;
    private float amount;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date created;
}
