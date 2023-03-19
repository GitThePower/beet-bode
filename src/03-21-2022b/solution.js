const getZigZag = (line, numRows) => {
  let zigZag = '';
  for (let i = 0; i < numRows; i++) {
    let incr = 0;
    let comp = (2 * incr) * (numRows - 1);
    while (comp < line.length) {
      if (i != 0 && i != numRows - 1 && comp - i > 0) {
        zigZag += line[comp - i];
      }
      if (comp + i < line.length) {
        zigZag += line[comp + i];
      }
      comp = (2 * ++incr) * (numRows - 1);
    }
  }
  return zigZag;
};

line = 'PAYPALISHIRING';
numRows = 4;
console.log(`Conversion of ${line} to zigzag in ${numRows} rows is: ${getZigZag(line, numRows)}`);