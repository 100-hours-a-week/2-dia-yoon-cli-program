package work2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager bookManager = new BookManager();

        ArrayList<User> users = new ArrayList<>();
        int userIdCounter = 1;
        boolean loggedIn = false;  // 로그인 상태 추적 변수
        User loggedInUser = null;  // 로그인한 사용자 객체
        int paperBookCounter = 100; // Paper 책 ID 카운트
        int eBookCounter = 500; // EBook 책 ID 카운트

        while (true) {
            if (!loggedIn) {
                // 로그인 안 된 상태
                System.out.println("1. 회원가입\n2. 로그인\n3. 종료하기");
                int choice = sc.nextInt();

                if (choice == 3) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                switch (choice) {
                    case 1:
                        System.out.println("회원가입을 진행합니다.");
                        System.out.println("이름을 입력하세요");
                        String name = sc.next();
                        System.out.println("이메일을 입력하세요");
                        String mail = sc.next();
                        User user = new User(userIdCounter++, name, mail);
                        users.add(user);
                        System.out.println("회원가입이 완료되었습니다.\n 회원정보를 출력합니다. \n");
                        System.out.println("ID: " + user.getUserID());
                        System.out.println("이름: " + user.getName());
                        System.out.println("이메일: " + user.getEmail());
                        System.out.println();
                        break;

                    case 2:
                        System.out.println("로그인을 진행합니다.");
                        System.out.println("이름을 입력하세요");
                        name = sc.next();
                        System.out.println("이메일을 입력하세요");
                        mail = sc.next();

                        boolean isUserFound = false;
                        for (User u : users) {
                            if (u.getName().equals(name) && u.getEmail().equals(mail)) {
                                loggedIn = true;
                                loggedInUser = u;  // 로그인한 사용자 설정
                                System.out.println("로그인 성공!");
                                isUserFound = true;
                                break;
                            }
                        }

                        if (!isUserFound) {
                            System.out.println("이름 또는 이메일이 잘못되었습니다. 다시 시도하세요.");
                        }
                        break;

                    default:
                        System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                        break;
                }
            } else {
                // 로그인된 상태
                //System.out.println("로그인된 사용자: " + loggedInUser.getName());
                System.out.println("1. 책 정보 조회\n2. 책 대여 / 반납 / 다운로드\n3. 책 예약\n4. 관리자 영역\n5. 로그아웃\n6. 종료하기");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        bookManager.displayBooks();
                        break;

                    case 2:
                        System.out.println("책 대여, 반납, 다운로드 기능 구현 예정");
                        break;

                    case 3:
                        System.out.println("책 예약 기능 구현 예정");
                        break;

                    case 4:
                        // 관리자 영역
                        System.out.println("관리자 ID를 입력하세요:");
                        int userID = sc.nextInt();
                        if (userID == 9999) {
                            // 관리자 메뉴
                            while (true) {
                                System.out.println("1. 책 추가\n2. 책 삭제\n3. 관리자 페이지 나가기");
                                int adminChoice = sc.nextInt();

                                switch (adminChoice) {
                                    case 1:
                                        System.out.println("책 유형을 선택하세요\n 1. Paper 2. EBook");
                                        int typeChoice = sc.nextInt();
                                        sc.nextLine();

                                        System.out.println("책 제목 입력: ");
                                        String title = sc.nextLine();

                                        System.out.println("저자 입력: ");
                                        String author = sc.nextLine();

                                        System.out.println("장르 입력: ");
                                        String genre = sc.nextLine();

                                        System.out.println("출판년도 입력: ");
                                        int publishYear = sc.nextInt();

                                        System.out.println("페이지 수 입력: ");
                                        int page = sc.nextInt();

                                        if (typeChoice == 1) {
                                            // Paper 책 추가
                                            Paper paperBook = new Paper(paperBookCounter++,title, author, genre, publishYear, page);
                                            bookManager.addBook(paperBook);
                                            System.out.println("Paper 책이 추가되었습니다.");
                                        } else if (typeChoice == 2) {
                                            // EBook 책 추가
                                            System.out.println("파일 크기(MB) 입력: ");
                                            double fileSize = sc.nextDouble();
                                            sc.nextLine(); // 버퍼 비우기

                                            System.out.println("다운로드 링크 입력: ");
                                            String downloadLink = sc.nextLine();

                                            EBook eBook = new EBook(eBookCounter++, title, author, genre, publishYear, page, fileSize, downloadLink);
                                            bookManager.addBook(eBook);
                                            System.out.println("EBook 책이 추가되었습니다.");
                                        } else {
                                            System.out.println("잘못 입력하셨습니다");
                                        }
                                        break;

                                    case 2:
                                        System.out.print("삭제할 책 ID 입력: ");
                                        int bookID = sc.nextInt();
                                        bookManager.removeBook(bookID);
                                        break;

                                    case 3:
                                        // 관리자 페이지 나가기
                                        break;

                                    default:
                                        System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                                        break;
                                }

                                // 관리자 메뉴에서 나갔으면 일반 사용자 메뉴로 돌아가기
                                if (adminChoice == 3) {
                                    break; // 관리자 메뉴를 빠져나가면 일반 사용자 메뉴로 돌아감
                                }
                            }
                        } else {
                            System.out.println("관리자만 접근 가능합니다.");
                        }
                        break;

                    case 5:
                        // 로그아웃
                        loggedIn = false;
                        loggedInUser = null;
                        System.out.println("로그아웃 되었습니다.");
                        break;

                    case 6:
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0); // 프로그램 종료
                        break;

                    default:
                        System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                        break;
                }
            }
        }
        sc.close();
    }
}
