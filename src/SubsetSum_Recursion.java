//Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
//Output: True
//Question:. Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
//Website:. https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class SubsetSum_Recursion {
    public static boolean subsetsum(int[] arr,int sum,int i){
        if(sum == 0){
            return true;
        }
        if(i == 0 ){
            return false;
        }
        if(arr[i] > sum){
            return subsetsum(arr,sum,i - 1);
        }
        boolean ans = subsetsum(arr,sum,i - 1) || subsetsum(arr,sum - arr[i],i - 1);

        return ans;

    }
    public static void main(String[] args) {

        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 909;
        System.out.println(subsetsum(arr,sum,arr.length - 1));
    }
}
