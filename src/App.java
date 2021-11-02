import java.util.Scanner;

public class App {
    public static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        getTableOrder();
    }

    public static double getAllTableOrders(){
        double regTotal = 0;
        while(moreTablesToServe()){
            double tabTotal = getTableOrder();
            regTotal += tabTotal;
        }
        return regTotal;
    }
    
    public static double getTableOrder(){
        double total = 0;
        int diners = getNumberOfDinersAtTable();
        while( diners > 0){
            total += getDinersOrder();
            diners--;
        }
        double tax = total * 0.08;

        System.out.println("Table total : " + total);
        System.out.println("Tax amount : " + tax);

        displaySuggestedTipAmounts(total);

        return (total + tax);
    }

    public static double getDinersOrder(){
        double c = 0;
        displayMenu();
        while( dinerWantsAnotherItem() ) {
            c += (double)getPriceOfMenuChoice(getMenuChoice());
        }
        return c;
    }
     
    public static void displaySuggestedTipAmounts(double b){
        System.out.println("10% tip: " + String.format("%.2f", b * 0.1));
        System.out.println("15% tip: " + String.format("%.2f", b * 0.15));
        System.out.println("20% tip: " + String.format("%.2f", b * 0.20));
        System.out.println("25% tip: " + String.format("%.2f", b * 0.25));
    }
    
    // define your method(s) here below
    public static int getNumberOfDinersAtTable() {
        System.out.print("Enter number of diners at this table: ");
        int val = scnr.nextInt();
        return val;
    }
    
    public static boolean dinerWantsAnotherItem() {
        System.out.print("Another item ('yes' or 'no')? ");
        String val = scnr.next();
        if( val.equals("yes") ) {
            extraln();
            return true;
        }
        else {
            extraln();
            return false;  
        }
    }
    
    public static void displayMenu(){
        System.out.println("1) eggs          $3.25");
        System.out.println("2) bacon         $4.00");
        System.out.println("3) pancakes      $2.50");
        System.out.println("4) orange juice  $1.25");
        System.out.println("5) oatmeal       $3.99");
        System.out.println("6) milk          $1.25");
        System.out.println("7) donut         $2.00");
    }

    public static int getMenuChoice(){
        System.out.print("Enter a menu choice : ");
        int choice = scnr.nextInt();
        extraln();
        return choice;
    }
    
    public static double getPriceOfMenuChoice(int a){
        double[] d = { 3.25, 4.00, 2.50, 1.25, 3.99, 1.25, 2.00 };
        double val = d[a-1];
        return val;
    }

    public static boolean moreTablesToServe(){
        System.out.print("Another table ('yes' or 'no')? ");
        String val = scnr.next();
        if( val.equals("yes") ) {
            extraln();
            return true;
        }
        else {
            extraln();
            return false;  
        }
    }

    public static void extraln(){
        System.out.println();
    }
}
