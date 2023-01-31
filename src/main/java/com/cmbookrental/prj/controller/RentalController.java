package com.cmbookrental.prj.controller;

import com.cmbookrental.prj.dto.CustomerDTO;
import com.cmbookrental.prj.dto.RentalDTO;

import java.util.ArrayList;
import java.util.List;

public interface RentalController{

    List<RentalDTO> findAll(); // 대여 목록 전체  가져오기

    public void create(RentalDTO rentalID); // 대여 등록

    public void update(RentalDTO rentalID); // 대여 수정

    public void delete(RentalDTO rentalID); //대여 삭제
}
