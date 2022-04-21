package xyz.roosterseatyou.CopilotFun;

import java.util.Arrays;
import java.util.Objects;

public class BiologyTestingAllCrossAmt {

    public static String[][] createBoard(String cross, int size) {
        String[][] board = new String[(int) (Math.pow(size, 2) + 1)][(int) (Math.pow(size, 2) + 1)];
        board[0][0] = "X";

        String parOne = cross.split("x")[0];
        String parTwo = cross.split("x")[1];

        String[] parOneTraits = parOne.split("(?<=\\G..)");
        String[] parTwoTraits = parTwo.split("(?<=\\G..)");

        System.out.println("parOneTraits: " + Arrays.toString(parOneTraits));
        System.out.println("parTwoTraits: " + Arrays.toString(parTwoTraits));

        String[] lineOne = new String[(int) Math.pow(size, 2)];
        String[] lineTwo = new String[(int) Math.pow(size, 2)];
        int index = 1;
        for(int i = 1; i < size+1; i++) {
            for(int j = 1; j < size+1; j++) {
                System.out.println("[Run: " + i + " : " + j + "]: " + "Index: " + index);
                //assemble the string
                String[] one = new String[9];
                String oneString = "";
                for (int l = 0; l < 2; l++) {
                    StringBuilder sb = new StringBuilder();
                    for (String parOneTrait : parOneTraits) {
                        sb.append(parOneTrait.charAt(l));
                        System.out.println("Parent One SB: " + sb);
                        one[l] = sb.toString();
                    }
                    oneString = sb.toString();
                }
                System.out.println(Arrays.toString(one));

                StringBuilder sbParTwo = new StringBuilder();
                for (String parTwoTrait : parTwoTraits) {
                    for (int l = 0; l < 2; l++) {
                        sbParTwo.append(parTwoTrait.charAt(l));
                        System.out.println("Parent Two SB: " + sbParTwo);
                    }
                }

                board[index][0] = oneString;
                board[0][index] = sbParTwo.toString();

                index++;
            }
        }
        return board;
    }


}
