
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

        /**
         * Example short notation game
         * 1. e4 e5 2. d4 c6 3. Bb5 cxb5 4. Qh5 g6 5. Qxe5+ Be7 6. Qxh8 Nc6 7. d5 Nb4 
         * 8. Qxg8+ Bf8 9. Bh6 Qe7 10. Bxf8 Qxf8 11. Qxh7 Nxc2+ 12. Kf1 Nxa1 13. Nf3 b6 
         * 14. Nc3 d6 15. Nxb5 Bg4 16. Nxd6+ Qxd6 17. e5 Qxd5 18. Qh8+ Ke7 19. Qxa8 Qxa8 
         * 20. Ke2 Bxf3+ 21. gxf3 Qxf3+ 22. Kxf3 Nc2 23. Rc1 Ne3 24. Kxe3 Ke6 25. Rc6+ Kxe5 
         * 26. Rxg6 f6 27. Rxf6 b5 28. Re6+ Kf5 29. Re4 Kg5 30. f4+ Kg4 
         * 
         * Info
         * Where the piece ends - if it took a piece - if there is a check
         * 
         * Need something like this
         * e2-e4 f7-f5\n Bf1-d3 Ke8-f7\n Ng1-f3 g7-g5\n Nf3-h4 f5xe4\n f2-f4
			Kf7-f6\n f4-f5 g5xNh4\ng2-g3 Kf6xf5\nRh1-g1 Ng8-h6\nNb1-c3 Nb8-c6\nRa1-b1 Rh8-g8\nBd3-c4 Ra8-b8
			a2-a3 h4xg3\na3-a4 g3xh2\na4-a5 h2-h1=R"
         * 
         */

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

    // convert short notation move to long
    public static String parseMove(char[][] board,String move){




        return null;
    }

    public static void main(String args[]){
        new GUI();
    }
}