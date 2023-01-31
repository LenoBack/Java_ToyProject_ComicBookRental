package com.cmbookrental.prj.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {

    private int rentalID;
    private String bookTitle;
    private LocalDateTime rentalDate;
    private String customerName;

}
