//Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
//If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
//Input:  arr[] = {1, 6, 11, 5}
//Output: 1
//Explanation:
//Subset1 = {1, 5, 6}, sum of Subset1 = 12
//Subset2 = {11}, sum of Subset2 = 11
//Website:. https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/


public class MinimumSubsetSumDifference_TopDown {
    public static boolean MSSD(int[] arr,int sum,Boolean[][] dp,int i){
        if(i == arr.length){
            if(sum == 0){
                return true;
            }
            else{
                return false;
            }
        }
        if(dp[i][sum] != null){
            return dp[i][sum];
        }
        if(arr[i] > sum){
            return dp[i - 1][sum];
        }
        else{
            return (dp[i - 1][sum] || dp[i - 1][sum - arr[i]]);
        }
    }
    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 2, 2, 1 };
        int sum = 0;
        for(int i = 0 ; i <  arr.length ; i++){
            sum += arr[i];
        }
        Boolean[][] dp = new Boolean[arr.length + 1][sum + 1];
        MSSD(arr,sum,dp,0);
        int result = Integer.MAX_VALUE;
        for(int z = sum/2 ; z >= 0 ; z++){
            if(dp[arr.length][z] == true){
                result = sum - (2*z);
            }
        }
        System.out.println(result);
    }
}
