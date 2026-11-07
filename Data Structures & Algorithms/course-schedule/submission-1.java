class Solution {
   
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         // Build adjacency list and in-degree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }
        
        // Push all courses with 0 in-degree into the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int completedCourses = 0;
        
        // Process the queue
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            completedCourses++;
            
            // Reduce in-degree for neighboring courses
            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If we were able to complete all courses, there are no cycles
        return completedCourses == numCourses;
    }
}
