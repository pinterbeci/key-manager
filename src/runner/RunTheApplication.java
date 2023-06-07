package runner;

import reader.ReadClientCommands;

import java.io.IOException;

public class RunTheApplication {
    public static void main(String[] args) {
        try {
            ReadClientCommands.readCommands();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
