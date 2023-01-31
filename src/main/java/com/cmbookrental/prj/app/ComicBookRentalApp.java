package com.cmbookrental.prj.app;

import com.cmbookrental.prj.controller.ComicBookController;
import com.cmbookrental.prj.controller.CustomerController;
import com.cmbookrental.prj.controller.RentalController;
import com.cmbookrental.prj.dto.ComicBookDTO;
import com.cmbookrental.prj.dto.CustomerDTO;
import com.cmbookrental.prj.dto.RentalDTO;
import com.cmbookrental.prj.factory.Factory;

import java.util.List;
import java.util.Scanner;

import static com.cmbookrental.prj.comm.CommonCode.COMIC_BOOK_ID;
import static com.cmbookrental.prj.comm.CommonCode.CUSTOMER_ID;

public class ComicBookRentalApp extends AppMethod {

    static ComicBookController comicBookController = Factory.getInstance().getComicBook();
    static CustomerController customerController = Factory.getInstance().getCustomer();

    static RentalController rentalController  = Factory.getInstance().getRental();

    static Scanner scan = new Scanner(System.in);

    public void comicBookDefaultData() {
        comicBookController.create(new ComicBookDTO(COMIC_BOOK_ID, "원피스", "야마다"));
        comicBookController.create(new ComicBookDTO(COMIC_BOOK_ID, "짱구", "이노우에"));

    }
    public void customerDefaultData() {
        customerController.create(new CustomerDTO(CUSTOMER_ID, "qwe", "김새란"));
        customerController.create(new CustomerDTO(CUSTOMER_ID, "asd", "이호창"));
    }


    public void start() throws Exception {
        // 메인 메뉴
        while (true) {
            printMenu(); //메뉴 호출 메서드
            int choiceMenu = scan.nextInt(); //input값을 choice로 넘긴다.
            switch (choiceMenu) {
                case 1:
                    try {
                        crudBooks();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    rentalBooks();
                    break;
                case 3:
                    curdCustomer();
                    break;
                case 0:
                    System.out.println("종료합니다");
                    System.exit(0);
                    break;
                default:
                    System.out.println("정확한 명령어를 입력해주세요");
                    break;
            }
        }
    }

    private void returnBooks() {
    }

    // 만화책 CRUD 구현
    public ComicBookDTO crudBooks() throws Exception {
        boolean bookMenu = true;
        while (bookMenu) {
            crudBooksMenu();
            int choiceComicMenu = scan.nextInt();
            switch (choiceComicMenu) {
                case 1:
                    System.out.println("---만화책 ※전체 조회※---");
                    List<ComicBookDTO> list = comicBookController.findAll();
                    if (list.size() >= 1) {
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println("일련번호 : " + list.get(i).getBookId());
                            System.out.println("제목 : " + list.get(i).getTitle());
                            System.out.println("작가 : " + list.get(i).getAuthor());
                        }
                    } else {
                        System.out.println("만화책 정보가 존재하지 않습니다.");
                    }
                    System.out.println("=======================");
                    break;
                case 2:
                    System.out.println("---만화책 선택 ※조회※---");
                    System.out.print("만화책 제목을 정확하게 입력해주세요: ");
                    String hidden = scan.nextLine();
                    String searchTitle = scan.nextLine();
                    try {
                        ComicBookDTO comicBookDTO = comicBookController.search(searchTitle);
                        System.out.println("만화책 ID: " + comicBookDTO.getBookId());
                        System.out.println("만화책 제목: " + comicBookDTO.getTitle());
                        System.out.println("작가:" + comicBookDTO.getAuthor());
                    } catch (Exception e) {
                        System.out.println("목록에 없는 만화책 입니다.");
                    }
                    break;
                case 3:
                    System.out.println("---만화책 ※등록※---");
                    System.out.printf("만화책 제목: ");
                    String inputTitle = scan.next() + " ";
                    System.out.printf("작가명: ");
                    String inputAuthor = scan.next();
                    ComicBookDTO registerComicBook = new ComicBookDTO(COMIC_BOOK_ID, inputTitle, inputAuthor);
                    comicBookController.create(registerComicBook);
                    System.out.println();
                    System.out.println("＊만화책이 등록되었습니다＊");
                    System.out.println("<<<만화책 ID:" + registerComicBook.getBookId() + "만화책 제목:" + registerComicBook.getTitle() + "작가: " + registerComicBook.getAuthor() + ">>>");
                    System.out.println("======================");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("---만화책 ※수정※---");
                    try {
                        System.out.println("수정하실 만화책의 만화책 ID를 입력해주세요.");
                        System.out.printf("만화책 ID: ");
                        int updateBookID = Integer.parseInt(scan.next());
                        List<ComicBookDTO> updateComicBookList = comicBookController.findAll();
                        int tempID = 0;
                        for (ComicBookDTO cb : updateComicBookList) {
                            if (cb.getBookId() == updateBookID) {
                                tempID = cb.getBookId();
                            }
                        }
                        if (tempID != 0) {
                            System.out.println("변경될 만화책 제목을 입력해주세요:");
                            String updateComicBookTitle = scan.next() + " ";
                            System.out.println("변경될 작가명을 입력해주세요");
                            String updateComicBookAuthor = scan.next() + " ";
                            comicBookController.update(new ComicBookDTO(updateBookID, updateComicBookTitle, updateComicBookAuthor));
                            System.out.println("＊만화책 정보가 수정되었습니다＊");
                        } else {
                            System.out.println("존재하지 않는 만화책 입니다.");
                        }
                    } catch (Exception e) {
                        System.out.println("잘못된 입력입니다.");
                    }
                    break;
                case 5:
                    System.out.println("---만화책 ※삭제※---");
                    System.out.println("삭제하실 만화책 제목을 입력하세요.");
                    System.out.println("만화책 제목: ");
                    String hidden2 = scan.nextLine();
                    String deleteTitlte = scan.nextLine();
                    try {
                        ComicBookDTO comicBookDTO = comicBookController.search(deleteTitlte);
                        comicBookController.delete(comicBookDTO);
                        System.out.println(deleteTitlte + "가 삭제 되었습니다.");
                    } catch (Exception e) {
                        System.out.println("목록에 없는 만화책입니다.");
                    }
                    break;
                case 0:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    bookMenu = false;
                    break;
                default:
                    System.out.println("정확한 명령어를 입력해주세요");
                    break;
            }
        }
        return null;
    }

