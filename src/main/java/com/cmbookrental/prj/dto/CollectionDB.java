package com.cmbookrental.prj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.cmbookrental.prj.comm.CommonCode.COMIC_BOOK_ID;
import static com.cmbookrental.prj.comm.CommonCode.CUSTOMER_ID;

@Getter
@Setter
@ToString
public class CollectionDB {
    private CollectionDB() {
    } // 기본 생성자 지정

    private static CollectionDB instance; // 싱글턴 패턴으로 작성
    private static int COMICBOOK_ID = 1;
    private static int CUSTOMER_ID = 1;
    private static int RENTAL_ID = 1;

    public static Map<String, ArrayList> mDatabase = new HashMap<>();     // key값은 에서 만든 변수로 value는 Array리스트로 만든다.
    static {
        mDatabase.put("ComicBook", new ArrayList<ComicBookDTO>());
        mDatabase.put("Customer", new ArrayList<CustomerDTO>());
        mDatabase.put("Rental", new ArrayList<RentalDTO>());
    }

    public static CollectionDB getInstance() {
        if (instance == null) {
            instance = new CollectionDB();
        }
        return instance;
    }

    public Map getDB() {
        return mDatabase;
    }

    //Comic Book CRUD (Create => Update => delete)
    //ComicBook Crate
    public void create(ComicBookDTO comicBookDTO) {
        comicBookDTO.setBookId(COMIC_BOOK_ID++);
        mDatabase.get("ComicBook").add(comicBookDTO);
    }

    public void create(CustomerDTO customerDTO) {
        customerDTO.setCustomerSerialNumber(CUSTOMER_ID++);
        mDatabase.get("Customer").add(customerDTO);
    }

    public ComicBookDTO search(ComicBookDTO comicBookDTO) {
        if (mDatabase.get("ComicBook").contains(comicBookDTO)) {
            return comicBookDTO;
        } else return null;
    }

    public CustomerDTO search(CustomerDTO customerDTO) {
        if (mDatabase.get("Customer").contains(customerDTO)) {
            return customerDTO;
        } else return null;
    }
    //ComicBook Update
    public void update(ComicBookDTO comicBookDTO) {
        ArrayList<ComicBookDTO> list = mDatabase.get("ComicBook");
        for (ComicBookDTO ComicBookUpdate : list) {
            if (ComicBookUpdate.getBookId() == comicBookDTO.getBookId()) {
                ComicBookUpdate.setBookId(comicBookDTO.getBookId());
                ComicBookUpdate.setTitle(comicBookDTO.getTitle());
                ComicBookUpdate.setAuthor(comicBookDTO.getAuthor());
            }
            return;
        }
    }

    public void update(CustomerDTO customerDTO) {
        ArrayList<CustomerDTO> list = mDatabase.get("Customer");
        for (CustomerDTO CustomerUpdate : list) {
            if (CustomerUpdate.getCustomerSerialNumber() == customerDTO.getCustomerSerialNumber()) {
                CustomerUpdate.setCustomerID(customerDTO.getCustomerID());
                CustomerUpdate.setCustomerName(customerDTO.getCustomerName());
            }
            return;
        }
    }

    //COmicBook Delete
    public void delete(ComicBookDTO comicBookDTO) {
        mDatabase.get("ComicBook").remove(comicBookDTO);
    }

    public void delete(CustomerDTO customerDTO) {
        mDatabase.get("Customer").remove(customerDTO);
    }

}


