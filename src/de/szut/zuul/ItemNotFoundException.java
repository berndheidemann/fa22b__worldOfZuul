package de.szut.zuul;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException() {
        super("This item does not exist!");
    }
}
