package fr.uge.jee.printers;

import java.util.Objects;

public class CustomizableMessagePrinter implements MessagePrinter {

    private final String message;

    public CustomizableMessagePrinter(){
        this.message="Custom Hello World";
    }

    public CustomizableMessagePrinter(String message) {
        Objects.requireNonNull(message);
        this.message = message;
    }


    @Override
    public void printMessage() {
        System.out.println(message);
    }
}
