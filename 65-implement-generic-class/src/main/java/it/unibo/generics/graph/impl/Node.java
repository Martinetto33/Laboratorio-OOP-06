package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.Colour;

public class Node<N> {
    private final int id;
    private final N data;
    private Colour colour;
    private double distance;
    private Node<N> parent;

    public Node(N data, int id) {
        this.id = id;
        this.data = data;
        this.distance = Double.POSITIVE_INFINITY;
        this.colour = Colour.WHITE;
        this.parent = null;
    }

    public int getId() {
        return this.id;
    }

    public N getData() {
        return this.data;
    }

    public Colour getColour() {
        return this.colour;
    }

    public double getDistance() {
        return this.distance;
    }

    public Node<N> getParent() {
        return this.parent;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void setParent(Node<N> parent) {
        this.parent = parent;
    }

    public String toString() {
        return "Name of the node: " + this.data + ", id: " + this.id;
    }
}
