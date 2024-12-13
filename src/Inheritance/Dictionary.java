package Inheritance;

public class Dictionary extends Book {

    private int defs;
    public Dictionary(String title, int pages, int x) {
        super(title,pages);
        defs = x;

    }


    public void defs_message() {
        System.out.print("Number of defs:\t\t"+defs+"\n");
        System.out.print("Defs per page:\t\t"+defs/pages+"\n");
    }


    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("dict12",200,400);
        dictionary.page_message();
        dictionary.defs_message();
        dictionary.printTitle();
    }
}