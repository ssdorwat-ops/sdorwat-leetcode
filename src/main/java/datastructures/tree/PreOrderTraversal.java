package datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static datastructures.tree.Helper.getTestTree;

public class PreOrderTraversal {


    // root -> left -> right
    static List<Integer> dfsRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.value);
        result.addAll(dfsRecursive(root.left));
        result.addAll(dfsRecursive(root.right));
        return result;
    }

    static List<Integer> dfsIterative(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    static void main() {
        TreeNode root = getTestTree();
        List<Integer> preorderResultRecursive = dfsRecursive(root);
        System.out.println("preorderResultRecursive = " + preorderResultRecursive);

        List<Integer> preorderIterativeResult = dfsIterative(root);
        System.out.println("preorderIterativeResult = " + preorderIterativeResult);
    }
}
