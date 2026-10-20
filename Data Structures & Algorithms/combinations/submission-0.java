class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        util(n,k,1,result,new ArrayList<Integer>());
        return result;
    }

    private void util(int n,int k , int index,List<List<Integer>> result, List<Integer> temp) {
        if(temp.size()==k){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=index;i<=n;i++){
            temp.add(i);
            util(n,k,i+1,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}