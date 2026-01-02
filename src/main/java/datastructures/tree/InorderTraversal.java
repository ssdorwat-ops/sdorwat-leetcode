package datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static datastructures.tree.Helper.getTestTree;

// left -> root -> right
public class InorderTraversal {

    static List<Integer> inorderRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(inorderRecursive(root.left));
        result.add(root.value);
        result.addAll(inorderRecursive(root.right));
        return result;
    }


    static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.value);
            node = node.right;
        }
        return result;
    }

    static void main() {
        TreeNode root = getTestTree();
        List<Integer> inorderRecursiveResult = inorderRecursive(root);
        System.out.println("inorderRecursiveResult = " + inorderRecursiveResult);
        List<Integer> inorderIterativeResult = inorderIterative(root);
        System.out.println("inorderIterativeResult = " + inorderIterativeResult);
    }

}
