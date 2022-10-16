package library.common;

import library.server.Book;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ILibrary extends Remote {

    boolean addBook(long isbn, String title, String author) throws RemoteException;
    boolean removeBook(long isbn) throws RemoteException;
    List<IBook> findBookByTitle(String title) throws RemoteException;
    List<IBook> findBookByAuthor(String author) throws RemoteException;
}
