package de.szut.zuul;

public class ItemTooHeavyException extends Exception {

    public ItemTooHeavyException() {
        super("Item is too heavy!");
    }
}
