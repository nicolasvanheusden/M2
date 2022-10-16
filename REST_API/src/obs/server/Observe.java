package obs.server;

import obs.common.IObservateur;
import obs.common.IObserve;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Observe extends UnicastRemoteObject implements IObserve {

    private ArrayList<IObservateur> observateursList;

    private int value = 0;

    protected Observe() throws RemoteException {
        super();
        observateursList = new ArrayList<>();
    }

    @Override
    public void subscribe(IObservateur obs) throws RemoteException {
        observateursList.add(obs);
    }

    public void changeValue(int newVal) {
        value = newVal;

        for (var obs: observateursList) {
            try {
                obs.notifyChange(value);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
