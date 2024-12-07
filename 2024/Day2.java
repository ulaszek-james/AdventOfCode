import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class Day2 {
    public static void main (String[] args) {
        try (FileReader in = new FileReader("/Users/ulaszek/Projects/AdventOfCode/2024/input/day2.txt")) {
            BufferedReader br = new BufferedReader(in);
            int line = 0;
            int safe = 0;
            String st;
            int[] arr;
            List<Integer> arrList;

            while ((st = br.readLine()) != null) {
                line++;
                arr = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();
                arrList = IntStream.of(arr).boxed().collect(Collectors.toList());

                if (validReport(arrList, false)) {
                    System.out.println("line " + line + ": " + arrList);
                    safe++;
                }
            }

            System.out.println("safe:" + safe);

        } catch (IOException e) {
            System.out.print("U messed up somewhere bud.");
            e.printStackTrace();
        }
    }

    static private boolean validReport(List<Integer> arrList, boolean tolerated) {
        List<Integer> currentRemoved = new ArrayList<Integer>(arrList);
        List<Integer> nextRemoved = new ArrayList<Integer>(arrList);;


        boolean direction = arrList.get(arrList.size()-1) > arrList.get(0) ? true : false;

        for (int i = 0; i < arrList.size() - 1; i++) {

            if (breakLimits(direction, arrList.get(i), arrList.get(i+1))) {
                if (!tolerated) {

                    if (i+1 == arrList.size()-1) {
                        return true;
                    } else {
                        currentRemoved.remove(i);
                        nextRemoved.remove(i+1);
                        
                        if (validReport(currentRemoved, true) == false && validReport(nextRemoved, true) == false) {
                            return false;
                        } else return true;
                    }                

                } else return false;
            }
        }

        return true;
    }
    
    private static boolean breakLimits(boolean direction, int current, int next) {
        if (direction) {
            if (next > current + 3 || next < current + 1) {
                return true;
            }
        } else {
            if (next < current - 3 || next > current - 1) {
                return true;
            }
        }
        return false;
    }
}


/* Part 1 - pls don't look at this code, I'm just trying to get the ANSWER

        try (FileReader in = new FileReader("/Users/ulaszek/Projects/AdventOfCode/2024/input/day2.txt")) {
            BufferedReader br = new BufferedReader(in);

            String st;
            char direction = ' ';
            int safe = 0, last = 0, lastLast = 0, current;
            boolean report, lastLevel;
            boolean tolerated; 

            while ((st = br.readLine()) != null) {
                tolerated = false;
                report = true;
                lastLevel = false;
                int index = 0;
                String temp;

                while (report && !lastLevel) {
                    if (st.contains(" ")) {
                        temp = st.substring(0, st.indexOf(" "));
                    } else {
                        temp = st;
                        lastLevel = true;
                    }

                    if (index == 0) {
                        last = Integer.parseInt(temp);
                        st = st.substring(temp.length() + 1);
                        index++;
                    } else {

                        current = Integer.parseInt(temp);

                        if (index == 1) {
                            if (current < last) {
                                direction = '=';
                            } else direction = '+';
                        }


                        if (direction == '+') {
                            if (current > last + 3 || current < last + 1) {
                                if (!tolerated) {
                                    tolerated = true;
                                } else {
                                    report = false;
                                }
                            }
                        } else {
                            if (current < last - 3 || current > last - 1) {
                                if (!tolerated) {
                                    tolerated = true;
                                } else {
                                    report = false;
                                }
                            }
                        }



                        if (!lastLevel) st = st.substring(temp.length() + 1);
                        
                        if (tolerated && !lastLevel && report) {
                            if (direction == '+') {
                                if (current > lastLast + 3 || current < lastLast + 1) {
                                        report = false;
                                }
                            } else {
                                if (current < lastLast - 3 || current > lastLast - 1) {                                    
                                    report = false;
                                }
                            }
                        }
                        
                        lastLast = last;
                        last = current;
                        index++;
                    } 
                }
                
                if (report) { 
                    safe++;
                    System.out.println(st + " is safe.");
                }
            }

        } catch (IOException e) {
            System.out.print("U messed up somewhere bud.");
            e.printStackTrace();
        }
*/