package model;

public class Key {

    private int keyValue;

    private boolean isFreeKey;

    public Key() {
    }

    public int getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(int keyValue) {
        this.keyValue = keyValue;
    }

    public boolean isFreeKey() {
        return isFreeKey;
    }

    public void setFreeKey(boolean freeKey) {
        isFreeKey = freeKey;
    }
}
