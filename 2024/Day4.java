import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day4 {
    public static void main (String[] args) {
        try (FileReader in = new FileReader("/Users/ulaszek/Projects/AdventOfCode/2024/input/day4.txt")) {
            BufferedReader br = new BufferedReader(in);
            String st;
            ArrayList<String> matrix = new ArrayList<String>();
            int xmas = 0;

            while ((st = br.readLine()) != null) {
                matrix.add(st);
            }

            for (int line = 0; line < matrix.size(); line++) {
                
            }

            System.out.println("Merry Chirstmas! x : " + xmas);

        } catch (IOException e) {
            System.out.print("U messed up somewhere bud.");
            e.printStackTrace();
        }
    }

    private static int amountOfXmas(ArrayList<String> matrix) {
        int result = 0;

        

        return result;
    }
}
