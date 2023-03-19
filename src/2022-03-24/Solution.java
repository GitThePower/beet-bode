package mar24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  private class Node {
    int id, groupId;
    Map<Integer, Boolean> group;

    public Node(int id) {
      this.id = id;
      this.groupId = id;
      this.group = new HashMap<>();
    }
  }

  public int getNumGroups(String[] related) {
  // Instantiate List of Nodes
    List<Node> nodeList = new ArrayList<>();
  // Iterate over list of relations:
    for (int i = 0; i < related.length; i++) {
  //  construct a node for the relation
      String relation = related[i];
      Node relationNode = new Node(i);
  //  iterate over the relation string adding members to the node's group
      for (int j = 0; j < relation.length(); j++) {
        if (relation.charAt(j) == '1') {
          relationNode.group.put(j, true);
        }
      }
  //  iterate over list of nodes:
      for (Node node : nodeList) {
  //    if either id is in either node's group, then:
        if (node.group.containsKey(relationNode.id) || relationNode.group.containsKey(node.id)) {
  //      set group ids to lowest value groupId
          if (node.groupId < relationNode.groupId) {
            relationNode.groupId = node.groupId;
          } else {
            node.groupId = relationNode.groupId;
          }
  //      intersect the groups for both nodes
          Map<Integer, Boolean> combinedGroup = new HashMap<>();
          combinedGroup.putAll(node.group);
          combinedGroup.putAll(relationNode.group);
          node.group = combinedGroup;
          relationNode.group = combinedGroup;
        }
      }
  //  add the node to the node list
      nodeList.add(relationNode);
    }
  // Return number of distinct groupIds from list of nodes
    int numGroups = 0;
    for (Node node : nodeList) {
      if (node.groupId > numGroups) {
        numGroups = node.groupId;
      }
    }
    return numGroups;
  }

  public static void main(String[] args) {
    String[] related = {"110", "110", "001"};
    Solution solve = new Solution();

    System.out.println("Number of groups among relations: " + solve.getNumGroups(related));
  }
}
