package kr.or.kosa.m11d07.library;

public class Book {
    final String isbn; //도서번호
    String title; //도서제목
    int price; //도서 가격

    public Book(String isbn, String title,int price){
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    public String ISBN(){
        return isbn;
    }

    public String toString(){
        return String.format("ISBN:%s 이름:%s 가격:%d", isbn, title,price);        }
}
