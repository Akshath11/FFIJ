//Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
//Output: True
//Question:. Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
//Website:. https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class SubsetSum_BottomUp {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 186;
        Boolean[][] dp = new Boolean[arr.length + 1][sum + 1];

        dp[0][0] = true;
        for (int i = 0; i < arr.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++){
                if(arr[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }
                if(arr[i - 1] <= j){
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]);
                }
            }

        }
        System.out.println(dp[arr.length][sum]);
    }
}
