package fr.uge.jee.printers;

public class SlowConstructionMessagePrinter implements MessagePrinter {

    public SlowConstructionMessagePrinter() {
        try {
            wait(5000);
        } catch (InterruptedException e) {
            return ;
        }
    }

    @Override
    public void printMessage() {

    }
}
