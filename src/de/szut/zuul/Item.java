package de.szut.zuul;

public class Item {

    // private --> nur in dieser Klasse sichtbar (kann nicht vererbt werden)
    private String name;
    private String description;
    private double weight;


    // Konstruktor
    // kein Rückgabewert
    // heißt genauso wie die Klasse
    public Item(String name, String description, double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public String toString() {
        return this.name + ", " + this.description + ", " + this.weight;
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }
}
