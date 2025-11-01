public class Day106 {
    
}
Course Schedule II
Difficulty: MediumAccuracy: 51.77%Submissions: 86K+Points: 4Average Time: 25m
You are given n courses, labeled from 0 to n - 1 and a 2d array prerequisites[][] where prerequisites[i] = [x, y] indicates that we need to take course  y first if we want to take course x.

Find the ordering of courses we should take to complete all the courses.

Note: There may be multiple correct orders, you just need to return any one of them. If it is impossible to finish all tasks, return an empty array. The Driver code will print true if you return any correct order of courses else it will print false. 

Examples:

Input: n = 3, prerequisites[][] = [[1, 0], [2, 1]]
Output: true
Explanation: To take course 1, you must finish course 0. To take course 2, you must finish course 1. So the only valid order is [0, 1, 2].
Input: n = 4, prerequisites[][] = [[2, 0], [2, 1], [3, 2]]
Output: true
Explanation: Course 2 requires both 0 and 1. Course 3 requires course 2. Hence, both [0, 1, 2, 3] and [1, 0, 2, 3] are valid.
Constraints:
1 ≤ n ≤ 104
0 ≤ prerequisites.size() ≤ 105
0 ≤ prerequisites[i][0], prerequisites[i][1] < n
All prerequisite pairs are unique
prerequisites[i][0] ≠ prerequisites[i][1]

class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] a) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] i:a)
        {
            adj.get(i[1]).add(i[0]);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int[] ind=new int[n];
        Arrays.fill(ind,0);
        for(int i=0;i<n;i++)
        {
            int s=adj.get(i).size();
            for(int j=0;j<s;j++)
            {
                ind[adj.get(i).get(j)]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(ind[i]==0)
                q.add(i);
        }
        while(!q.isEmpty())
        {
            int x=q.poll();
            ans.add(x);
            int s=adj.get(x).size();
            for(int i=0;i<s;i++)
            {
                int k=adj.get(x).get(i);
                ind[k]--;
                if(ind[k]==0)
                    q.add(k);
            }
        }
        return ans;
    }
}