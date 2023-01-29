package org.uge;

import org.uge.utils.stream.AnonymKStreams;

import java.io.IOException;
import java.net.URISyntaxException;

public class KStreamMain {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        AnonymKStreams.run();
    }
}
