package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.dto.CustomerDTO;
import com.cmbookrental.prj.dto.CustomerDTO;

import java.util.List;

public interface CustomerController {

    List<CustomerDTO> findAll(); // 고객 목록 가져오기

    public CustomerDTO search(String customerID); // 고객 찾기

    public void create(CustomerDTO customerDTO); // 고객 등록

    public void update(CustomerDTO customerDTO); // 고객 수정

    public void delete(CustomerDTO customerDTO); //고객 삭제
}
