package com.cmbookrental.prj.repository;

import java.util.ArrayList;

public interface CommonRepository<T> {
    ArrayList<T> findAll();

    void search(T parameter); // 조회 기능

    void create(T parameter); // 생성 기능

    void update(T parameter); // 수정 기능

    void delete(T parameter);  // 삭제 기능


}
