class Solution {
    public int maxProfit(int[] prices) {
        int start=Integer.MAX_VALUE;
        int max=0;
        for(int price:prices){
            if(start > price){
                start=price;
            }
            max= Math.max(max, price-start);
        }
        return max;
    }
}
