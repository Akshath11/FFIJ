//Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.
//Input: arr[] = {1, 2, 3, 3}, X = 6
//Output: 3
//All the possible subsets are {1, 2, 3},
//{1, 2, 3} and {3, 3}
//Website :. https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/


public class CountOfSubsetSum_TopDown {
    public static int CSC(int[] arr,int x,Integer[][] dp,int i){
        if(i == arr.length){
            if(x == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[i][x] != null){
            return dp[i][x];
        }

        if(arr[i] > x){
            return dp[i][x] = CSC(arr,x,dp,i + 1);
        }
        else{
            return dp[i][x] = CSC(arr,x,dp,i + 1) + CSC(arr,x - arr[i],dp,i + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr= {1, 2, 3, 3};
        int x = 6;
        Integer[][] dp = new Integer[arr.length + 1][x + 1];
        System.out.println(CSC(arr,x,dp,0));
    }
}
