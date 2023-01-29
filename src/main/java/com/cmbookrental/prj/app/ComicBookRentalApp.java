package com.cmbookrental.prj.app;

import com.cmbookrental.prj.controller.ComicBookController;
import com.cmbookrental.prj.dto.ComicBookDTO;
import com.cmbookrental.prj.dto.CustomerDTO;
import com.cmbookrental.prj.factory.Factory;

import java.util.List;
import java.util.Scanner;

import static com.cmbookrental.prj.comm.CommonCode.COMIC_BOOK_ID;
import static com.cmbookrental.prj.comm.CommonCode.CUSTOMER_ID;

public class ComicBookRentalApp extends AppMethod {

    static ComicBookController comicBookController = Factory.getInstance().getComicBook();
    //static CustomerController customerController = Factory.getInstance().getCustomer();
    static Scanner scan = new Scanner(System.in);

    public void comicBookDefaultData() {
        comicBookController.create(new ComicBookDTO(COMIC_BOOK_ID, "원피스", "김철수"));
        comicBookController.create(new ComicBookDTO(COMIC_BOOK_ID, "짱구", "송대관"));

    }

//    public void customerDefaultData() {
//        customerController.create(new CustomerDTO(CUSTOMER_ID, "안녕ksd", "김철수"));
//        customerController.create(new CustomerDTO(CUSTOMER_ID, "안녕wewew", "송대관"));
//    }

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
                    returnBooks();
                    break;
                case 4:
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
                    System.out.println("책 번호: " + COMIC_BOOK_ID + " ");
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
                        System.out.println("수정하실 만화책 ID를 입력해주세요.");
                        int updateID = scan.nextInt();
                        int temp = 0;
                        List<ComicBookDTO> updateComicBookList = comicBookController.findAll();
                        for (ComicBookDTO updateNum : updateComicBookList) {
                            if (updateNum.getBookId() == updateID) {
                                temp = updateNum.getBookId();
                            }
                        }
                        if (temp != 0) {
                            System.out.println("만화책 제목을 입력해주세요:");
                            String updateTitle = scan.next() + " ";
                            System.out.println("작가명을 입력해주세요");
                            String updateAuthor = scan.next() + " ";
                            comicBookController.update(new ComicBookDTO(updateID, updateTitle, updateAuthor));
                            System.out.println("＊만화책 정보가 수정되었습니다＊");
                        } else {
                            System.out.println("잘못된 입력입니다.");
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

    private void curdCustomer() {
    }
    private static void rentalBooks() {
    }

    private static void returnBooks() {
    }



}



