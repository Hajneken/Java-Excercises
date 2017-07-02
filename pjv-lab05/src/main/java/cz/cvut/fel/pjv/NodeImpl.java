/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv;

/**
 *
 * @author zeman
 */
public class NodeImpl implements Node {

    private NodeImpl left;
    private NodeImpl right;
    private int value;


    public NodeImpl(NodeImpl left, NodeImpl right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getRight() {
        return right;
    }

    @Override
    public int getValue() {
        return value;
    }

}
