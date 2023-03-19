package apr01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Solution {

  private GraphNode graph;

  public Solution (String[] options) {
    // initialize a graph root containing all the options as results
    // recurse in function to populate edges
    this.graph = new GraphNode(options);
    populateGraphEdges(this.graph, 0);
  }

  private void populateGraphEdges (GraphNode currNode, int depth) {
    if (currNode.results.size() > 0) {
      // initialize a hashmap
      // for each result in results
      //    if length of result is greater than depth
      //      if a node is keyed to the character result has at depth
      //        add it to the results array on the node
      //      otherwise
      //        initialize a node, add result to its results and key that to the hashmap
      // for edges on the hashmap
      //    recurse on the given node with incremented depth
      // set currNode edges to hashmap
      HashMap<Character, GraphNode> edges = new HashMap<>();
      for (String result : currNode.results) {
        if (result.length() > depth) {
          char edgeKey = result.charAt(depth);
          if (edges.containsKey(edgeKey)) {
            edges.get(edgeKey).results.add(result);
          } else {
            String[] newEdgeResults = { result };
            GraphNode newEdge = new GraphNode(newEdgeResults);
            edges.put(edgeKey, newEdge);
          }
        }
      }
      for (GraphNode node : edges.values()) {
        populateGraphEdges(node, depth + 1);
      }
      currNode.edges = edges;
    }
  }

  private String[] queryOptions(String query) {
    // initialize a graph pointer to root node
    // for characters in query
    //  if the character is in the current nodes edges
    //    set the current node to the edge node
    //  otherwise
    //    return an empty list
    // return the result list of the current node
    GraphNode curr = this.graph;
    for (char letter : query.toCharArray()) {
      if (curr.edges != null && curr.edges.containsKey(letter)) {
        curr = curr.edges.get(letter);
      } else {
        String[] notFound = {};
        return notFound;
      }
    }

    return curr.results.toArray(new String[0]);
  }

  private class GraphNode {
    List<String> results;
    HashMap<Character, GraphNode> edges;

    GraphNode (String[] results) {
      this.results = new ArrayList<String>(Arrays.asList(results));
    }
  }
  
  public static void main(String[] args) {
    String[] options = {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven",
                        "twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen",
                        "twenty","twentyone","twentytwo","twentythree","twentyfour","twentyfive","twentysix",
                        "twentyseven","twentyeight","twentynine","thirty"};
    String s = "e";

    Solution solve = new Solution(options);
    String[] queryResult = solve.queryOptions(s);
    System.out.println("Results of querying for \"" + s + "\": " + Arrays.toString(queryResult));
  }
}
