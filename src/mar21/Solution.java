package mar21;

public class Solution {

  public static String getSmallestLexString(int n, int k) {
    String smallest = "";
    while (k > 0) {
      int maxLetterLex = k - (n - 1);
      char addition = 'a';
      if (maxLetterLex >= 26) {
        addition = 'z';
        k -= 26;
      } else {
        addition += (maxLetterLex - 1);
        k -= maxLetterLex;
      }
      smallest = addition + smallest;
      n --;
    }
    return smallest;
  }
  
  public static void main(String[] args) {
    int n = 5, k = 73;

    System.out.println("Lexicographically smallest string is: " + getSmallestLexString(n, k));
  }
}
