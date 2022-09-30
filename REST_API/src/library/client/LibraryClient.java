package library.client;

import library.common.Book;
import library.common.ILibrary;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LibraryClient {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        var library = (ILibrary) Naming.lookup("rmi://localhost/Library");

        library.addBook(123, "Philo", "Benoit");
        library.addBook(1235, "Math", "Mamadou");
        library.addBook(1236, "Science", "Ahmed");
        library.addBook(1237, "Chimie", "David");

        var books = library.findBookByAuthor("Benoit");
        System.out.println(books);
    }
}
