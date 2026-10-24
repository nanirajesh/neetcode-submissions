class Solution {
    public int findMin(int[] nums) {
        if(nums[0]<=nums[nums.length-1]) return nums[0];

        int start=0,end=nums.length-1;
          while (start < end) {
            int pivot = start + (end - start) / 2;

            if (nums[pivot] > nums[end]) {
                // Minimum is in the right half
                start = pivot + 1;
            } else {
                // Minimum is at pivot or in the left half
                end = pivot;
            }
        }

        return nums[start];
    }
}
