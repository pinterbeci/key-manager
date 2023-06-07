package validation;

public class KeyValidator {

    public static boolean isValidKey(int key) {
        return (key >= 0 && key < Integer.MAX_VALUE);
    }
}
