package library.server;


import library.common.Book;
import library.common.ILibrary;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Library extends UnicastRemoteObject implements ILibrary {

    private final HashMap<Long, Book> bdd;

    public Library() throws RemoteException {
        super();
        this.bdd = new HashMap<>();
    }

    @Override
    public boolean addBook(long isbn, String title, String author) throws RemoteException{
        Objects.requireNonNull(title);
        Objects.requireNonNull(author);
        bdd.put(isbn, new Book(isbn, title, author));
        return true;
    }

    @Override
    public boolean removeBook(long isbn) throws RemoteException {
        return bdd.remove(isbn) != null;
    }

    @Override
    public List<Book> findBookByTitle(String title) throws RemoteException{
        var list = new ArrayList<Book>();
        for (var book: bdd.values()) {
            if (book.title().equals(title)) {
                list.add(book);
            }
        }
        return list;
    }

    @Override
    public List<Book> findBookByAuthor(String author) throws RemoteException {
        var list = new ArrayList<Book>();
        for (var book: bdd.values()) {
            if (book.author().equals(author)) {
                list.add(book);
            }
        }
        return list;
    }
}
