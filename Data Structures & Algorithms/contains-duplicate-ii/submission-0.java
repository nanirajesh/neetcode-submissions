
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;

        for (int i = 0; i < nums.length; i++) {

            // Remove elements outside the allowed window
            if (i - start > k) {
                int count = map.get(nums[start]);

                if (count == 1) {
                    map.remove(nums[start]);
                } else {
                    map.put(nums[start], count - 1);
                }

                start++;
            }

            // Check whether the current element already exists
            if (map.containsKey(nums[i])) {
                return true;
            }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return false;
    }
}
