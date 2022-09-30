package library.server;



import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class LibraryServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(1099);
        Library library = new Library();
        Naming.rebind("rmi://localhost/Library", library);
        System.out.println("Le Serveur est prêt...");
    }
}
