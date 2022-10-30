package it.unibo.generics.graph.impl;

public class Edge<N> {
    private final int id;
    private final N source;
    private final N target;
    private double weight;

    public Edge(N source, N target, double weight, int id) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.id = id;
    }

    public Edge(N source, N target, int id) {
        this(source, target, 0, id);
    }

    public N getSource() {
        return source;
    }

    public N getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getID() {
        return this.id;
    }

    public String toString() {
        return "The edge nr. "
        + this.id
        + " connects node "
        + source
        + " to node "
        + target;
    }
}
