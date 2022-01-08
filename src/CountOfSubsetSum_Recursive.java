//Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.
//Input: arr[] = {1, 2, 3, 3}, X = 6
//Output: 3
//All the possible subsets are {1, 2, 3},
//{1, 2, 3} and {3, 3}
//Website :. https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/

public class CountOfSubsetSum_Recursive {
    public static int CSC(int[] arr,int x,int i){
        if(i == arr.length){
            if(x == 0){
                return 1;
            }
            else{
                return 0;
            }
        }

        if(arr[i] > x){
            return CSC(arr,x,i + 1);
        }
        else{
            return CSC(arr,x,i + 1) + CSC(arr,x - arr[i],i + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr= {1, 2, 3, 3};
        int x = 6;
        System.out.println(CSC(arr,x,0));
    }
}
