package kr.or.kosa.m11d07.library;
import java.util.*;
public class BookManager {
    private Map<String, Book> hashMap;
    Scanner sc = new Scanner(System.in);
    BookManager() {hashMap = new HashMap<>();}

    public void Run() {
        program : while (true) {
            System.out.println("1:추가 2:삭제 3:검색 4:도서목록 5:ISBN목록 0:종료");
            String selectedMenu = sc.nextLine(); //사용자 메뉴 선택 받기.
            try { //사용자 입력 예외 처리
                if (selectedMenu == null) {
                    System.out.println("값을 입력하지 않으셨습니다. 0~5 사이의 값을 입력하세요.");
                    continue;
                }
                int menuChoice = Integer.parseInt(selectedMenu);
                if (menuChoice < 0 || menuChoice > 5) {
                    throw new InputMismatchException("0~5 사이의 값으로 다시 입력하세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("값을 잘못 입력하셨습니다.\n0~5 사이의 값을 입력해주세요.");
                continue ;
            }
            switch (selectedMenu) {
                case "0" : //종료
                    System.out.println("=======시스템이 종료됩니다.=========");
                    break program;
                case "1" : //추가
                    addBook();
                    System.out.println("======= 도서 등록 완료 =========");
                    break;
                case "2" : //삭제
                    deleteBook();
                    break;
                case "3" : //검색
                    searchBook();
                    break;
                case "4" : //도서목록
                    getBookList();
                    break;
                case "5" : //ISBN 목록
                    getIsbnList();
                    break;
            }
        }
    }

    //도서 추가
    public void addBook() {
        System.out.println("=======새로운 책을 추가합니다. 정보를 입력해주세요.=========");
        System.out.println("추가할 도서 ISBN : ");
        String isbn = sc.nextLine(); //여기도 사용자 입력 실수에 대비한 코드를 해야하는데, 생략합니다.
        System.out.println("도서 제목 : ");
        String title = sc.nextLine();
        System.out.println("가격 : ");
        int price = sc.nextInt();
        /*
            nextInt( ) 는 nextLine() 과는 다르게 newline character 를
            소모하지 않는다. 그래서, newline character는 그대로
            input buffer 에 남아있게 됩니다.
            그 상태로 다시 nextLine( ) 이 수행되면,
            사용자로부터 새로운 값을 받는 것이 아니라
            input buffer 에 남아있는 null 을 처리해버립니다.
            그래서 sc.nextLine( ) 을 사용하여,
            input buffer 를 비워버리는 작업을 해줘야 합니다.
         */
        sc.nextLine(); // Consume the newline character
        Book book = new Book(isbn, title, price);
        hashMap.put(isbn, book);
        System.out.println("새로운 도서 " + book + "을 생성하였습니다.");
    }

    //도서 삭제
    public void deleteBook() {
        System.out.println("======= 책을 삭제합니다. 정보를 입력해주세요.=========");
        System.out.println("삭제할 도서 ISBN : ");
        String isbn = sc.nextLine();
        System.out.println("======= 도서 삭제 완료 =========");
        hashMap.remove(isbn);
    }

    //도서 검색
    public void searchBook() {
        System.out.println("======= 책을 검색합니다. 정보를 입력해주세요.=========");
        System.out.println("검색할 도서 ISBN : ");
        String isbn = sc.nextLine();
        Book searchedbook = hashMap.get(isbn);
        if (searchedbook == null) {
            System.out.println("출력할 도서가 없습니다.");
        }
        System.out.println("검색 결과>>" + searchedbook);
        System.out.println("======= 도서 검색 완료 =========");
    }

    //도서 목록
    public void getBookList() {
        List<Book> books = new ArrayList<>(hashMap.values());
        //books.addAll(hashMap.values()); //간단하게 생성자에 넣어서 다른 List로 담아줄 수 있다..
        System.out.println("========= 도서 목록을 검색합니다. =========");
        if (books.isEmpty()) {
            System.out.println("출력할 도서 목록이 없습니다.");
        }
        System.out.println("도서 수 : " + books.size());
        for (Book book : books) {
            System.out.println(book.toString()); //도서 정보 출력
        }
        System.out.println("======= 도서 목록 출력 완료 =========");
    }
    public void getIsbnList() {
        System.out.println("========= isbn 목록을 검색합니다. =========");
        List<Book> books = new ArrayList<>(hashMap.values());
        if (books.isEmpty()) {
            System.out.println("출력할 isbn 목록이 없습니다.");
        }
        System.out.println("도서 수 : " + books.size());
        for (Book book : books) {
            System.out.println(book.ISBN()); //도서 정보 출력
        }
        System.out.println("======= isbn 목록 출력 완료 =========");
    }
}
