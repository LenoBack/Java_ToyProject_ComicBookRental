package com.cmbookrental.prj.repository;

import com.cmbookrental.prj.dto.CollectionDB;
import com.cmbookrental.prj.dto.CustomerDTO;

import java.util.ArrayList;

public class CustomerRepositoryImpl implements CommonRepository<CustomerDTO> {

    private CollectionDB mDatabase = CollectionDB.getInstance();

    @Override
    public ArrayList<CustomerDTO> findAll() {
        return (ArrayList<CustomerDTO>) mDatabase.getDB().get("Customer");
    }

    @Override
    public void search(CustomerDTO customerDTO) {
        mDatabase.search(customerDTO);
    }

    @Override
    public void create(CustomerDTO customerDTO) {
        mDatabase.create(customerDTO);
    }

    @Override
    public void update(CustomerDTO customerDTO) {
        mDatabase.update(customerDTO);
    }

    @Override
    public void delete(CustomerDTO customerDTO) {
        mDatabase.delete(customerDTO);
    }

}
