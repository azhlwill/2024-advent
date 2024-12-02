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

      while (input.hasNext()){
        System.out.println(input.next());
      }


      input.close();


    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return 0;
  }
}
