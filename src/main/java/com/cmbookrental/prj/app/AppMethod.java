package com.cmbookrental.prj.app;

public class AppMethod {

    // 메인 메뉴 호출 메서드
    public static void printMenu() {
        System.out.println("<메뉴 선택>");
        System.out.println("1. 만화책 조회/등록/수정/삭제");
        System.out.println("2. 대여 조회/등록/반납");
        System.out.println("3. 고객 조회/등록/수정/삭제");
        System.out.println("0. 프로그램 종료");
        System.out.println("=====================");
        System.out.println("");
        System.out.print("번호를 입력하세요: ");
    }

    // 만화책 CRUD 메뉴 호출 메서드
    public static void crudBooksMenu() {
        System.out.println("<---메뉴 선택--->");
        System.out.println("1. 만화책 전체 조회");
        System.out.println("2. 만화책 조회");
        System.out.println("3. 만화책 등록");
        System.out.println("4. 만화책 수정");
        System.out.println("5. 만화책 삭제");
        System.out.println("0. 이전 메뉴");
        System.out.println("=====================");
        System.out.println("");
        System.out.print("번호를 입력하세요: ");
    }

    public static void crudCustomerMenu() {
        System.out.println("<---메뉴 선택--->");
        System.out.println("1. 고객 전체 조회");
        System.out.println("2. 고객 조회");
        System.out.println("3. 고객 등록");
        System.out.println("4. 고객 수정");
        System.out.println("5. 고객 삭제");
        System.out.println("0. 이전 메뉴");
        System.out.println("=====================");
        System.out.println("");
        System.out.print("번호를 입력하세요: ");
    }

    public static void crudRentalMenu() {
        System.out.println("<---메뉴 선택--->");
        System.out.println("1. 대여 전체 조회");
        System.out.println("2. 대여 조회");
        System.out.println("3. 대여 등록");
        System.out.println("4. 대여 수정");
        System.out.println("5. 대여 삭제");
        System.out.println("0. 이전 메뉴");
        System.out.println("=====================");
        System.out.println("");
        System.out.print("번호를 입력하세요: ");
    }
}


