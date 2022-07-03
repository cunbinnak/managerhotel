package com.manager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class CreateBillRequest {
    private String orderId;
    private Timestamp invoiceDate;
    private Timestamp checkinDate;
    private Timestamp checkoutDate;
    private String createdUser;

}
