import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Template {
    public static void main (String[] args) {
        try (FileReader in = new FileReader("/Users/ulaszek/Projects/AdventOfCode/2024/input/DAY#.txt")) {
            BufferedReader br = new BufferedReader(in);
            String st;

            while ((st = br.readLine()) != null) {

            }

            System.out.println("Output");

        } catch (IOException e) {
            System.out.print("U messed up somewhere bud.");
            e.printStackTrace();
        }
    }
}
