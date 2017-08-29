    
    private static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSwap = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    isSwap = true;
                }
            }
            if (isSwap == false) return nums;
        }
        return nums;
    }
