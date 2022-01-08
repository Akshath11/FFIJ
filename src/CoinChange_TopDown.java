////Given an array of integers that represent coins called coins and an integer amount amount, return the total number of ways to get the final solution
//Input:
//coins = [1, 2, 3]
//amount = 10
//Output: 4
//Explanation: We can use two 3 coins & two 2 coins to fully make change for 10. 3 + 3 + 2 + 2 = 10
//Website : https://leetcode.com/problems/coin-change-2/


 public class CoinChange_TopDown {
    public static int count(int[] arr,int target,int m,Integer[][] dp){
     if(target == 0){
         return dp[m][target] = 1;
     }
     if(m == 0 || target < 0){
         return dp[m][target] = 0;
     }
     if(dp[m][target] != null){
         return dp[m][target];
     }
     if(arr[m - 1] > target){
         return dp[m][target] = count(arr,target,m - 1,dp);
     }
     else{
         return dp[m][target] = count(arr,target,m - 1,dp) + count(arr,target - arr[m - 1],m,dp);
     }
    }
     public static void main(String[] args) {
         int[] coins = {1,2,5};
         int m = coins.length;
         int amount = 5;
         Integer[][] dp = new Integer[coins.length + 1][amount + 1];
         System.out.println(count(coins,amount,m,dp));
     }
}

