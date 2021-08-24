
import java.util.Scanner;
public class Chess{

    static String turnCount = "\\d+\\.";
    public static char[] columns = new char[]{'a','b','c','d','e','f','g','h'};
    public static StringBuilder output = new StringBuilder();
    private static boolean whitesTurn = true;

    public static int charToColumn(char c){
        for(int i = 0; i < 8; i ++){
            if(columns[i] == c) return i+1;
        }
        return -1;
    }

    public static void convert(String input){
        Scanner s = new Scanner(input);
        Board.board = new Board();

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
                whitesTurn = true;
                output.append(parseMove(s.next()));
                whitesTurn = false;
                output.append(" ");
                output.append(parseMove(s.next()));
                output.append("\n");
            }else{
                s.close();
                //throw new Exception("Bad input. Make sure to remove comments {} and brackets ().");
            }
        }
        s.close();
    }

    // convert short notation move to long
    public static String parseMove(String move){

        System.out.println(move);

        if(move.contains("x")){
            move = move.replace("x", "");
        }
        if(move.contains("+")){
            move = move.replace("+", "");
        }
        // pawn move
        if(move.length()==2){
            Position newPos = new Position(Integer.parseInt(move.substring(1,2)),charToColumn(move.charAt(0)));
            for(PieceImpl p : Board.getPiece("P")){
                if(whitesTurn != p.isWhite()) continue;
                if(p.isValidMove(newPos, null, Board.board)){
                    String oldPos = p.getStringPos();
                    Board.pieces[newPos.getRow()][newPos.getColumn()] = p;
                    p.setPos(newPos);
                    Board.pieces[p.getPos().getRow()][p.getPos().getColumn()] = null;
                    return oldPos+"-"+newPos.getStringPos();
                }
            }
        }else{ // piece move
            System.out.println("attempting to parse " + move);
            return parsePieceMove(move);
        }

        return "";
    }

    public static String parsePieceMove(String move){
        
        String piece = move.substring(0,1);
        Position newPos = new Position(Integer.parseInt(move.substring(2,3)),charToColumn(move.charAt(1)));
        System.out.println("attempting to parse " + newPos.toString());
        for(PieceImpl p : Board.getPiece(piece)){
            if(whitesTurn != p.isWhite()) continue;
            if(p.isValidMove(newPos, null, Board.board)){
                String oldPos = p.getStringPos();
                Board.pieces[newPos.getRow()][newPos.getColumn()] = p;
                p.setPos(newPos);
                Board.pieces[p.getPos().getRow()][p.getPos().getColumn()] = null;
                return piece+oldPos+"-"+newPos.getStringPos();
            }
        }
        return "uh oh " + move;
    }

    public static void main(String args[]){
        new GUI();
    }
}