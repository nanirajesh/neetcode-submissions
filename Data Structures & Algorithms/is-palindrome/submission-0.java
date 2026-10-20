class Solution {
    public boolean isPalindrome(String s) {
   boolean isPalindrome = true;
        s=s.toLowerCase();
        int i=0,j=s.length()-1;
        while(i<=j) {
            //System.out.println( s.charAt(i) + "  " + s.charAt(j));
            while(i<s.length() && !isAlphaNumeric(s.charAt(i)+"")) {
               // System.out.println("i "+s.charAt(i));
                   i++;
            }
         while(j>=0 && !isAlphaNumeric(s.charAt(j)+"")) {
           //  System.out.println("j "+s.charAt(j));
                   j--;
            }
           if(i<=j){ 
            if(s.charAt(i)== s.charAt(j))  {
                i++;
                j--;
           }
           else{
               isPalindrome=false;
               break;
           }
           }
        }
        return isPalindrome;
    }

 public  boolean isAlphaNumeric(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }
}
