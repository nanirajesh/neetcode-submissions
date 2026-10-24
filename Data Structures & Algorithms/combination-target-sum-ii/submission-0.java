
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        util(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    private void util(
        int[] candidates,
        int index,
        int target,
        List<Integer> temp,
        List<List<Integer>> result
    ) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Array is sorted, so later values will also be too large
            if (candidates[i] > target) {
                break;
            }

            temp.add(candidates[i]);

            // i + 1 ensures each array element is used at most once
            util(candidates, i + 1, target - candidates[i], temp, result);

            // Backtrack
            temp.remove(temp.size() - 1);
        }
    }
}
