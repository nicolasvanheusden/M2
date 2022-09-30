package calculator.server;

import calculator.common.ICalculator;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Calculator calculator = new Calculator();
        ICalculator stub = (ICalculator) UnicastRemoteObject.exportObject(calculator, 0);
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.bind("Calculator", stub);
        System.out.println("Le Serveur est prêt...");

        /*
            cours :
             LocateRegistry.createRegistry(1099);
             ICalculator c = new Calculator();
             Naming.rebind("calculator", c);
         */

    }
}
