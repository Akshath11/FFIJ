//Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
//If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
//Input:  arr[] = {1, 6, 11, 5}
//Output: 1
//Explanation:
//Subset1 = {1, 5, 6}, sum of Subset1 = 12
//Subset2 = {11}, sum of Subset2 = 11
//Website:. https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/


public class MinimumSubsetSumDifference_BottomUp {
    public static int MSSD(int[] arr,int sum,Boolean[][] dp){
        for(int i = 1 ; i < sum + 1; i++){
            dp[0][i] = false;
        }
        for(int i = 1 ; i < arr.length + 1; i++){
            dp[i][0] = true;
        }
        dp[0][0] = true;


        for(int i = 1 ; i < arr.length + 1 ; i++ ){
            for(int j = 1 ; j < sum + 1 ; j++){
                if(arr[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]);
                }
            }
        }
        int difference = Integer.MAX_VALUE;
        for(int z = sum / 2 ; z >= 0 ; z--){
            if(dp[arr.length][z] == true){
                difference = sum - (2*z);
                break;
            }
        }
        return difference;
    }
    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 2, 2, 1 };
        int sum = 0;
        for(int i = 0 ; i <  arr.length ; i++){
            sum += arr[i];
        }

        Boolean[][] dp = new Boolean[arr.length + 1][sum + 1];
        System.out.println(MSSD(arr,sum,dp));
    }
}
