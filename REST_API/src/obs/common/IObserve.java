package obs.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObserve extends Remote {

    void subscribe(IObservateur obs) throws RemoteException;
}
