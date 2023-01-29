package com.cmbookrental.prj.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComicBookDTO {

    // 만화책 id
    private int bookId;
    // 만화책 이름
    private String title;
    // 만화책 작가
    private String author;
}
