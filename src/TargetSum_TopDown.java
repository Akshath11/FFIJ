//You are given an integer array nums and an integer target.
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3

public class TargetSum_TopDown {
    public static int TS(int[] nums,int target,int i,Integer[][] dp){
        if(i == nums.length){
            if(target == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[i][target] != null){
             return dp[i][target];
        }
        if(nums[i] > target) {
            return dp[i][target] = TS(nums,target,i + 1,dp);
        }
        else{
            return dp[i][target] = (TS(nums,target,i + 1,dp) + TS(nums,target - nums[i],i + 1,dp));
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        int total = 0;
        for(int a : nums){
            total += a;
        }
        target = ((target + total) / 2) ;
        Integer[][] dp = new Integer[nums.length + 1][target + 1];
        System.out.println(TS(nums,target,0,dp));
    }
}
