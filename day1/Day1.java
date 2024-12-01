import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.util.Collections;

public class Day1 {
  public static void main(String[] args) {
    System.out.println(solved("input.txt"));
  }

  public static int solved(String filename){

    try {
      File file = new File("input.txt");
      Scanner input = new Scanner(file);


      ArrayList<Integer> col1 = new ArrayList<Integer>();
      ArrayList<Integer> col2 = new ArrayList<Integer>();

      while (input.hasNext()){
        int nextNum1 = Integer.parseInt(input.next());
        col1.add(nextNum1);
        int nextNum2 = Integer.parseInt(input.next());
        col2.add(nextNum2);
      }
      Collections.sort(col1);
      Collections.sort(col2);

      System.out.println(col1.toString());
      System.out.println(col2.toString());
      System.out.println("\n");

      int totalDistance = 0;
      int size = col1.size();

      for (int i = 0; i < size; i++){
        totalDistance += Math.abs(col1.get(i) - col2.get(i));
      }

      System.out.println(totalDistance);

      input.close();


    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return 0;
  }
}
