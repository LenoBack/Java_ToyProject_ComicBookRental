package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.comm.CommonCode;
import com.cmbookrental.prj.dto.ComicBookDTO;
import com.cmbookrental.prj.dto.CustomerDTO;
import com.cmbookrental.prj.factory.Factory;
import com.cmbookrental.prj.repository.CommonRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerControllerImpl implements CustomerController {

    private CommonRepository repository = null;

    public CustomerControllerImpl() {
        repository = Factory.getInstance().create(CommonCode.CUSTOMER);
    }

    @Override
    public ArrayList<CustomerDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public CustomerDTO search(String customerID) {
        CustomerDTO temp = null;
        List<CustomerDTO> list = repository.findAll();
        for (CustomerDTO cd : list) {
            if (cd.getCustomerID().equals(customerID)) {
                temp = cd;
            }
        }
        return temp;
    }

    @Override
    public void create(CustomerDTO customerDTO) {
        repository.create(customerDTO);
    }

    @Override
    public void update(CustomerDTO customerDTO) {
        repository.update(customerDTO);
    }

    @Override
    public void delete(CustomerDTO customerDTO) {
        repository.delete(customerDTO);
    }
}
