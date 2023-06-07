package manager;

import validation.KeyValidator;

import java.util.HashMap;
import java.util.Map;

public class KeyManager {

    private static final Map<Integer, Boolean> keysDataMap;

    private static boolean isReleasedKey;

    static {
        keysDataMap = new HashMap<>();
    }

    public int getKey() {
        if (keysDataMap.isEmpty()) {
            keysDataMap.put(0, true);
            isReleasedKey = false;
            return 0;
        }

        for (Map.Entry<Integer, Boolean> currentKey : keysDataMap.entrySet()) {
            if (Boolean.FALSE.equals(currentKey.getValue())) {
                keysDataMap.put(currentKey.getKey(), true);
                isReleasedKey = false;
                return currentKey.getKey();
            }

            if (isReleasedKey) {
                keysDataMap.put(currentKey.getKey(), true);
            } else {
                keysDataMap.put(lastKeyValue() + 1, true);
                return lastKeyValue();
            }
        }
        return -1;
    }

    public boolean releaseKey(int key) {
        for (Map.Entry<Integer, Boolean> currentKey : keysDataMap.entrySet()) {
            if (KeyValidator.isValidKey(key) && currentKey.getKey().equals(key)) {
                keysDataMap.put(currentKey.getKey(), false);
                isReleasedKey = true;
                return true;
            }
        }

        return false;
    }

    private int lastKeyValue() {
        int returValue = 0;
        for (Map.Entry<Integer, Boolean> currentKey : keysDataMap.entrySet()) {
            returValue = currentKey.getKey();
        }
        return returValue;
    }


}
