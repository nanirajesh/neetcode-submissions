
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        util(s, 0, result, temp);

        return result;
    }

    private void util(String s, int index,
                      List<List<String>> result,
                      List<String> temp) {

        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String left = s.substring(index, i + 1);

            if (isPalindrome(left)) {
                temp.add(left);

                util(s, i + 1, result, temp);

                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
