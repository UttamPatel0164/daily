public K Closest Points to Origin
Difficulty: MediumAccuracy: 62.4%Submissions: 25K+Points: 4
Given an integer k and an array of points points[][], where each point is represented as points[i] = [xi, yi] on the X-Y plane. Return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance, defined as:
distance = sqrt( (x2 - x1)2 + (y2 - y1)2 )

Note: You can return the k closest points in any order, the driver code will print them in sorted order.
Test Cases are generated such that there will be a unique ans.

Examples:

Input: k = 2, points[] = [[1, 3], [-2, 2], [5, 8], [0, 1]]
Output: [[-2, 2], [0, 1]]
Explanation: The Euclidean distances from the origin are:
Point (1, 3) = sqrt(10)
Point (-2, 2) = sqrt(8)
Point (5, 8) = sqrt(89)
Point (0, 1) = sqrt(1)
The two closest points to the origin are [-2, 2] and [0, 1].
Input: k = 1, points = [[2, 4], [-1, -1], [0, 0]]
Output: [[0, 0]]
Explanation: The Euclidean distances from the origin are:
Point (2, 4) = sqrt(20)
Point (-1, -1) = sqrt(2)
Point (0, 0) = sqrt(0)
The closest point to origin is (0, 0). {
    
}
class Pair
{
    int dist;
    ArrayList<Integer> p;
    Pair(int dist,ArrayList<Integer> p)
    {
        this.dist=dist;
        this.p=p;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] a, int k) 
    {
        PriorityQueue<Pair> mh=new PriorityQueue<>(
            (x,y)->y.dist-x.dist
            
            );
        int n=a.length;
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> lis=new ArrayList<>();
            lis.add(a[i][0]);
            lis.add(a[i][1]);
            if(mh.size()<k)
            {
                int d=(Math.abs(a[i][0])*Math.abs(a[i][0]))+(Math.abs(a[i][1])*Math.abs(a[i][1]));
                mh.add(new Pair(d,lis));
            }
            else
            {
                int d=(Math.abs(a[i][0])*Math.abs(a[i][0]))+(Math.abs(a[i][1])*Math.abs(a[i][1]));
                if(mh.peek().dist>d)
                {
                    mh.poll();
                    mh.add(new Pair(d,lis));
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        while(!mh.isEmpty())
        {
            ans.add(mh.peek().p);
            mh.poll();
        }
        return ans;
    }
}