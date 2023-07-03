import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class coinChangeProgram {
    public static void main(String[] args) {

        try {
            File file = new File("C:\\Users\\reign\\IdeaProjects\\Practical2\\src\\juice.csv");
            Scanner scan = new Scanner(file);

            scan.nextLine();
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String arr[] = line.split(";");

                int bill = Integer.parseInt(arr[0]);
                int tip = Integer.parseInt(arr[1]);
                int finalBill = bill+tip;
                int amount = Integer.parseInt(arr[2]);
                int finalAmount = amount-(bill + tip);
                CoinChange coinChange = new CoinChange();
                int changeSolution = coinChange.UniqueChangeSolutions(finalAmount);
                System.out.println("The final amount to pay is R" + finalBill  + ".");
                System.out.println("The customer requires R" + finalAmount + " change.");
                System.out.println("The number of ways to make change for R" + finalAmount + " is " + changeSolution + ".");
                System.out.println();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
