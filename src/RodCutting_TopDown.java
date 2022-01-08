//Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if the length of the rod is 8 and the values of different pieces are given as the following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
//length   | 1   2   3   4   5   6   7   8
//--------------------------------------------
//price    | 1   5   8   9  10  17  17  20
//Length of rod : 8;
//Maximum Obtainable Value is 22

public class RodCutting_TopDown {
    public static int RCTD(int[] length,int[] price,int length_of_rod,int i,Integer[][] dp){
        if(length_of_rod == 0 || i == 0){
            dp[length_of_rod][i] = 0;
        }
        if(dp[length_of_rod][i] != null){
            return dp[length_of_rod][i];
        }
        if(length[i] > length_of_rod){
            return dp[length_of_rod][i] = RCTD(length,price,length_of_rod,i - 1,dp);
        }
        else{
            return dp[length_of_rod][i] = Math.max(RCTD(length,price,length_of_rod,i - 1,dp),price[i] + RCTD(length,price,length_of_rod - length[i],i,dp));
        }

    }
    public static void main(String[] args) {
        int[] length = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,20};
        int length_of_rod = 8;
        Integer[][] dp = new Integer[length_of_rod + 1][price.length + 1];
        System.out.println(RCTD(length,price,length_of_rod,price.length - 1,dp));
    }
}
