class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int end = max(piles);
        int start = 1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            int total = getTotalHr(piles,mid);
            if(total <= h){
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }

    private int max(int[] piles){
        int max= piles[0];
        for(int i:piles){
            max = Math.max(max,i);
        }
        return max;
    }

    private int getTotalHr(int[] piles,int pace ){
        int hours =0;
        for(int pile : piles){
            hours += Math.ceil((double)pile/(double)pace);
        }
       return hours;
    }
}
