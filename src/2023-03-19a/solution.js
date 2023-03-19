class WordDictionary {
  dictionary = {};

  addWord = (inputWord) => {
    let dictPointer = this.dictionary;
    inputWord.split('').map(letter => {
      if (Object.keys(dictPointer).length <= 0 || !Object.keys(dictPointer).includes(letter)) {
        dictPointer[letter] = {};
      }
      dictPointer = dictPointer[letter];
    });
  };

  searchHelper = (word, dictPointer) => {
    if (word === '') {
      if (Object.keys(dictPointer).length < 1) return true;
      else return false;
    } else if (word[0] === '.') {
      return Object.values(dictPointer).reduce((endResult, val) => {
        if (!endResult && this.searchHelper(word.slice(1), val)) {
          endResult = true;
        };
        return endResult;
      }, false);
    } else if (Object.keys(dictPointer).includes(word[0])) {
      return this.searchHelper(word.slice(1), dictPointer[word[0]]);
    }
    return false;
  };

  search = (searchWord) => {
    return this.searchHelper(searchWord, this.dictionary);
  };
};

const wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
console.log(`Expected: false, Actual: ${wordDictionary.search("pad")}`);
console.log(`Expected: true, Actual: ${wordDictionary.search("bad")}`);
console.log(`Expected: true, Actual: ${wordDictionary.search(".ad")}`);
console.log(`Expected: true, Actual: ${wordDictionary.search("b..")}`);
console.log(`Expected: false, Actual: ${wordDictionary.search("b.m")}`);
console.log(`Expected: false, Actual: ${wordDictionary.search("b.")}`);
console.log(`Expected: false, Actual: ${wordDictionary.search("b...")}`);

