package de.szut.zuul;

import de.szut.zuul.Item;

import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 * <p>
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north,
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room {
    private String description;


    // Was bedeutet dieses <String, Room> hier im Kontext einer HashMap? -->
    //    String  -> Text
    //    Room    -> Raum
    // Eine Hashmap hat einen zu speichernden Value (Ein Room Objekt) und einen Schlüssel (String)
    private HashMap<String, Room> exits;
    private HashMap<String, Item> items;


    // Konstruktor, mit dem Parameter "description"
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        // wir legen eine neue Hashmap an und speichern sie in this.exits
        this.exits = new HashMap<>();
        // wir legen eine neue Hashmap an und speichern sie in this.items
        this.items = new HashMap<>();
        // this.description --> Attribut bzw. Instanzvariable
        // description --> Parameter bzw. die lokale Variable
        this.description = description;  // --> Wertzuweisung --> Wir weisen dem Attribut den Wert des Parameters zu
    }

    public void putItem(Item item) {
        // Wir speichern das Item "item" unter dem Schlüssel "Name des Items" ab
        this.items.put(item.getName(), item);
    }


    public void setExit(String direction, Room neighbour) {
        // Hier wird die Hashmap exists mit einem Wert gefüllt
        // Der Value ist der Room neighbour
        // Der Schlüssel ist der String direction
        // ---> wir speichern den Room "neighbour" unter dem Schlüssel "direction" ab
        this.exits.put(direction, neighbour);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    public Room getExit(String direction) {
        // Es wird der Value, der unter dem Schlüssel "direction" hinterlegt ist (siehe setExit) abgefragt
        return this.exits.get(direction);
    }

    public String exitsToString() {
        // Warum StringBuilder? ---> er ist schneller
        // Hier benennen wir die Variable (dummerweise) genauso wie die Hashmap exits
        // Das geht, da man in einer Methode eine Variable nochmal definieren kann, auch wenn sie außerhalb der Methode schon existiert
        // (Variablenüberdeckung)
        StringBuilder exits = new StringBuilder();

        // for( :  ) --> Schleife und zwar eine for-each-Schleife
        // for ( einzelne Element : Liste ) --> gehe jedes Element der Liste durch und "kopiere"
        // es in die Variable die links steht und führe dann den Schleifenrumof aus

        // this.exits.keySet() --> eine Liste aller Schlüssel in der Hashmap exists
        for (String key : this.exits.keySet()) {    // -->  HashMap exits, da das this davor steht. Damit spreche ich Instanzvariablen an
            exits.append(key + " ");                // --> StringBuilder exits
        }
        return exits.toString();                    // --> StringBuilder  exits
    }

    public String itemsToString() {
        StringBuilder itemsAsStr = new StringBuilder();
        for (String key : this.items.keySet()) {
            Item item = this.items.get(key);
            itemsAsStr.append("- " + item.toString() + "\n");
        }
        return itemsAsStr.toString();
    }

    public String getLongDescription() {
        // %s steht als Platzhalter für einen String

        // 1. %s --> description
        // 2. %s --> exitsToString()
        // 3. %s --> itemsToString()
        return String.format("You are %s\nExits: %s\nItems in this room:\n%s", description, exitsToString(), itemsToString());
    }

    public Item removeItem(String name) {
        // this.items --> Hashmap mit Schlüssel String und Value Item --> In this.items sind Items anhand ihres Namens gespeichert
        // Suche in der Hashmap das Item mit dem Schlüssel "name" und entferne das Item und den Schlüssel
        return this.items.remove(name);
    }
}
