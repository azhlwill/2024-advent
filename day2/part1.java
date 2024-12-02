import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class part1 {
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
        if (isSafe(line)){
          safeCount++;
        }
      }
      System.out.println(safeCount);


      input.close();


    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return -100;
  }

  private static boolean isSafe(String line){
    String[] stringLevels = line.split(" ");
    int lineLength = stringLevels.length;
    int[] levels = new int[lineLength];

    for (int i = 0; i < lineLength; i++){
      levels[i] = Integer.parseInt(stringLevels[i]);
    }

    boolean increasing = true;
    boolean decreasing = true;

    for (int j = 1; j < levels.length; j++){
      int adjDiff = levels[j] - levels[j-1];

      if (Math.abs(adjDiff) < 1 || Math.abs(adjDiff) > 3){
        return false;
      }

      if (adjDiff < 0){
        increasing = false;
      } 
      else if (adjDiff > 0){
        decreasing = false;
      }
    }
    return increasing || decreasing;

  }
}
