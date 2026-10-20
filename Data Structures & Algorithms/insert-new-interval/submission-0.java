class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i=0;
        while(i<intervals.length&& newInterval[0] > intervals[i][1]) {
            result.add(new int[]{intervals[i][0] , intervals[i][1]});
            i++;
        }

        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
             newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
             i++;
        }
        result.add(new int[]{newInterval[0],newInterval[1]});


        while(i<intervals.length){
            result.add(new int[]{intervals[i][0] , intervals[i][1]});
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
