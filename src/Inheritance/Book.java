package Inheritance;

public class Book {

    protected int pages;
    protected String title;

    public Book(String title, int pages) {
        this.pages = pages;
        this.title = title;
    }
    public void page_message() {
        System.out.print("Number of pages:\t"+pages+"\n");
    }

    public void printTitle(){
        System.out.println(title);
    }

}
