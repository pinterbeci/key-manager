package validation;

import java.util.Arrays;

public class LineValidator {

    private LineValidator(){
        throw new IllegalStateException("Validator class");
    }
    public static boolean isValidReadedLine(String line) {

        String[] validCommands = {"KeyManager.getKey()",
                "KeyManager.releaseKey(",
                "Done!"};

        return Arrays.stream(validCommands).anyMatch(s -> {
            if ((line).startsWith("KeyManager.releaseKey("))
                return true;
            return s.equals(line);
        });
    }
}
