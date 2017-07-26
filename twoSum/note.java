1. Two Sum
	int[] ret = new int[2];
	int[] ret = new int[]{0, 0};
	return new int[]{0,0};

	public int[] solutions(int[] nums, int target);

	// Test Case:  when nums == null; nums.length = 0; nums.length = 1; duplicate values?

	Solution1:
		two loops.
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (target - nums[i] == nums[j]) {	// check if the complement exits in array
						return new int[]{i, j}; 	// init value can be constant or variable
					}
				}
			}

	Solution2:  // NEED TO DEAL WITH ELEMENTS THAT HAS DUPLICATE VALUES.
		// reduce the lookup time from O(n) to O(1) by trading space for speed.
	// HashMap make the lookup time to O(1) (using value to find index since it need return the indx)
	// If collision occur, degenerate to O(n)
		using HashMap with one loop:
			Map<Integer, Integer> map = new HashMap<>();
			// for loop to assign value-index to map
			// another loop to check
			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
														// the order 
					return new int[]{i, map.get(target - nums[i])};
				}
			}

