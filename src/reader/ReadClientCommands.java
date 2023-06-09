package reader;

import manager.KeyManager;
import validation.LineValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadClientCommands {

    private ReadClientCommands(){
        throw new IllegalStateException("Utility class");
    }
    public static void readCommands() throws IOException {
        KeyManager keyManager = new KeyManager();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String readedLine;
        System.out.println("If you use 'KeyManager.getKey()' command, you get a new key!");
        System.out.println("If you use 'KeyManager.releaseKey(int key)' command, you can release a key!");
        System.out.println("If you use 'Done!' command, you finish the process!");
        System.out.println("Add command: ");

        do {
            readedLine = bufferedReader.readLine();

            if (LineValidator.isValidReadedLine(readedLine)) {
                if ("KeyManager.getKey()".equals(readedLine)) {
                    System.out.println("get this key = " + keyManager.getKey());
                }

                if ((readedLine).startsWith("KeyManager.releaseKey(")) {
                    int releaseThisKey = Integer.parseInt(readedLine.replaceAll("[\\D]", ""));
                    System.out.println("released this key = " + releaseThisKey);
                    System.out.println("release is succesed = " + keyManager.releaseKey(releaseThisKey));
                }
            } else {
                System.out.println("Wrong command!");
            }

        } while (!readedLine.equals("Done!"));
    }

}
