package com.cmbookrental.prj.factory;

import com.cmbookrental.prj.comm.CommonCode;
import com.cmbookrental.prj.controller.ComicBookControllerImpl;
import com.cmbookrental.prj.controller.CustomerControllerImpl;
import com.cmbookrental.prj.repository.ComicBookRepositoryImpl;
import com.cmbookrental.prj.repository.CommonRepository;
import com.cmbookrental.prj.repository.CustomerRepositoryImpl;

public class Factory {

    private static Factory instance = new Factory();

    private Factory() {
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    // 인스턴스 생성 메서드
    public CommonRepository create(int type) {
        CommonRepository repository;
        if (type == CommonCode.COMIC_BOOK) {
            repository = new ComicBookRepositoryImpl();
        } else if (type == CommonCode.CUSTOMER) {
            repository = new CustomerRepositoryImpl();
        } else {
            return null;
        }
        return repository;
    }

    public ComicBookControllerImpl getComicBook() {
        return new ComicBookControllerImpl();
    }

    public CustomerControllerImpl getCustomer() {
        return new CustomerControllerImpl();
    }
}
