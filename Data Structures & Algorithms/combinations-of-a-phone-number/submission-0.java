class Solution {
    Map<Character, String> dig = Map.of('2',"abc",
    '3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",
    '9',"wxyz");
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        util(digits,0,result,"");
        return result;
    }

    void util(String digits,int index , List<String> result , String temp)   {
        if(index == digits.length()) {
            result.add(temp);
            return ;
        }
        String currentSub = dig.get(digits.charAt(index));
        for(int j=0;j<currentSub.length();j++) {
                util(digits,index+1,result,temp+((char)currentSub.charAt(j)+""));
            }
    }
}