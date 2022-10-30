package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
    private int numberOfNodes;
    private int numberOfEdges;
    private Map<Integer, Set<Edge<N>>> allEdges;
    private Set<Node<N>> allNodes;

    

    public GraphImpl() {
        this.numberOfNodes = 0;
        this.numberOfEdges = 0;
        this.allEdges = new HashMap<>();
        this.allNodes = new HashSet<>();
    }

    private int getKey (N node) {
        int keyValue = -1;
            for (Node<N> elem : this.allNodes) {
                if (elem.getData().equals(node)) {
                    keyValue = elem.getId();
                    break;
                }
            }
        assert(keyValue != -1);
        return keyValue;
    }

    private void findRoom (Edge<N> edgeToBeAdded, int key) {
        boolean setAlreadyExists = false;
        boolean wasElementAdded = false;
        for (Integer elem : this.allEdges.keySet()) {
            if (elem.equals(key)) {
                setAlreadyExists = true;
                break;
            }
        }
        if (setAlreadyExists) {
            wasElementAdded = this.allEdges.get(key).add(edgeToBeAdded);
        }
        else {
            this.allEdges.put(this.numberOfEdges, new HashSet<>());
            wasElementAdded = this.allEdges.get(this.numberOfEdges).add(edgeToBeAdded);
        }
        if (wasElementAdded) {
            this.numberOfEdges++;
            System.out.println("Edge added successfully!");
        }
        else {
            System.out.println("Something went wrong while trying to add an edge.");
        }
    }

    @Override
    public void addNode(N node) {
        if (node == null) {
            System.out.println("Incorrect attempt of adding null node.");
            return;
        }
        Node<N> nodeToBeAdded = new Node<>(node, this.numberOfNodes);
        if (this.allNodes.add(nodeToBeAdded) == true) {
            System.out.println("Node correctly added!");
            this.numberOfNodes = allNodes.size();
        }
        else {
            System.out.println("Node was already present, so nothing happened.");
        }
    }

    @Override
    public void addEdge(N source, N target) {
        if(source == null || target == null || source == target) {
            System.out.println("This edge won't be added.");
            return;
        }
        /*I have to check if nodes with data corresponding to the generic N types of
         * source and target actually exist.
         */
        if (this.nodeSet().contains(source) && this.nodeSet().contains(target)) {
            Edge<N> edgeToBeAdded = new Edge<>(source, target, this.numberOfEdges);
            this.findRoom(edgeToBeAdded, this.getKey(source));
        }
    }

    @Override
    public Set<N> nodeSet() {
        Set<N> defCopy = new HashSet<>();
        for(Node<N> elem : this.allNodes) {
            defCopy.add(elem.getData());
        }
        return defCopy;
    }

    @Override
    public Set<N> linkedNodes(N node) {
        if (this.nodeSet().contains(node)) {
            int keyValue = getKey(node);
            Set<N> adjacentCopy = new HashSet<>();
            for (Edge<N> elem : this.allEdges.get(keyValue)) {
                adjacentCopy.add(elem.getTarget());
            }
            return adjacentCopy;
        }
        return null;
    }

    @Override
    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        return null;
    }

}