import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class part2 {
  public static void main(String[] args) {
    System.out.println(solved("input.txt"));
  }

  public static int solved(String filename){
    try {
      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      int safeCount = 0;
      while (input.hasNextLine()){
        String line = input.nextLine();
        String[] stringLevels = line.split(" ");
        ArrayList<Integer> levels = new ArrayList<Integer>();

        for (int i = 0; i < stringLevels.length; i++){
          levels.add(Integer.parseInt(stringLevels[i])); // put everything in
        }
///////
        if (isSafe(levels)){ // no need for removal
          safeCount++; 
        }
        else{ // u only need to see if any removal can fix it
          boolean safeRemoval = false; // might get switched if one removal can fix it
          for (int i = 0; i < levels.size(); i++){ // every possible removal
            int temp = levels.get(i); // need to put back later
            levels.remove(i); // get rid of it

            if (isSafe(levels)){
              safeRemoval = true; // removal worked
            }

            levels.add(i, temp); // put it back so it doesnt affect the next removals
          }

          if (safeRemoval){ // problem dampener
            safeCount++;
          }
        }
      }
      System.out.println(safeCount);


      input.close();


    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return -100;
  }

  
  private static boolean isSafe(ArrayList<Integer> levels){

    boolean increasing = true;
    boolean decreasing = true;

    for (int j = 1; j < levels.size(); j++){
      int adjDiff = levels.get(j) - levels.get(j-1);

      if (Math.abs(adjDiff) < 1 || Math.abs(adjDiff) > 3){ // between 1 and 3
        return false;
      }

      if (adjDiff < 0){
        increasing = false; // means theres a sequence of 2 numbers that go down
      } 
      else if (adjDiff > 0){
        decreasing = false; // sequence of 2 numbers that are going up
      }
    }
    return increasing || decreasing; // should only be 1 true for a safe report

  }
    
}
