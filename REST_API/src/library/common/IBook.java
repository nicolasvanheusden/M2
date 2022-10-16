package library.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBook extends Remote {
    String author() throws RemoteException;
    String title() throws RemoteException;
    long isbn() throws RemoteException;
    void setAuthor(String author) throws RemoteException;
}
