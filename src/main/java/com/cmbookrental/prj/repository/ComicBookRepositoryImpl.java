package com.cmbookrental.prj.repository;

import com.cmbookrental.prj.dto.CollectionDB;
import com.cmbookrental.prj.dto.ComicBookDTO;

import java.util.ArrayList;

public class ComicBookRepositoryImpl implements CommonRepository<ComicBookDTO> {

    private CollectionDB mDatabase = CollectionDB.getInstance();

    @Override
    public ArrayList<ComicBookDTO> findAll() {
        return (ArrayList<ComicBookDTO>) mDatabase.getDB().get("ComicBook");
    }

    @Override
    public void search(ComicBookDTO comicBookDTO) {
        mDatabase.search(comicBookDTO);
    }

    @Override
    public void create(ComicBookDTO comicBookDTO) {
        mDatabase.create(comicBookDTO);
    }

    @Override
    public void update(ComicBookDTO comicBookDTO) {
        mDatabase.update(comicBookDTO);
    }

    @Override
    public void delete(ComicBookDTO comicBookDTO) {
        mDatabase.delete(comicBookDTO);
    }


}
