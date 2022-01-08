//Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//Input: nums = [1,5,11,5]
//Output: true
//Website:. https://leetcode.com/problems/partition-equal-subset-sum/


public class EqualSumPartition_Recursion {
    public static boolean ESP(int[] arr,int total,int i){
        if(total == 0){
            return true;
        }
        if(i == arr.length || total < 0){
            return false;
        }

        boolean result = (ESP(arr,total,i + 1) || ESP(arr,total - arr[i], i + 1));
        return result;

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
            System.out.println(total);
            System.out.println(ESP(arr,total,0));
        }
    }
}
