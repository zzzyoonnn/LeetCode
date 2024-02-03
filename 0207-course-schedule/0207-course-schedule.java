class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        
        // Construct the adjacency list and calculate indegrees
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            
            adjList.get(prerequisiteCourse).add(course);
            indegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            visited.add(course);
            
            for (int neighbor : adjList.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return visited.size() == numCourses;
    }
}