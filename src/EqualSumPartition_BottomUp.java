//Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//Input: nums = [1,5,11,5]
//Output: true
//Website:. https://leetcode.com/problems/partition-equal-subset-sum/



public class EqualSumPartition_BottomUp {
    public static boolean ESP(int[] arr,int total,Boolean[][] dp){
       for(int ai = 1 ; ai < total + 1 ; ai ++){
           dp[0][ai] = false;
       }
        for(int a = 1 ; a < arr.length + 1 ; a ++){
            dp[a][0] = true;
        }
        dp[0][0] = true;

        for(int i = 1 ; i < arr.length + 1 ; i ++) {
            for(int j = 1 ; j < total + 1 ; j ++){
                if(arr[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]);
                }
            }
        }
        return dp[arr.length][total];

    }
    public static void main(String[] args) {
        int[] arr = {400,30};
        int total = 0;
        for(int item:arr){
            total += item;
        }
        if(total % 2 != 0){
            System.out.println("Cannot happen");
        }
        else {
            total = total / 2;
            Boolean[][] dp = new Boolean[arr.length + 1][total + 1];
            System.out.println(ESP(arr, total, dp));
        }
    }
}
