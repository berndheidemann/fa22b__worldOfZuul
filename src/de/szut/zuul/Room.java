package de.szut.zuul;

import java.util.HashMap;
import java.util.Map;

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

    // key "up" --> dahinter verbirgt sich dann der Raum der oben ist
    private HashMap<String, Room> exits;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void setExit(String direction, Room room) {
        // Füge der Hashmap exists einen Raum "room" hinzu, mit dem Schlüssel "direction"
        this.exits.put(direction, room);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    public Room getExit(String direction) {
        // liefere mir aus der Hashmap exists den Raum mit dem Schlüssel der in direction steht
        return this.exits.get(direction);
    }

    public String exitsToString() {
        StringBuilder response = new StringBuilder("");
        for (String key : this.exits.keySet()) {
            response.append(key + " ");
        }
        return response.toString();
    }

}
