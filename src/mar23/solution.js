const maxBoats = (people, limit) => {
  people.sort((a, b) => a - b);
  let maxBoats = 0;
  let startIdx = 0;
  let endIdx = people.length - 1;
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
};

const people = [3,5,3,4,1,2,14,1,1];
const limit = 6;
console.log("Max number of boats required to carry people:", maxBoats(people, limit));
