package kr.or.kosa.m11d09.selfstudy.javaproblems;

import java.util.ArrayList;
import java.util.Iterator;

/*
    도서 대출 및 반납 시나리오.

    사용자는 도서관에 방문하여 원하는 도서를 찾습니다.
    사용자가 'Java Programming' 도서를 대출하려고 합니다.
    도서 대출 시스템은 해당 도서의 가용성을 확인하고 대출이 가능하다면 대출 완료 메시지를 출력합니다.
    도서 대출 시스템은 'Java Programming' 도서를 대출 중으로 표시합니다.
    사용자가 'Python Programming' 도서를 대출하려고 시도합니다.
    'Python Programming' 도서는 도서 목록에 없거나 이미 대출 중이어서 대출할 수 없다는
    메시지를 출력합니다.
    사용자가 'Java Programming' 도서를 반납하려고 합니다.
    도서 대출 시스템은 해당 도서가 이미 대출 중인지 확인하고 반납이 가능하다면 반납 완료
    메시지를 출력합니다.
    도서 대출 시스템은 'Java Programming' 도서의 가용성을 true로 업데이트합니다.
    사용자가 'Python Programming' 도서를 반납하려고 시도합니다.
    'Python Programming' 도서는 도서 목록에 없거나 이미 반납되었기 때문에 유효하지 않은
    도서 반납 요청 메시지를 출력합니다.

    도서 추가, 반납, 대출 기능
 */
public class M11D07_02 {
    public static void main(String[] args) {
        Library library = new Library();
        Book java = new Book("Java Programming");
        Book python = new Book("Python Programming");

        library.addBook(java);
        library.addBook(python);

        library.borrowBook("Java Programming");
        library.borrowBook("Python Programming");
        library.borrowBook("Python Programming");

        library.returnBook("Java Programming");
        library.returnBook("Python Programming");
        library.returnBook("Python Programming");
    }
}

class Library {
    ArrayList<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void borrowBook(String bookname) {
        for (Book book : books) {
            if (book.bookname.equals(bookname)) {
                if(book.borrowable) {
                    System.out.println("책을 빌립니다.");
                    book.borrowable = false;
                    return;
                } else {
                    System.out.println("해당 책은 대출 중입니다.");
                    return;
                }
            }
        }
        System.out.println("빌리려는 책이 없습니다.");
    }

    void returnBook(String bookname) {
        for (Book book : books) {
            if (book.bookname.equals(bookname)) {
                if(!book.borrowable) {
                    System.out.println("책을 반납합니다.");
                    book.borrowable = true;
                    return;
                }
            }
        }
        System.out.println("우리 도서관의 책이 아닙니다.");
    }


}

class Book {
    String bookname;
    boolean borrowable;
    Book(String bookname) {
        this.bookname = bookname;
        this.borrowable = true;
    }
}

