package datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static datastructures.tree.Helper.getTestTree;

// left -> right -> root
public class PostOrderTraversal {

    static List<Integer> postOrderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postOrderRecursive(root.left));
        result.addAll(postOrderRecursive(root.right));
        result.add(root.value);
        return result;
    }

    static List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> recusionStack = new Stack<>();
        Stack<Integer> invertedResultStack = new Stack<>();
        if (root == null) {
            return result;
        }
        recusionStack.push(root);
        while (!recusionStack.isEmpty()) {
            TreeNode node = recusionStack.pop();
            invertedResultStack.push(node.value);

            if (node.left != null) {
                recusionStack.push(node.left);
            }

            if (node.right != null) {
                recusionStack.push(node.right);
            }

        }
        while (!invertedResultStack.isEmpty()) {
            result.add(invertedResultStack.pop());
        }
        return result;
    }

    static void main() {
        TreeNode root = getTestTree();
        List<Integer> postedOrderRecursiveResult = postOrderRecursive(root);
        System.out.println("postedOrderRecursiveResult = " + postedOrderRecursiveResult);
        List<Integer> postedOrderIterativeResult = postOrderIterative(root);
        System.out.println("postedOrderIterativeResult = " + postedOrderIterativeResult);
    }
}
