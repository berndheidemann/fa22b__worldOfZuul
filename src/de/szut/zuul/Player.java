package de.szut.zuul;

import java.util.LinkedList;

public class Player {

    private Room currentRoom;
    private LinkedList<Item> items;
    private double loadCapacity;

    public Player() {
        this.loadCapacity = 10;
        this.items = new LinkedList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void goTo(Room newRoom) {
        this.currentRoom = newRoom;
    }

    public void takeItem(Item item) throws ItemTooHeavyException {
        if (isTakePossible(item)) {
            this.items.add(item);
        } else {
            throw new ItemTooHeavyException();
        }
    }

    private boolean isTakePossible(Item item) {
        return calculateWeight() + item.getWeight() <= this.loadCapacity;
    }

    private double calculateWeight() {
        double sum = 0;
        for (Item i : this.items) {
            sum += i.getWeight();
        }
        return sum;
    }

    public Item dropItem(String name) throws ItemNotFoundException {
        for (Item i : this.items) {
            if (i.getName().equals(name)) {
                this.items.remove(i);
                return i;
            }
        }
        throw new ItemNotFoundException();
    }

    public String showStatus() {
        /*
        Status of the player
        loadCapacity: 10 kg
        taken items: sword, 5 kg
        absorbed weight: 5 kg
         */

        StringBuilder response = new StringBuilder();
        response.append("Status of the player\n");
        response.append("loadCapacity: " + this.loadCapacity + "\n");
        response.append("taken items: \n");
        StringBuilder itemString = new StringBuilder();
        for (Item i : this.items) {
            itemString.append("   - " + i.getName() + ", " + i.getWeight() + "kg\n");
        }
        response.append(itemString.toString() + "\n");
        response.append("absorbed weight: " + this.calculateWeight());
        return response.toString();
    }
}
