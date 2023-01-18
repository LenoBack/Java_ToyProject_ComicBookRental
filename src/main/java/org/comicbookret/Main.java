package org.comicbookret;

import lombok.extern.slf4j.Slf4j;
import org.comicbookret.dto.ComicBook;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ComicBook comicBook = new ComicBook();
        comicBook.getBookNo();
    }
}