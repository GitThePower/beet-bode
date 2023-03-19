def getZigZag(line, numRows):
  zigZag = ''
  for i in range(numRows):
    incr = 0
    comp = (2 * incr) * (numRows - 1)
    while comp < len(line):
      if i != 0 and i != numRows -1 and comp - i > 0:
        zigZag += line[comp - i]
      if comp + i < len(line):
        zigZag += line[comp + i]
      incr += 1
      comp = (2 * incr) * (numRows - 1)
  return zigZag


if __name__ == '__main__':
  line = 'PAYPALISHIRING'
  numRows = 4

  print('Conversion of ' + line + ' to zigzag in ' + str(numRows) + ' rows is: ' + getZigZag(line, numRows))
