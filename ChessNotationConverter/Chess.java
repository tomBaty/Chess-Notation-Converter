
import java.util.Scanner;
public class Chess{

    static String turnCount = "\\d+\\.";
    public static char[] columns = new char[]{'a','b','c','d','e','f','g','h'};
    public static StringBuilder output;
    private static boolean whitesTurn = true;
    private static Board board;

    public static int charToColumn(char c){
        for(int i = 0; i < 8; i ++){
            if(columns[i] == c) return i+1;
        }
        return -1;
    }

    public static void convert(String input){
        output = new StringBuilder();
        Scanner s = new Scanner(input);
        board = new Board();

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
                System.out.println(board.toString());
                whitesTurn = false;
                output.append(" ");
                if(!s.hasNext()) break;
                output.append(parseMove(s.next()));
                System.out.println(board.toString());
                output.append("\n");
                
            }else{
                if(next.matches("\\d-\\d") || next.equals("1/2-1/2")) break;
                System.out.println("Parse error");
                s.close();
            }
        }
        
        s.close();
        System.out.println(board.toString());
    }

    // convert short notation move to long
    public static String parseMove(String move){

        boolean tookThisTurn = false;

        System.out.println(move);

        // end game
        if(move.matches("\\d-\\d") || move.equals("1/2-1/2")){
            return "";
        }

        // take 
        if(move.contains("x")){
            move = move.replace("x", "");
            tookThisTurn = true;
        } // check
        if(move.contains("+")){
            move = move.replace("+", "");
        } // castle
        if(move.contains("O")){
            int r = whitesTurn ? 1 : 8;
            // short castle
            if(move.equals("O-O")){
                board.pieces[r][7] = new King(whitesTurn,new Position(r,7));
                board.pieces[r][5] = null;
                board.pieces[r][8] = null;
                board.pieces[r][6] = new Rook(whitesTurn,new Position(r,6));
            }else{ // long castle
                board.pieces[r][3] = new King(whitesTurn,new Position(r,3));
                board.pieces[r][5] = null;
                board.pieces[r][1] = null;
                board.pieces[r][4] = new Rook(whitesTurn,new Position(r,4));
            }
            return move;
        }
        // pawn move
        if(!move.substring(0,1).matches("[NQRKB]")){
            
            Position newPos = tookThisTurn ? new Position(Integer.parseInt(move.substring(2,3)),charToColumn(move.charAt(1))) :
                                             new Position(Integer.parseInt(move.substring(1,2)),charToColumn(move.charAt(0)));
            int pieceColumn = tookThisTurn ? charToColumn(move.substring(0,1).charAt(0)) :
                                             0;
            for(PieceImpl p : board.getPiece("P")){
                if(whitesTurn != p.isWhite()) continue;
                if(pieceColumn!=0 && p.getPos().getColumn() != pieceColumn) continue;
                if(p.isValidMove(newPos, tookThisTurn, board)){
                    String oldPos = p.getStringPos();
                    
                    // set pawn to new position
                    board.pieces[newPos.getRow()][newPos.getColumn()] = p;
                    board.pieces[p.getPos().getRow()][p.getPos().getColumn()] = null;
                    p.setPos(newPos);
                    String divider = tookThisTurn ? "x" : "-";
                    Pawn p1 = (Pawn) p; p1.movedYet = true;
                    return oldPos+divider+newPos.getStringPos();
                }
            }
        }else{ // piece move
            
            return parsePieceMove(move,tookThisTurn);
        }

        System.out.println("failed to parse pawn move: " + move);
        System.out.println(board.toString());
        
        return "badp";
    }

    public static String parsePieceMove(String move,boolean took){

        String piece = move.substring(0,1);
        Position newPos;
        
        int pieceColumn = 0;
        // move possible from two different pieces
        // eg. Nbd7 Knight on B column moves to d7
        if(move.length()==4){
            pieceColumn = charToColumn(move.substring(1,2).charAt(0));
            newPos = new Position(Integer.parseInt(move.substring(3,4)),charToColumn(move.charAt(2)));
        }else{
            newPos = new Position(Integer.parseInt(move.substring(2,3)),charToColumn(move.charAt(1)));
        }

        for(PieceImpl p : board.getPiece(piece)){
            // only check pieces for the colour whose turn it is
            if((whitesTurn && !p.isWhite()) || !whitesTurn && p.isWhite()) continue;
            // if the move is a four-char move, only check pieces in the specified column
            if(pieceColumn!=0 && p.getPos().getColumn() != pieceColumn) continue;
            if(p.isValidMove(newPos, false, board)){
                String oldPos = p.getStringPos();
                board.pieces[newPos.getRow()][newPos.getColumn()] = p;
                board.pieces[p.getPos().getRow()][p.getPos().getColumn()] = null;
                p.setPos(newPos);
                String divider = took ? "x" : "-";
                return piece+oldPos+divider+newPos.getStringPos();
            }
        }
        System.out.println("failed to parse piece move: " + move);
        System.out.println(board.toString());
        
        return "badm";
    }

    public static void main(String args[]){
        new GUI();
    }
}