    // 고객 CRUD 구현
    public CustomerDTO curdCustomer() throws Exception {
        boolean customerMenu = true;
        while (customerMenu) {
            crudCustomerMenu();
            int choiceCustomerMenu = scan.nextInt();
            switch (choiceCustomerMenu) {
                case 1:
                    System.out.println("---고객 ※전체 조회※---");
                    List<CustomerDTO> list = customerController.findAll();
                    if (list.size() >= 1) {
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println("고객 고유 번호 : " + list.get(i).getCustomerSerialNumber());
                            System.out.println("고객 ID : " + list.get(i).getCustomerID());
                            System.out.println("고객 이름 : " + list.get(i).getCustomerName());
                        }
                    } else {
                        System.out.println("고객 정보가 존재하지 않습니다.");
                    }
                    System.out.println("=======================");
                    break;
                case 2:
                    System.out.println("---고객 선택 ※조회※---");
                    System.out.print("고객 ID를 정확하게 입력해주세요: ");
                    String hidden = scan.nextLine();
                    String searchCustomerID = scan.nextLine();
                    try {
                        CustomerDTO customerDTO = customerController.search(searchCustomerID);
                        System.out.println("고객 고유 번호: " + customerDTO.getCustomerSerialNumber());
                        System.out.println("고객 ID: " + customerDTO.getCustomerID());
                        System.out.println("고객 이름:" + customerDTO.getCustomerName());
                    } catch (Exception e) {
                        System.out.println("등록되지 않은 고객 입니다.");
                    }
                    break;
                case 3:
                    System.out.println("---고객 ※등록※---");
                    System.out.printf("고객 ID: ");
                    String inputCustomerID = scan.next() + " ";
                    System.out.printf("고객 이름: ");
                    String inputCustomerName = scan.next();
                    CustomerDTO registerCustomer = new CustomerDTO(CUSTOMER_ID, inputCustomerID, inputCustomerName);
                    customerController.create(registerCustomer);
                    System.out.println();
                    System.out.println("＊고객이 등록되었습니다＊");
                    System.out.println("<<<고객 고유 번호:" + registerCustomer.getCustomerSerialNumber() + "고객 ID:" + registerCustomer.getCustomerID() + "고객 이름: " + registerCustomer.getCustomerName() + ">>>");
                    System.out.println("======================");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("---고객 ※수정※---");
                    try {
                        System.out.println("수정하실 고객의 고객 고유번호를 입력해주세요.");
                        System.out.printf("고객 ID: ");
                        int updateCustomerID = Integer.parseInt(scan.next());
                        List<CustomerDTO> updateCustomerList = customerController.findAll();
                        int tempSerial = 0;
                        for (CustomerDTO cu : updateCustomerList) {
                            if (cu.getCustomerSerialNumber() == updateCustomerID) {
                                tempSerial = cu.getCustomerSerialNumber();
                            }
                        }
                        if (tempSerial != 0) {
                            System.out.println("변경될 고객 ID를 입력해주세요:");
                            String updateCustomerIdentification = scan.next() + " ";
                            System.out.println("변경될 고객 이름을 입력해주세요");
                            String updateCustomerName = scan.next() + " ";
                            customerController.update(new CustomerDTO(updateCustomerID, updateCustomerIdentification, updateCustomerName));
                            System.out.println("＊고객 정보가 수정되었습니다＊");
                        } else {
                            System.out.println("존재하지 않는 고객입니다.");
                        }
                    } catch (Exception e) {
                        System.out.println("잘못된 입력입니다.");
                    }
                    break;
                case 5:
                    System.out.println("---고객 ※삭제※---");
                    System.out.println("삭제하실 고객 ID를 입력하세요.");
                    System.out.println("고객 ID: ");
                    String hidden2 = scan.nextLine();
                    String deleteCustomer = scan.nextLine();
                    try {
                        CustomerDTO customerDTO = customerController.search(deleteCustomer);
                        customerController.delete(customerDTO);
                        System.out.println(deleteCustomer + "가 삭제 되었습니다.");
                    } catch (Exception e) {
                        System.out.println("존재하지 않는 고객입니다.");
                    }
                    break;
                case 0:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    customerMenu = false;
                    break;
                default:
                    System.out.println("정확한 명령어를 입력해주세요");
                    break;
            }
        }
        return null;
    }

    public RentalDTO rentalBooks() throws Exception {
        boolean rentalMenu = true;
        while (rentalMenu) {
            crudRentalMenu();
            int choiceRentalMenu = scan.nextInt();
            switch (choiceRentalMenu) {
                case 1:
                    System.out.println("---대여 ※전체 조회※---");
                    List<RentalDTO> list = rentalController.findAll();
                    if (list.size() >= 1) {
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println("대여 번호 : " + list.get(i).getRentalID());
                            System.out.println("만화책 이름 : " + list.get(i).getBookTitle());
                            System.out.println("대여고객 : " + list.get(i).getCustomerName());
                            System.out.println("대여 날짜 : " + list.get(i).getRentalDate());
                        }
                    } else {
                        System.out.println("고객 정보가 존재하지 않습니다.");
                    }
                    System.out.println("=======================");
                    break;
//                case 2:
//                    System.out.println("---고객 선택 ※조회※---");
//                    System.out.print("고객 ID를 정확하게 입력해주세요: ");
//                    String hidden = scan.nextLine();
//                    String searchCustomerID = scan.nextLine();
//                    try {
//                        CustomerDTO customerDTO = customerController.search(searchCustomerID);
//                        System.out.println("고객 고유 번호: " + customerDTO.getCustomerSerialNumber());
//                        System.out.println("고객 ID: " + customerDTO.getCustomerID());
//                        System.out.println("고객 이름:" + customerDTO.getCustomerName());
//                    } catch (Exception e) {
//                        System.out.println("등록되지 않은 고객 입니다.");
//                    }
//                    break;
//                case 3:
//                    System.out.println("---고객 ※등록※---");
//                    System.out.printf("고객 ID: ");
//                    String inputCustomerID = scan.next() + " ";
//                    System.out.printf("고객 이름: ");
//                    String inputCustomerName = scan.next();
//                    CustomerDTO registerCustomer = new CustomerDTO(CUSTOMER_ID, inputCustomerID, inputCustomerName);
//                    customerController.create(registerCustomer);
//                    System.out.println();
//                    System.out.println("＊고객이 등록되었습니다＊");
//                    System.out.println("<<<고객 고유 번호:" + registerCustomer.getCustomerSerialNumber() + "고객 ID:" + registerCustomer.getCustomerID() + "고객 이름: " + registerCustomer.getCustomerName() + ">>>");
//                    System.out.println("======================");
//                    System.out.println();
//                    break;
//                case 4:
//                    System.out.println("---고객 ※수정※---");
//                    try {
//                        System.out.println("수정하실 고객의 고객 고유번호를 입력해주세요.");
//                        System.out.printf("고객 ID: ");
//                        int updateCustomerID = Integer.parseInt(scan.next());
//                        List<CustomerDTO> updateCustomerList = customerController.findAll();
//                        int tempSerial = 0;
//                        for (CustomerDTO cu : updateCustomerList) {
//                            if (cu.getCustomerSerialNumber() == updateCustomerID) {
//                                tempSerial = cu.getCustomerSerialNumber();
//                            }
//                        }
//                        if (tempSerial != 0) {
//                            System.out.println("변경될 고객 ID를 입력해주세요:");
//                            String updateCustomerIdentification = scan.next() + " ";
//                            System.out.println("변경될 고객 이름을 입력해주세요");
//                            String updateCustomerName = scan.next() + " ";
//                            customerController.update(new CustomerDTO(updateCustomerID, updateCustomerIdentification, updateCustomerName));
//                            System.out.println("＊고객 정보가 수정되었습니다＊");
//                        } else {
//                            System.out.println("존재하지 않는 고객입니다.");
//                        }
//                    } catch (Exception e) {
//                        System.out.println("잘못된 입력입니다.");
//                    }
//                    break;
//                case 5:
//                    System.out.println("---고객 ※삭제※---");
//                    System.out.println("삭제하실 고객 ID를 입력하세요.");
//                    System.out.println("고객 ID: ");
//                    String hidden2 = scan.nextLine();
//                    String deleteCustomer = scan.nextLine();
//                    try {
//                        CustomerDTO customerDTO = customerController.search(deleteCustomer);
//                        customerController.delete(customerDTO);
//                        System.out.println(deleteCustomer + "가 삭제 되었습니다.");
//                    } catch (Exception e) {
//                        System.out.println("존재하지 않는 고객입니다.");
//                    }
//                  break;
                case 0:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    rentalMenu = false;
                    break;
                default:
                    System.out.println("정확한 명령어를 입력해주세요");
                    break;
            }
        }
        return null;
    }

}
