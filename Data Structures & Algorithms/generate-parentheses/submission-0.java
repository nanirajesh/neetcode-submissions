class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        util(n,0,0,result,"");
        return result;
    }
    private void util(int n,int open,int closed,List<String> result,String temp){

        if(temp.length() == 2*n){
            result.add(temp);
            return;
        }
        if(open<closed) return;
        if(open>= closed && open<n){
            util(n,open+1,closed,result,temp+"(");
        }
        if(closed<open){
            util(n,open,closed+1,result,temp+")");
        }
    }
}
