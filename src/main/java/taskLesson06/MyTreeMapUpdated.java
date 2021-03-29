package taskLesson06;

import taskLesson06.codeLesson06.MyTreeMap;

import java.util.NoSuchElementException;

public class MyTreeMapUpdated<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;

        int height;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;

            height = 0;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null || node.left == null && node.right == null) {
            return 0;
        }
        return node.height;
    }

    public int isBalanced() {
        if (root.left == null && root.right == null) {
            return 1;
        }
        return isBalanced(root);
    }

//    private int isBalanced(Node node) {
//
//        if (node.left != null && node.right == null) {
//
//            int currentLeft = isBalanced(node.left);
//            if (currentLeft == 0) {
//                return 0;
//            }
//        }
//
//        if (node.left == null && node.right != null) {
//
//            int currentRight = isBalanced(node.right);
//            if (currentRight == 0) {
//                return 0;
//            }
//        }
//
//        if (node.left != null && node.right != null) {
//            int calculator = Math.abs(node.left.height - node.right.height);
//            if (calculator > 1) {
//                return 0;
//            }
//        }
//
//        if (node.left == null && node.right == null) {
//            return 1;
//        }
//
//        return 1;
//    }

    private int isBalanced(Node node) {


        if (node.left != null && node.right == null) {
           return isBalanced(node.left);
        }
        if (node.left == null && node.right != null) {
            return isBalanced(node.right);
        }
        if(node.left == null && node.right == null) {
            return 0;
        }

        int calculator = Math.abs(node.left.height - node.right.height);
        if (calculator > 1) {
            return 0;
        } else {
            return 1;
        }
    }


    public boolean isEmpty() {
        return root == null;
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key не должен быть null");
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        checkKeyNotNull(key);
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        if (value == null) {
            //remove(key)
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;

        node.height = height(node.left) + height(node.right) + 1;

        return node;
    }

    public Key minKey() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Key maxKey() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;

        node.height = height(node.left) + height(node.right) + 1;

        return node;
    }

    public void delele(Key key) {
        checkKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;

        node.height = height(node.left) + height(node.right) + 1;

        return node;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " +
                node.key + " = " + node.value + " " +
                toString(node.right);
    }

}
