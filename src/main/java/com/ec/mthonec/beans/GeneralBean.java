/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.mthonec.beans;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.util.LangUtils;

/**
 *
 * @author esteb
 */
@ViewScoped
@Named
public class GeneralBean implements Serializable {

    private TreeNode root;

    @PostConstruct
    public void init() {
        root = new DefaultTreeNode("Files", null);
        TreeNode node0 = new DefaultTreeNode("Employee", root);
        TreeNode node1 = new DefaultTreeNode("Department", root);
        TreeNode node2 = new DefaultTreeNode("Enterprise", root);

        TreeNode node00 = new DefaultTreeNode("Add Employee", node0);
        TreeNode node01 = new DefaultTreeNode("List Employees", node0);

        TreeNode node10 = new DefaultTreeNode("Add Department", node1);
        TreeNode node11 = new DefaultTreeNode("List Departmen", node1);

        TreeNode node20 = new DefaultTreeNode("Add Enterprise", node2);
        TreeNode node21 = new DefaultTreeNode("List Enterprise", node2);

    }

    public TreeNode getRoot() {
        return root;
    }

}
