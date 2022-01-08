//Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
//Output: True
//Question:. Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
//Website:. https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class SubsetSum_TopDown {
    public static boolean subsetsum(int[] arr,int sum,Boolean[][] dp,int i) {
        if (sum == 0) {
            return true;
        }
        if (i == 0) {
            return false;
        }

        if (arr[i] > sum) {
        return dp[i][sum] = subsetsum(arr,sum,dp, i - 1);
        }
        if(dp[i][sum] != null){
            return dp[i][sum];
        }
        return dp[i][sum] = (subsetsum(arr,sum,dp, i - 1) || subsetsum(arr,sum - arr[i],dp,i - 1));
    }
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        Boolean[][] dp = new Boolean[arr.length + 1][sum + 1];
        System.out.println(subsetsum(arr,sum,dp,arr.length - 1));
    }
}
