package library.server;

import library.common.IBook;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

public class Book extends UnicastRemoteObject implements IBook {

    private final long isbn;
    private final String title;
    private String author;

    public Book(long isbn, String title, String author) throws RemoteException {
        super();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public long isbn() throws RemoteException{
        return isbn;
    }

    @Override
    public void setAuthor(String author) throws RemoteException {
        this.author = author;
    }

    @Override
    public String title() throws RemoteException{
        return title;
    }

    @Override
    public String author() throws RemoteException{
        return author;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Book) obj;
        return this.isbn == that.isbn &&
                Objects.equals(this.title, that.title) &&
                Objects.equals(this.author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author);
    }

    @Override
    public String toString() {
        return "Book[" +
                "isbn=" + isbn + ", " +
                "title=" + title + ", " +
                "author=" + author + ']';
    }

}
