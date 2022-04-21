package xyz.roosterseatyou.CopilotFun;

import java.util.Arrays;

public class Remake {

    public static String[][] remake(String cross, int amt) {
        String parOne = cross.split("x")[0];
        String parTwo = cross.split("x")[1];

        String[] parOneTraits = parOne.split("(?<=\\G..)");
        String[] parTwoTraits = parTwo.split("(?<=\\G..)");

        System.out.println("parOneTraits: " + Arrays.toString(parOneTraits));
        System.out.println("parTwoTraits: " + Arrays.toString(parTwoTraits));
        int size = getAllCombinationsAmt(parOneTraits);
        System.out.println("All combinations parOne: " + Arrays.toString(getAllCombinations(parOneTraits)));

        String[][] result = new String[size+1][size+1];

        for (int i = 1; i < size+1; i++) {
            for (int j = 1; j < size+1; j++) {

            }
        }

        return null;
    }

    public static int getAllCombinationsAmt(String[] parTraits) {
        int size = 1;
        //get all combinations of the all the characters in parOneTraits
        for (String trait : parTraits) {
            size *= trait.length();
        }
        System.out.println("size: " + size);
        return size;
    }

    public static String[] getAllCombinations(String[] parTraits) {
        int size = getAllCombinationsAmt(parTraits);
        String[] result = new String[size];
        //add each character to the result
        for(String trait : parTraits) {
            
        }
        return result;
    }
}
