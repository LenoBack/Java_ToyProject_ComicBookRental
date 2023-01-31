package com.cmbookrental.prj.repository;

import com.cmbookrental.prj.dto.CollectionDB;
import com.cmbookrental.prj.dto.RentalDTO;

import java.util.ArrayList;

public class RentalRepositoryImpl implements CommonRepository<RentalDTO> {

    private CollectionDB mDatabase = CollectionDB.getInstance();

    @Override
    public ArrayList<RentalDTO> findAll() {
        return (ArrayList<RentalDTO>) mDatabase.getDB().get("Rental");
    }

    @Override
    public void search(RentalDTO rentalDTO) {
        return;
    }

    @Override
    public void create(RentalDTO rentalDTO) {
        mDatabase.create(rentalDTO);
    }

    @Override
    public void update(RentalDTO rentalDTO) {
        mDatabase.update(rentalDTO);
    }

    @Override
    public void delete(RentalDTO rentalDTO) {
        mDatabase.delete(rentalDTO);
    }

}
