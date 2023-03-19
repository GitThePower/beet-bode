def maxBoats(people, limit):
  people.sort()
  maxBoats = 0
  startIdx = 0
  endIdx = len(people) - 1
  while startIdx <= endIdx:
    while startIdx < endIdx and people[startIdx] + people[endIdx] > limit:
      maxBoats += 1
      endIdx -= 1
    maxBoats += 1
    startIdx += 1
    endIdx -= 1

  return maxBoats


if __name__ == '__main__':
  people = [3,5,3,4,1,2,14,1,1]
  limit = 6

  print('Max number of boats required to carry people: ' + str(maxBoats(people, limit)))
