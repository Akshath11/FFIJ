//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//
//Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
//You may assume that you have an infinite number of each kind of coin.
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//Website:. https://leetcode.com/problems/coin-change/


import java.io.*;

public class CoinChangeMinimum_BottomUp
{

    static int minCoins(int coins[], int m, int V)
    {
        int table[] = new int[V + 1];

        table[0] = 0;

        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;


        for (int i = 1; i <= V; i++)
        {

            for (int j = 0; j < m; j++)
                if (coins[j] <= i)
                {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;


                }

        }

        if(table[V]==Integer.MAX_VALUE)
            return -1;

        return table[V];

    }


    public static void main (String[] args)
    {
        int coins[] = {1,3,4,5};
        int m = coins.length;
        int V = 7;
        System.out.println ( "Minimum coins required is "
                + minCoins(coins, m, V));
    }
}

