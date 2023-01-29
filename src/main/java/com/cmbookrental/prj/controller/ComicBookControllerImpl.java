package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.comm.CommonCode;
import com.cmbookrental.prj.dto.ComicBookDTO;
import com.cmbookrental.prj.factory.Factory;
import com.cmbookrental.prj.repository.CommonRepository;

import java.util.ArrayList;
import java.util.List;

public class ComicBookControllerImpl implements ComicBookController {

    private CommonRepository repository = null;

    public ComicBookControllerImpl() {
        repository = Factory.getInstance().create(CommonCode.COMIC_BOOK);
    }

    @Override
    public ArrayList<ComicBookDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public ComicBookDTO search(String title) {
        ComicBookDTO temp = null;
        List<ComicBookDTO> list = repository.findAll();
        for (ComicBookDTO c : list) {
            if (c.getTitle().equals(title)) {
                temp = c;
            }
        }
        return temp;
    }

    @Override
    public void create(ComicBookDTO comicBookDTO) {
        repository.create(comicBookDTO);
    }

    @Override
    public void update(ComicBookDTO comicBookDTO) {
        repository.update(comicBookDTO);
    }

    @Override
    public void delete(ComicBookDTO comicBookDTO) {
        repository.delete(comicBookDTO);
    }
}
