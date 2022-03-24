package mar23;

import java.util.Arrays;

public class Solution {
  public static int numBoats(int[] people, int limit) {
    Arrays.sort(people);
    int maxBoats = 0, startIdx = 0, endIdx = people.length - 1;
    while (startIdx <= endIdx) {
      while (startIdx < endIdx && people[startIdx] + people[endIdx] > limit) {
        maxBoats++;
        endIdx--;
      }
      maxBoats++;
      startIdx++;
      endIdx--;
    }
    return maxBoats;
  }

  public static void main(String[] args) {
    int [] people = {3,5,3,4,1,2,14,1,1};
    int limit = 6;

    System.out.println("Maximum number of boats required: " + numBoats(people, limit));
  }
}
