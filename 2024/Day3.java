import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {
    public static void main (String[] args) {
        try (FileReader in = new FileReader("/Users/ulaszek/Projects/AdventOfCode/2024/input/day3.txt")) {
            BufferedReader br = new BufferedReader(in);
            String st;
            int sum =  0;

            while ((st = br.readLine()) != null) {
                while (st.contains("mul(")) {
                    int index = st.indexOf("mul(");
                    st = st.substring(index+4);
                    // System.out.println(st + "\n");
                    // int comma = st.indexOf(',');
                    // System.out.println(st.substring(0, comma));

                    String result = validMul(st);

                    if (result.chars().allMatch(Character::isDigit)) {
                        sum += Integer.parseInt(result);
                    }
                }
            }

            System.out.println("Sum: " + sum);

        } catch (IOException e) {
            System.out.print("U messed up somewhere bud.");
            e.printStackTrace();
        }
    }

    private static String validMul(String mul) {
        int comma = mul.indexOf(",");
        int closeParan = mul.indexOf(")");

        if (comma > 3) {
            return "Comma too far";
        }

        if (closeParan > 7) {
            return "CloseParan too far";
        }

        String firstOperand = mul.substring(0, comma);
        String secondOperand = mul.substring(comma+1, closeParan);

        if (!firstOperand.chars().allMatch(Character::isDigit)) {
            return "1st operand has a non-digit";
        }

        if (!secondOperand.chars().allMatch(Character::isDigit)) {
            return "2nd operand has a non-digit";
        }

        return String.valueOf(Integer.parseInt(firstOperand) * Integer.parseInt(secondOperand));
    }
}
