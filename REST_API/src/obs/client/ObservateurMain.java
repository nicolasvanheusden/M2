package obs.client;

import obs.common.IObservateur;
import obs.common.IObserve;

import java.rmi.Naming;

public class ObservateurMain {

    public static void main(String[] args) {
        try {
            IObservateur obs1 = new Observateur();
            IObservateur obs2 = new Observateur();
            IObserve sub = (IObserve) Naming.lookup("rmi://localhost:1099/observe");

            sub.subscribe(obs1);
            sub.subscribe(obs2);
        } catch (Exception e) {
            return ;
        }
    }
}
