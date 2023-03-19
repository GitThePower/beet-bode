# initialize a neighbor_sum
# check index top left
# check index top middle
# check index top right
# so on ...
# if board[i][j] is 1 and neighbor_sum is 2-3 or board[i][j] is 0 and neighbor_sum is 3
# 	return 1
# otherwise
#	return 0
def evaluate_neighbors(i, j, board, m, n):
  neighbor_sum = 0

  if (i - 1) >= 0 and (j - 1) >= 0:
    neighbor_sum += board[i - 1][j - 1]
  if (i - 1) >= 0:
    neighbor_sum += board[i - 1][j]
  if (i - 1) >= 0 and (j + 1) < n:
    neighbor_sum += board[i - 1][j + 1]

  if (j - 1) >= 0:
    neighbor_sum += board[i][j - 1]
  if (j + 1) < n:
    neighbor_sum += board[i][j + 1]
  
  if (i + 1) < m and (j - 1) >= 0:
    neighbor_sum += board[i + 1][j - 1]
  if (i + 1) < m:
    neighbor_sum += board[i + 1][j]
  if (i + 1) < m and (j + 1) < n:
    neighbor_sum += board[i + 1][j + 1]

  return 1 if neighbor_sum == 3 or (neighbor_sum == 2 and  board[i][j] == 1) else 0


# initialize m to length of board
# initialize n to height of board
# initialize next_state to empty array
# for each cell of the board
# 	get all neighbors
# 	evaluate live or dead
#	push result to next state in same location as board
# return next_state
def get_next_state(board):
  m = len(board)
  n = len(board[0])
  next_state = []

  for i in range(m):
    next_state.append([])
    for j in range(n):
      next_cell_state = evaluate_neighbors(i, j, board, m, n)
      next_state[i].append(next_cell_state)

  return next_state


if __name__ == '__main__':
  board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
  next_state = [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

  assert(get_next_state(board) == next_state)
  print('Success!')
