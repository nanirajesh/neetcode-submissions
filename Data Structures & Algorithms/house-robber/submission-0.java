class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        //base conditions 
        if(n==1)
            return nums[0];
        arr[0] = nums[0];
        arr[1] = Math.max(nums[1],nums[0]);
        // [2,1]
        // arr = 1,2,4,4
        for(int i=2;i<n;i++){
            arr[i] = Math.max(nums[i]+arr[i-2],arr[i-1]);
        }
        
        return arr[n-1];
    }
}


// [1,2,3,4,100,6]. 
// max = arr[0]

// arr[0] = Math.Max(arr[0],arr[0])

// arr[1] = Math.max(arr[1],arr[0]);

// arr[2] = Math.max(arr[2]+arr[0], max);

// arr[3] = Math.max(arr[3]+arr[1],max);


// arr[i] = Math.max(arr[i]+arr[i-2],max);


// arr[ith]

