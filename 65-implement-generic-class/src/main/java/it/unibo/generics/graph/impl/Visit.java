package it.unibo.generics.graph.impl;

public class Visit<N> {
    private Node<N> node;
    private int beginningTime;
    private int finishTime;

    public Visit(Node<N> node) {
        this.node = node;
        this.beginningTime = 0;
        this.finishTime = 0;
    }

    public Node<N> getNode() {
        return this.node;
    }

    public void setNode(Node<N> node) {
        this.node = node;
    }

    public int getBeginningTime() {
        return this.beginningTime;
    }

    public void setBeginningTime(int beginningTime) {
        this.beginningTime = beginningTime;
    }

    public int getFinishTime() {
        return this.finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public String toString() {
        return "Visit to node "
        + this.node.getData()
        + ", beginning time: "
        + this.beginningTime
        + ", finish time: "
        + this.finishTime;
    }     
}
