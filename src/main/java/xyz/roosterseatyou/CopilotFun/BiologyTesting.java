package xyz.roosterseatyou.CopilotFun;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import netscape.javascript.JSObject;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;

public class BiologyTesting {

    public static String[][] createDiGrid(String cross){
        String[][] grid = new String[5][5];
        grid[0][0] = "X";

        String parOne = cross.split("x")[0];
        String parTwo = cross.split("x")[1];

        String[] parOneA = (parOne.split("")[0] + parOne.split("")[1]).split("");
        String[] parOneB = (parOne.split("")[2] + parOne.split("")[3]).split("");

        String[] parTwoA = (parTwo.split("")[0] + parTwo.split("")[1]).split("");
        String[] parTwoB = (parTwo.split("")[2] + parTwo.split("")[3]).split("");

        int index = 1;

        for(int i = 1; i < 3; i ++) {
            for(int j = 1; j < 3; j ++) {
                grid[index][0] = parOneA[i-1] + parOneB[j-1];
                grid[0][index] = parTwoA[i-1] + parTwoB[j-1];
                System.out.println("[" + index + ", 0]: " + grid[index][0]);
                index++;
            }
        }
        System.out.println("========== END CREATE ==========");
        return grid;
    }

    public static String[] solveDiGrid(String[][] grid){
        String[] result = new String[16];
        int index = 0;
        for(int i = 1; i < 5; i++ ){
            for(int j = 1; j < 5; j++){
                //combine the first character of the strings from the top of the column and the first character of the strings from the left of the row
                String a = grid[i][0].charAt(0) + grid[0][j].substring(0,1);
                //combine the second character of the strings from the top of the column and the second character of the strings from the left of the row
                String b = grid[i][0].charAt(1) + grid[0][j].substring(1,2);
                String temp = a + b;
                System.out.println("[" + i + ", " + j + "]: " + "Added " + temp + " at " + index);
                result[index] = temp;
                index++;
            }
        }
        System.out.println("========== END SOLVE ==========");
        return result;
    }

    public static void fillTable(String[][] grid, String[] result){
        int index = 0;
        for(int i = 1; i < 5; i++ ){
            for(int j = 1; j < 5; j++){
                grid[i][j] = result[index];
                index++;
            }
        }
    }

    public static String[] getFinalResults(String cross){
        String[][] grid = createDiGrid(cross);
        return solveDiGrid(grid);
    }

    public static String getRatios(String[] result){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            int currCount = 1;
            for(int j = 0; j < result.length; j++){
                if(result[i] != null && result[j] != null && result[i].equals(result[j]) && i != j){
                    String currentTimeStamp = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(new java.util.Date());
                    System.out.println( "[" + currentTimeStamp +  "]: Found a match at " + i + " and " + j + " for " + result[i] + " and " + result[j]);
                    currCount++;
                    result[j] = null;
                }
                if(currCount == result.length) {
                    return "All " + result[i] + "s";
                }
            }
            if(result[i] != null) sb.append(currCount).append(result[i]).append(":");
        }
        return sb.toString();
    }

    public static void printTable(String[][] grid){
        for(String[] row : grid){
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
