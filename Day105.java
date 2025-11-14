Graph Diameter
Difficulty: MediumAccuracy: 68.96%Submissions: 668+Points: 4
You are given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertex u and vertex v. Find the diameter of the graph.
The diameter of a graph (sometimes called the width) is the number of edges on the longest path between two vertices in the graph.

Examples :

Input: V = 6, E = 5, edges[][] = [[0, 1], [0, 4], [1, 3], [1, 2], [2, 5]]
    
Output: 4
Explanation: The longest path in the graph is from vertices 4 to vertices 5 (4 -> 0 -> 1 -> 2 -> 5).
Input: V = 7, E = 6, edges[][] = [[0, 2], [0, 4], [0, 3], [3, 1], [3, 5], [1, 6]]
    
Output: 4
Explanation: The longest path in the graph is from vertices 2 to vertices 6 (2 -> 0 -> 3 -> 1 -> 6).
Constraints:
2 ≤ V ≤  105
1 ≤ E ≤  V - 1
0 ≤ edges[i][0], edges[i][1] < V

class Solution {
    int maxdist;
    int fn;
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int p,int dis)
    {
       if(dis>maxdist)
       {
           maxdist=dis;
           fn=node;
       }
       for(int i:adj.get(node))
       {
           if(i!=p)
           {
               dfs(i,adj,node,dis+1);
           }
       }
    }
    public int diameter(int v, int[][] e) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] vis=new int[v];
        Arrays.fill(vis,0);
        for(int i=0;i<v;i++)
        {
            ArrayList<Integer> li=new ArrayList<>();
            adj.add(li);
        }
        for(int i=0;i<e.length;i++)
        {
            adj.get(e[i][0]).add(e[i][1]);
            adj.get(e[i][1]).add(e[i][0]);
        }
        maxdist=-1;
        dfs(0,adj,-1,0);
        maxdist=-1;
        dfs(fn,adj,-1,0);
        return maxdist;
    }
}