package com.cmbookrental.prj.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComicBookDTO {

    private int bookId;
    private String title;
    private String author;
}
