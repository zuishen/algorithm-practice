    private static void mergeSort(int start, int end, int[] nums) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(start, mid, nums);
        mergeSort(mid + 1, end, nums);
        // merge
        int[] tmp = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int i = 0;
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                tmp[i++] = nums[left++];
            } else {
                tmp[i++] = nums[right++];
            }
        }
        while (left <= mid) {
            tmp[i++] = nums[left++];
        }
        while (right <= end) {
            tmp[i++] = nums[right++];
        }
        for (int j = 0; j < i; j++) {
            nums[start + j] = tmp[j];
        }
    }
