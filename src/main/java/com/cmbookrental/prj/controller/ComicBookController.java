package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.dto.ComicBookDTO;

import java.util.List;

public interface ComicBookController {

    List<ComicBookDTO> findAll(); // 만화책 목록 가져오기

    public ComicBookDTO search(String title); // 만화책 찾기

    public void create(ComicBookDTO comicBookDTO); // 만화책 등록

    public void update(ComicBookDTO comicBookDTO); // 만화책 수정

    public void delete(ComicBookDTO comicBookDTO); //만화책 삭제
}
