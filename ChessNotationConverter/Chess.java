package ChessNotationConverter;
import java.util.Scanner;
public class Chess{

    static String turnCount = "\\d+\\.";

    public static boolean convert(String input) throws Exception{
        Scanner s = new Scanner(input);

        String[][] turns = new String[100][2];
        char[][] board = new char[][]{
            {'R','N','B','Q','K','B','N','R'},
            {'P','P','P','P','P','P','P','P'},
            {'_','_','_','_','_','_','_','_'},
            {'_','_','_','_','_','_','_','_'},
            {'_','_','_','_','_','_','_','_'},
            {'_','_','_','_','_','_','_','_'},
            {'p','p','p','p','p','p','p','p'},
            {'r','n','b','q','k','b','n','r'}
        };

        while(s.hasNext()){
            String next = s.next();
            // turn each round into a pair of moves
            if(next.matches(turnCount)){
                String[] turn = new String[2];
                turn[0] = s.next();
                turn[1] = s.next();
                
            }else{
                throw new Exception("Bad input. Make sure to remove comments {} and brackets ().");
            }
        }
        s.close();
        return true;
    }
    public static void main(String args[]){
        new GUI();
    }
}