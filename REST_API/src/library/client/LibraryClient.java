package library.client;

import library.common.ILibrary;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LibraryClient {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {


        try {
            var library = (ILibrary) Naming.lookup("rmi://localhost:1099/Library");

            library.addBook(123, "Philo", "Benoit");
            library.addBook(1235, "Math", "Mamadou");
            library.addBook(1236, "Science", "Ahmed");
            library.addBook(1237, "Chimie", "David");

            var books = library.findBookByAuthor("Benoit");
            System.out.println(books);
            books.get(0).setAuthor("Baptiste");
            books = library.findBookByAuthor("Benoit");
            System.out.println(books.get(0));

        } catch (Exception e) {
            System.out.println("Trouble " + e);
        }
    }
}
