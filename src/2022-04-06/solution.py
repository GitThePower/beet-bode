def get_loop_start_index_n2(gas, cost):
  for i in range(len(gas)):
    car = gas[i]
    curr_idx = (i + 1) % len(cost)
    while car > 0:
      if curr_idx == i:
          return i + 1
      car -= cost[curr_idx]
      if car > 0:
        car += gas[curr_idx]
        curr_idx = (curr_idx + 1) % len(cost)
  
  return -1


def get_loop_start_index_n(gas, cost):
  gas_idxes = [0,0]
  gas_idx_pointer = 0
  idx_steps = 0
  gas_required = 0

  while idx_steps < len(gas):
    gas_required += cost[(gas_idxes[gas_idx_pointer] + 1) % len(cost)]
    
    gas_required -= gas[gas_idxes[gas_idx_pointer]]
    if gas_required > 0:
      gas_idx_pointer = 1
      gas_idxes[gas_idx_pointer] = (gas_idxes[gas_idx_pointer] - 1) % len(gas)
    else:
      gas_idx_pointer = 0
      gas_idxes[gas_idx_pointer] = (gas_idxes[gas_idx_pointer] + 1) % len(gas)
    idx_steps += 1
  
  return gas_idxes[gas_idx_pointer] + 1 if gas_required <= 0 else -1


if __name__ == '__main__':
  gas = [1,2,3,4,5]
  cost = [3,4,5,1,2]

  assert(get_loop_start_index_n(gas, cost) == 3)

  gas = [2,3,4]
  cost = [3,4,3]

  assert(get_loop_start_index_n(gas, cost) == -1)
  print('Success!')
