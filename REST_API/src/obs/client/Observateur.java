package obs.client;

import obs.common.IObservateur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Observateur extends UnicastRemoteObject implements IObservateur {

    public Observateur() throws RemoteException {
        super();
    }

    @Override
    public void notifyChange(int value) throws RemoteException {
        System.out.println(value);
    }
}
