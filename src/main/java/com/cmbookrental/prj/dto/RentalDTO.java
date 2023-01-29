package com.cmbookrental.prj.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {
    // 대여 id
    private int bookNo;
    // 대여일
    private LocalDate rentalData;
    // 대여 만화책 정보
    private ComicBookDTO comicBookDTO;

}
