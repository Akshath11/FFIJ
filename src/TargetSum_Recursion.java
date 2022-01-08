//You are given an integer array nums and an integer target.
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3


public class TargetSum_Recursion {
    public static int TS(int[] nums,int target,int i){
        if(i == nums.length){
            if(target == 0){
                return 1;
            }
            else{
                return 0;
            }
        }

        if(nums[i] > target) {
            return TS(nums,target,i + 1);
        }
        else{
            return (TS(nums,target,i + 1) + TS(nums,target - nums[i],i + 1));
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
        System.out.println(TS(nums,target,0));
    }
}
