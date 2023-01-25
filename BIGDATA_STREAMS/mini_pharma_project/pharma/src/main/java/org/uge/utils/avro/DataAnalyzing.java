package org.uge.utils.avro;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

// thread Safe
public class DataAnalyzing {

    private final ConcurrentHashMap<String, Integer> drugSold;
    private final AtomicInteger currentTransaction;

    public DataAnalyzing() {
        this.drugSold = new ConcurrentHashMap<>();
        this.currentTransaction = new AtomicInteger();
    }

    public void addDrug(String cip) {
        drugSold.merge(
            cip,
            1,
            Integer::sum
        );
        currentTransaction.incrementAndGet();
    }

    public int getNumberOfTransaction() {
        return currentTransaction.get();
    }

    public void printDrugSold() {
        drugSold.forEach(
            (k, v) -> System.out.println("Médicament n°: " + k + " a été vendu : " + v.toString() + " fois")
        );
    }
}
