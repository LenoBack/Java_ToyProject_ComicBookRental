package com.cmbookrental.prj.app;

public class ProgramStart {
    public static void main(String[] args) throws Exception {
        ComicBookRentalApp ComicBookRentalSystem = new ComicBookRentalApp();
        ComicBookRentalSystem.comicBookDefaultData();
//        ComicBookRentalSystem.customerDefaultData();
        ComicBookRentalSystem.start();
    }
}
