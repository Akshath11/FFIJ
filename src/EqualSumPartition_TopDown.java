//Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//Input: nums = [1,5,11,5]
//Output: true
//Website:. https://leetcode.com/problems/partition-equal-subset-sum/


public class EqualSumPartition_TopDown {
    public static boolean ESP(int[] arr,int total,Boolean[][] dp,int i){
        if(total == 0){
            return true;
        }
        if(i == arr.length){
            return false;
        }
        if(dp[i][total] != null){
            return dp[i][total];
        }
        if(arr[i] > total){
            return dp[i][total] = ESP(arr,total,dp,i + 1);
        }

        return dp[i][total] = (ESP(arr,total,dp,i + 1) || ESP(arr,total - arr[i],dp,i + 1));


    }
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int total = 0;

        for(int item:arr){
            total += item;
        }
        if(total % 2 != 0){
            System.out.println("Cannot happen");
        }
        else{
            total = total / 2;
            Boolean[][] dp = new Boolean[arr.length + 1][total + 1];
            System.out.println(ESP(arr,total,dp,0));
            for(int i  = 0 ; i <  arr.length + 1 ; i ++){
                for(int  j = 0 ; j < total + 1 ; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
                }
            }
        }
    }

