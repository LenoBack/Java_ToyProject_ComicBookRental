package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.comm.CommonCode;
import com.cmbookrental.prj.dto.RentalDTO;
import com.cmbookrental.prj.factory.Factory;
import com.cmbookrental.prj.repository.CommonRepository;

import java.util.ArrayList;
import java.util.List;

public class RentalControllerImpl implements RentalController {
    public CommonRepository repository = null;

    public RentalControllerImpl() {
        repository = Factory.getInstance().create(CommonCode.RENTAL);
    }

    @Override
    public ArrayList<RentalDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(RentalDTO rentalDTO) {
        repository.create(rentalDTO);
    }

    @Override
    public void update(RentalDTO rentalDTO) {
        repository.update(rentalDTO);
    }

    @Override
    public void delete(RentalDTO rentalDTO) {
        repository.delete(rentalDTO);
    }
}
