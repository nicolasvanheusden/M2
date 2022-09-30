package calculator.client;

import calculator.common.ICalculator;
import calculator.server.Calculator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient  {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(1099);

        ICalculator calculator = (ICalculator) reg.lookup("Calculator");

        System.out.println(calculator.add(1, 2));

        /* cours
            ICalculator c = (ICalculator) Naming.lookup("calculator");
            System.out.println(calculator.add(1, 2));
         */

    }
}
