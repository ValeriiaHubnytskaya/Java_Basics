package ITStep.learning.oop;

public class Book extends Literature{
    private String author;

    public Book(String author, String title) {
        this.author = author;
        super.setTitle(title);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override //аннотации
    public String toString() {
        return this.author + ":" + super.toString();
    }
}
/*
    Parent{m}
 */