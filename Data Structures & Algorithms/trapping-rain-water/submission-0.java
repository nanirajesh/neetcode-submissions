class Solution {
    public int trap(int[] height) {
        if(height.length==0)return 0;
        int[] GL=new int[height.length];
        int[] GR=new int[height.length];
        int maxLeft=0,maxRight=0,total=0;
        for(int i=0;i<GL.length;i++){
            if(i==0){
                GL[i]=height[i];
                maxLeft=GL[i];
            }else{
                maxLeft=Math.max(height[i],maxLeft);
                GL[i]=maxLeft;
            }
        }
        
        for(int i=GR.length-1;i>=0;i--){
            if(i==GR.length-1){
                GR[i]=height[i];
                maxRight=GR[i];
            }else{
                maxRight=Math.max(height[i],maxRight);
                GR[i]=maxRight;
            }
        }
        
        for(int i=0;i<GL.length;i++){
            total+=Math.min(GL[i],GR[i])-height[i];
        }
        return total;
    }
}