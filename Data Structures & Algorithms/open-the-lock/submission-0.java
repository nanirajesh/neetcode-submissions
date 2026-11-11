
class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>();
        for (String d : deadends) {
            dead.add(d);
        }

        if (dead.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int result = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String current = queue.poll();

                if (current.equals(target)) {
                    return result;
                }

                char[] carr = current.toCharArray();

                for (int i = 0; i < 4; i++) {

                    char original = carr[i];

                    // Rotate up
                    carr[i] = (char) ('0' + (original - '0' + 1) % 10);
                    String next = new String(carr);

                    if (!dead.contains(next) && visited.add(next)) {
                        queue.offer(next);
                    }

                    // Rotate down
                    carr[i] = (char) ('0' + (original - '0' + 9) % 10);
                    next = new String(carr);

                    if (!dead.contains(next) && visited.add(next)) {
                        queue.offer(next);
                    }

                    // Restore original digit
                    carr[i] = original;
                }
            }

            result++;
        }

        return -1;
    }
}
