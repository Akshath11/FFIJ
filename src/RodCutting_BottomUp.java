public class RodCutting_BottomUp {
    public static int RCBU(int[] cuts,Integer[][] dp,int[] l , int length_of_rod,int i){
       for(int len = 0 ; len < cuts.length + 1 ; len++){

           for(int  j = 0 ; j < length_of_rod + 1 ; j++){
               if(len == 0 || j == 0){
                   dp[len][j] = 0;

               }
               else {
                   if (len > j) {
                       dp[len][j] = dp[len - 1][j];
                   }
                   else {
                       dp[len][j] = Math.max(dp[len - 1][j], (dp[len][j - len] + cuts[len - 1]));
                   }
               }
           }
       }
       return dp[cuts.length][length_of_rod];
    }
    public static void main(String[] args) {
        int[] cuts = {1, 5, 8, 9, 10, 17, 17, 20};
        int length_of_rod = 8;
        int[] l = new int[cuts.length] ;
        for(int i = 0 ; i < cuts.length ; i++){
            l[i] = i + 1;
        }
        Integer[][] dp = new Integer[cuts.length +1][length_of_rod + 1];
        System.out.println(RCBU(cuts,dp,l,length_of_rod,cuts.length - 1));
    }
}
