package com.cmbookrental.prj.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    // 고객 id
    private int customerSerialNumber;

    private String customerID;
    // 고객 이름
    private String customerName;

}


