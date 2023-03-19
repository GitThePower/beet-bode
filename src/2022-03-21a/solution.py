def getSmallestLexString(n, k):
  smallest = ''
  while k > 0:
    largestLexChar = k - (n - 1)
    if (largestLexChar >= 26):
      smallest = 'z' + smallest
      k -= 26
    else:
      smallest = chr(ord('a') + largestLexChar - 1) + smallest
      k -= largestLexChar
    n -= 1
  return smallest


if __name__ == '__main__':
  n = 5
  k = 73
  print('Lexicographically smallest string: ' + str(getSmallestLexString(n, k)))
