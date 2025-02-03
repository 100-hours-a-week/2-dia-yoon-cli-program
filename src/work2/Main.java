import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        BookManager bookManager = new BookManager(users);

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
                    System.out.println("프로그램을 종료합니다. 안녕히 가세요");
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
                System.out.println("0. 관리자 영역 \n1. 도서 목록\n2. 도서 대여 / 반납 / 다운로드\n3. 개인 페이지\n4. 로그아웃\n5. 종료하기");
                int choice = sc.nextInt();

                switch (choice) {
                    case 0:
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
                                            sc.nextLine();

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
                                    break;
                                }
                            }
                        } else {
                            System.out.println("관리자만 접근 가능합니다.");
                        }
                        break;

                    case 1:
                        System.out.println("전체 도서 목록을 출력합니다. \n");
                        bookManager.displayBooks();
                        break;

                    case 2:
                        System.out.println("1. 도서 대여\n2. 도서 반납\n3. EBook 다운로드\n");
                        int choice2 = sc.nextInt();
                        switch (choice2) {
                            case 1:
                                System.out.println("대여하실 책의 아이디를 입력하세요: ");
                                int bookID = sc.nextInt();
                                bookManager.borrow(bookID, loggedInUser.userID); // 대여 처리
                                break;
                            case 2:
                                System.out.println("반납하실 책의 아이디를 입력하세요: ");
                                int returnBookID = sc.nextInt();
                                bookManager.returnBook(returnBookID, loggedInUser.userID); // 반납 처리 (추가 필요)
                                break;
                            case 3:
                                System.out.println("EBook을 다운로드 하시려면 책 ID를 입력해주세요: ");
                                int downBookID = sc.nextInt();

                                Book book = bookManager.getBookByID(downBookID); // 책 ID로 책 찾기

                                if (book == null) {
                                    System.out.println("존재하지 않는 책입니다.");
                                } else if (downBookID >= 500) { // 500번 이상이 EBook
                                    System.out.println("EBook을 다운로드합니다.");
                                    System.out.println("이 책의 다운로드 링크: " + ((EBook) book).getDownloadLink());
                                } else {
                                    System.out.println("ebook만 다운로드가 가능합니다.");
                                }
                                break;
                            default:
                                break;
                        }

                        break;

                    case 3:
                        System.out.println("1. 대출 도서 확인\n2. 개인 정보 변경");
                        int choice3 = sc.nextInt();
                        switch (choice3) {
                            case 1:
                                System.out.println("대출하신 도서 목록입니다.");
                                loggedInUser.checkList(); // 대출 도서 목록 출력
                                break;

                            case 2:
                                System.out.println("변경하실 이름을 입력하세요 : ");
                                String newName = sc.next();
                                loggedInUser.updateName(newName);
                                System.out.println("변경하실 이메일을 입력하세요: ");
                                String newEmail = sc.next();
                                loggedInUser.updateEmail(newEmail);
                                System.out.println("정보가 변경되었습니다. ");
                                break;

                            default:
                                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                                break;
                        }
                        break;

                    case 4:
                        // 로그아웃
                        loggedIn = false;
                        loggedInUser = null;
                        System.out.println("로그아웃 되었습니다.");
                        break;

                    case 5:
                        System.out.println("프로그램을 종료합니다. 안녕히 가세요");
                        System.exit(0);
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
