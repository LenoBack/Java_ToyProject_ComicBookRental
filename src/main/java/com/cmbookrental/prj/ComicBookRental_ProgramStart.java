package com.cmbookrental.prj;

import com.cmbookrental.prj.app.ComicBookRentalApp;

public class ComicBookRental_ProgramStart {
    public static void main(String[] args) throws Exception {
        ComicBookRentalApp ComicBookRentalSystem = new ComicBookRentalApp();
        ComicBookRentalSystem.comicBookDefaultData();
        ComicBookRentalSystem.customerDefaultData();
        ComicBookRentalSystem.start();
    }
}
