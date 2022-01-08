//Given an array of integers that represent coins called coins and an integer amount amount, return the total number of ways to get the final solution
//coins = [1, 2, 3]
//amount = 10
//Output: 4
//Explanation: We can use two 3 coins & two 2 coins to fully make change for 10. 3 + 3 + 2 + 2 = 10
//Website: https://leetcode.com/problems/coin-change-2/

public class CoinChange_Recursion {
    public static int count(int[] arr,int m,int target){
        if(target == 0){
            return 1;
        }
        if(m == 0 || target < 0){
            return 0;
        }
        if(arr[m - 1] > target){
            return count(arr,m - 1,target);
        }
        else{
            return count(arr,m - 1,target) + count(arr,m,target - arr[m - 1]);
        }

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int m = arr.length;
        int target = 10;

        System.out.println(count(arr,m,target));
    }
}
