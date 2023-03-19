const getSmallestLexString = (n, k) => {
  let smallest = '';
  while (k > 0) {
    let largestLex = k - (n - 1);
    if (largestLex >= 26) {
      smallest = 'z' + smallest;
      k -= 26;
    } else {
      smallest = String.fromCharCode('a'.charCodeAt(0) + largestLex - 1) + smallest;
      k -= largestLex;
    }
    n--;
  }
  return smallest
};

const n = 5;
const k = 73;
console.log('Lexicographically smallest string:', getSmallestLexString(n, k));
