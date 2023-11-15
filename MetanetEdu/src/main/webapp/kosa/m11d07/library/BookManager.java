package kr.or.kosa.m11d07.library;
import java.io.*;
import java.util.*;
public class BookManager implements Serializable {
    private Map<String, Book> hashMap;
    Scanner sc = new Scanner(System.in);
    BookManager() {hashMap = new HashMap<>();}

    public void Run() {
        program : while (true) {
            System.out.println("1:추가(현재 작업영역) 2:삭제(현재 작업영역) 3:검색(현재 작업영역) 4:도서목록(현잭 작업영역)\n5:ISBN목록(현재 작업영역) 6:저장(파일) 7:불러오기(파일) 0:종료");
            String selectedMenu = sc.nextLine(); //사용자 메뉴 선택 받기.
            try { //사용자 입력 예외 처리
                if (selectedMenu == null) {
                    System.out.println("값을 입력하지 않으셨습니다. 0~7 사이의 값을 입력하세요.");
                    continue;
                }
                int menuChoice = Integer.parseInt(selectedMenu);
                if (menuChoice < 0 || menuChoice > 7) {
                    throw new InputMismatchException("0~7 사이의 값으로 다시 입력하세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("값을 잘못 입력하셨습니다.\n0~7 사이의 값을 입력해주세요.");
                continue ;
            }
            switch (selectedMenu) {
                case "0" : //종료
                    System.out.println("=======시스템이 종료됩니다.=========");
                    break program;
                case "1" : //추가
                    addBook();
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
                case "6" : //도서 Book Map 에 저장
                    saveBooks();
                    break;
                case "7" : //도서 Book Map 역직렬화
                    loadBooks();
                    break;
            }
        }
    }
    public void saveBooks() {
        System.out.println("======= 파일에 로컬 영역에 생성된 책들을 저장합니다. =========");
        File file = new File("books.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            //먼저 파일에서 객체를 읽어온 다음에, 읽어온 객체에 값을 담아서 다시 입력해줘야 하나?
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Map<String, Book> loadedbooks = (HashMap<String, Book>) ois.readObject();
            loadedbooks.putAll(hashMap); //로컬 데이터를 loadedbooks 에 담아준다.

            fos = new FileOutputStream(file); //append 하니 안되서, Replace 로 진행
            oos = new ObjectOutputStream(fos);
            oos.writeObject(loadedbooks);
        } catch (Exception e) {
            System.out.println("에러발생!!!");
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        hashMap.clear(); // 저장하고 난 이후에는 로컬 영역 초기화
        System.out.println("======= 도서(Map) 저장 완료 =========");
    }
    public void loadBooks() {
        File file = new File("books.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Map<String, Book> loadedbooks = (HashMap<String, Book>) ois.readObject();
            Set<Map.Entry<String, Book>> entries = loadedbooks.entrySet();
            System.out.println("ISBN\t제목\t\t\t가격");
            for (Map.Entry<String, Book> entry : entries) {
                String isbn = entry.getValue().isbn;
                String title = entry.getValue().title;
                int price = entry.getValue().price;
                System.out.println(isbn + "\t\t" + title + "\t\t" + price);
            }
        } catch (Exception e) {
            System.out.println("불러오는데 실패하였습니다.");
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
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
        System.out.println("새로운 도서 " + book + "을 로컬 작업영역에 생성하였습니다.");
        System.out.println("======= 도서 생성 완료 =========");
    }

    //도서 삭제
    public void deleteBook() {
        System.out.println("======= 로컬 영역의 책을 삭제합니다. 정보를 입력해주세요.=========");
        System.out.println("삭제할 도서 ISBN : ");
        String isbn = sc.nextLine();
        System.out.println("======= 도서 삭제 완료 =========");
        hashMap.remove(isbn);
    }

    //도서 검색
    public void searchBook() {
        System.out.println("======= 로컬 영역에서 책을 검색합니다. 정보를 입력해주세요.=========");
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
        System.out.println("========= 로컬 영역의 도서 목록을 검색합니다. =========");
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
        System.out.println("========= 로컬 영역의 isbn 목록을 검색합니다. =========");
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
