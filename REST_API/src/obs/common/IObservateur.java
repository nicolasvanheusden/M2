package obs.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObservateur extends Remote {

    void notifyChange(int value) throws RemoteException;
}
