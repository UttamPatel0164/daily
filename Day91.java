public class Day91 {
    
}
Generate Binary Numbers
Difficulty: EasyAccuracy: 67.48%Submissions: 58K+Points: 2
Given a number n. The task is to generate all binary numbers with decimal values from 1 to n.

Examples:

Input: n = 4
Output: ["1", "10", "11", "100"]
Explanation: Binary numbers from 1 to 4 are 1, 10, 11 and 100.
Input: n = 6
Output: ["1", "10", "11", "100", "101", "110"]
Explanation: Binary numbers from 1 to 6 are 1, 10, 11, 100, 101 and 110.
Constraints:
1 ≤ n ≤ 106

Expected Complexities
Company Tags
AmazonOYO Rooms
Topic Tags
Related Articles
class Solution {
    public String fun(int a)
    {
        String ans="";
        while(a>0)
        {
            int rem=a%2;
            if(rem==0)
                ans+='0';
            else
                ans+='1';
            a/=2;
        }
        String reversed = new StringBuilder(ans).reverse().toString();
        return reversed;
    }
    public ArrayList<String> generateBinary(int n) 
    {
        ArrayList<String> ans=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            ans.add(fun(i));
        }
        return ans;
    }
}
