package mar21b;

public class Solution {

  private static String convertZigZag(String s, int numRows) {
    String zigzag = "";
    for (int i = 0; i < numRows; i ++) {
      int incr = 0, cond = 0;
      while (cond - i < s.length()) {
        if (i != 0 && i != numRows - 1 && cond - i > 0) {
          zigzag = zigzag + s.charAt(cond - i);
        }
        if (cond + i < s.length()) {
          zigzag = zigzag + s.charAt(cond + i);
        }
        cond = (2 * (++incr)) * (numRows - 1);
      }
    }
    return zigzag;
  }

  public static void main(String[] args) {
    String s = "PAYPALISHIRING";
    int numRows = 3;

    System.out.println("Zig Zag conversion of " + s + " in " + numRows + " rows is: " + convertZigZag(s, numRows));
  }
}
