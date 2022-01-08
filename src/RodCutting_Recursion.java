//Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if the length of the rod is 8 and the values of different pieces are given as the following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
//length   | 1   2   3   4   5   6   7   8
//--------------------------------------------
//price    | 1   5   8   9  10  17  17  20
//Length of rod : 8;
//Maximum Obtainable Value is 22

public class RodCutting_Recursion {
    public static int maxrod(int[] length , int[] price , int length_of_rod, int i){
        if(i == 0 || length_of_rod == 0){
            return 0;
        }

        if(length[i] > length_of_rod){
            return maxrod(length,price,length_of_rod,i - 1);
        }
        else{
            return Math.max(maxrod(length,price,length_of_rod,i - 1),maxrod(length,price,length_of_rod - length[i],i) + price[i]);
        }

    }
    public static void main(String[] args) {
        int[] length = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,20};
        int length_of_rod = 8;
        System.out.println(maxrod(length,price,length_of_rod,length.length - 1));
    }
}
