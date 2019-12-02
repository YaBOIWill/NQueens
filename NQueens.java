//NQueens java program
//importing
import java.util.*;
//main public class 
public class NQueens {
    //decalaring variables
    private int[] arr;
    private boolean[] arr1;
    private int soln;
    //main method
    public static void main(String[] args) {
        NQueens m = new NQueens(8);
        m.solving();
        m.displaySolutions();
    }
    //constructor
    public NQueens(int n) {
        arr = new int[n];
        arr1 = new boolean[n];
        soln = 0;
        for (int x = 0; x < n; x++) {
            arr[x] = -1;
            arr1[x] = false;
        }
    }
    public void solving() {
        recursiveSolution(0);
    }
    //recursive method
    public void recursiveSolution(int loc) {
        int x;
        if (loc == arr.length) {
            displaySolution();
            soln++;
        }
        for (x = 0; x < arr.length; x++) {
            if (arr1[x] == false) {
                if (!backtracking(loc, x)) {
                    arr[loc] = x;
                    arr1[x] = true;
                    recursiveSolution(loc + 1);
                    arr1[x] = false;
                }
            }
        }
    }
    //method for backtracking
    private boolean backtracking(int loc, int r) {
        int x;
        for (x = 0; x < loc; x++) {
            if (Math.abs(loc - x) == Math.abs(arr[x] - r)) {
                return true;
            }
        }
        return false;
    }
    //solution method
    public void displaySolution() {
        int x, y;
        //displays the solutions
        System.out.println("Here is a solution:\n");
        for (x = 0; x < arr.length; x++) {
            for (y = 0; y < arr.length; y++) {
                if (arr[y] == x) {
                    System.out.print("1 ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println("\n");
        }
    }
    //solutions method
    public void displaySolutions() {
        //prints out the total number of solutions
        System.out.println("There were " + soln + " solutions.");
    }
}
