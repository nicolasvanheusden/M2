package obs.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ObserveMain {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            var obs = new Observe();
            Naming.rebind("rmi://localhost/1099/observe", obs);

            for (int i=1; i<=30; i++) {
                obs.changeValue(i*10);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            return ;
        }
    }
}
