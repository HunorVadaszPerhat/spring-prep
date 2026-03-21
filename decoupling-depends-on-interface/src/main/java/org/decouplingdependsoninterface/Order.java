package org.decouplingdependsoninterface;

/**
 * A simple domain object representing an order.
 */
public class Order {
    private String id;
    private String description;

    // Constructors, Getters, Setters
    public Order() {}

    public Order(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() { return id; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", description='" + description + '\'' + '}';
    }
}