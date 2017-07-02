/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv;

import java.util.Arrays;

/**
 *
 * @author zeman
 */
public class TreeImpl implements Tree {

    private NodeImpl root;

    public TreeImpl() {
    }

    /**
     * funkce ktera vytvori strom
     *
     * @param values
     * @return
     *
     */

    private NodeImpl funkce(int[] values) {
        int rootIndex = 0;
        if ((values.length % 2) == 0) {
            rootIndex = (values.length / 2);
        } else {
            rootIndex = ((values.length + 1) / 2) - 1;
        }
        NodeImpl node = null; //usnadnuje praci abych nemusel vracet po kazdem ifu
        if (values.length >= 3) {
            int[] levePole = Arrays.copyOfRange(values, 0, rootIndex);
            int[] pravePole = Arrays.copyOfRange(values, rootIndex + 1, values.length);

            node = new NodeImpl(funkce(levePole), funkce(pravePole), values[rootIndex]); // zde se vytvari strom 

        } else if (values.length == 2) {

            int[] levePole = Arrays.copyOfRange(values, 0, rootIndex);

            node = new NodeImpl(funkce(levePole), null, values[rootIndex]);

        } else {
            node = new NodeImpl(null, null, values[rootIndex]);
        }

        return node;
    }

    @Override
    public void setTree(int[] values) {
        if (values == null) {
            root = null;

        } else if (values.length == 0) {
            root = null;

        } else {
            root = funkce(values);
        }

    }

    @Override
    public Node getRoot() {
        return root;
    }

    private String funkce2(Node uzel, int counter) {
        String var = "";
        for (int i = 0; i < counter; i++) {
            var += " ";
        }

        var += "- " + uzel.getValue() + "\n";
        if (uzel.getLeft() != null) {
            var += funkce2(uzel.getLeft(), counter + 1);
        }
        if (uzel.getRight() != null) {
            var += funkce2(uzel.getRight(), counter + 1);
        }

        return var;

    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        } else {
            return funkce2(root, 0);
        }

    }

}
