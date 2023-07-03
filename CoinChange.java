import java.util.ArrayList;

public class CoinChange {

    public static int UniqueChangeSolutions(int amount){

        int[] coins = {1,2,5,10,20,50,100}; //Initialising the array of coins to make change with

        int[][] Table = new int[coins.length+1][amount+1];

        for(int i=0; i<= coins.length;i++){
            Table[i][0] = 1; //Only one way to make change for amount zero
        }

        for(int i=1; i<= amount; i++){
            Table[0][i] = 0; // Setting all different ways to make change with zero coins to zero
        }

        for(int i=1; i<=coins.length; i++){ //Every row considers a new coin

            for(int j = 1; j<=amount;j++){
                if(coins[i-1] > j){
                    Table[i][j] = Table[i-1][j]; //Don't use current coin then select previous row choices
                } else{
                    Table[i][j] = Table[i-1][j] + Table[i][j-coins[i-1]]; // Adding choice of coin with possible choices of previous coin
                }
            }
        }

        return Table[coins.length][amount];
    }

    public static void main(String[] args){

        int[] coins = new int[]{1, 2, 5,10 , 20 , 50 , 100, 200};
        int amount = 6;

        //System.out.println(UniqueChangeSolutions(amount));

        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.UniqueChangeSolutions(amount));
    }

}
