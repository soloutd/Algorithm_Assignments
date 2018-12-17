package Week_Three;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch {

    static ArrayList<Node> nodes = new ArrayList<>();

    static class Node {
        String  data;
        boolean visited;

        Node(String data) {
            this.data = data;

        }
    }

    // find neighbors of node using adjacency matrix
    // if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
    public ArrayList<Node> findNeighbours(int adjacency_matrix[][], Node x) {
        int nodeIndex = -1;

        ArrayList<Node> neighbours = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).equals(x)) {
                nodeIndex = i;
                break;
            }
        }

        if (nodeIndex != -1) {
            for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
                if (adjacency_matrix[nodeIndex][j] == 1) {
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }


    // Recursive DFS
    public void dfs(int adjacency_matrix[][], Node node) {

        System.out.print(node.data + " ");
        ArrayList<Node> neighbours = findNeighbours(adjacency_matrix, node);
        node.visited = true;
        for (int i = 0; i < neighbours.size(); i++) {
            Node n = neighbours.get(i);
            if (n != null && !n.visited) {
                dfs(adjacency_matrix, n);
            }
        }
    }

    // Iterative DFS using stack
    public void dfsUsingStack(int adjacency_matrix[][], Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        node.visited = true;
        while (!stack.isEmpty()) {
            Node element = stack.pop();
            System.out.print(element.data + " ");

            ArrayList<Node> neighbours = findNeighbours(adjacency_matrix, element);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    stack.add(n);
                    n.visited = true;

                }
            }
        }
    }

    public static void main(String arg[]) {

        Node node40 = new Node("A");
        Node node10 = new Node("B");
        Node node20 = new Node("C");
        Node node30 = new Node("D");
        Node node60 = new Node("E");
        Node node50 = new Node("F");
        Node node70 = new Node("G");
        Node node80 = new Node("H");
        Node node90 = new Node("I");

        nodes.add(node40);
        nodes.add(node10);
        nodes.add(node20);
        nodes.add(node30);
        nodes.add(node60);
        nodes.add(node50);
        nodes.add(node70);
        nodes.add(node80);
        nodes.add(node90);
        int adjacency_matrix[][] = {
                {0, 1, 1, 0, 0, 1, 0,0,0},  // Node 1: 40
                {1, 0, 0, 0, 0, 1, 0,0,0},  // Node 2 :10
                {1, 0, 0, 0, 0, 0, 1,0,0},  // Node 3: 20
                {0, 0, 0, 0, 1, 0, 0,0,1},  // Node 4: 30
                {0, 0, 0, 1, 0, 0, 0,0,1},  // Node 5: 60
                {1, 1, 1, 0, 0, 0, 1,1,0},  // Node 6: 50
                {0, 0, 1, 0, 0, 0, 0,1,0},  // Node 7: 70
                {0, 0, 0, 0, 0, 1, 1,0,0},  // Node 7: 80
                {0, 0, 0, 1, 1, 0, 0,0,0},  // Node 7: 90
        };

        DepthFirstSearch dfsExample = new DepthFirstSearch();

        System.out.println("The DFS traversal of the graph using stack ");
        dfsExample.dfsUsingStack(adjacency_matrix, node60);

        System.out.println();

        clearVisitedFlags();

        System.out.println("The DFS traversal of the graph using recursion ");
        dfsExample.dfs(adjacency_matrix, node40);

    }

    public static void clearVisitedFlags() {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).visited = false;
        }
    }
}