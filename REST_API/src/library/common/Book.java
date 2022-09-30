package library.common;

import java.io.Serializable;

public record Book(long isbn, String title, String author) implements Serializable {}
