package src;

import java.util.Scanner;
public class Chess{

    static String turnCount = "\\d+\\.";
    public static char[] columns = new char[]{'a','b','c','d','e','f','g','h'};
    public static StringBuilder output;
    private static boolean whitesTurn = true;
    public static Board board;

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

        while(s.hasNext()){
            String next = s.next();
            // turn each round into a pair of moves
            if(next.matches(turnCount)){
                whitesTurn = true;
                output.append(parseMove(s.next()));
                whitesTurn = false;
                output.append(" ");
                if(!s.hasNext()) break;
                output.append(parseMove(s.next()));
                output.append("\n");
                
            }else{
                if(next.matches("\\d-\\d") || next.equals("1/2-1/2")) break;
                System.out.println("Syntax parse error");
                s.close();
            }
        }
        
        s.close();
    }

    // convert short notation move to long
    public static String parseMove(String move){

        boolean tookThisTurn = false;
        String enPassantMade = "";
        boolean check = false;
        boolean mate = false;

        // end game
        if(move.matches("\\d-\\d") || move.equals("1/2-1/2")){
            return "";
        }// castle
        if(move.contains("O")){
            int r = whitesTurn ? 1 : 8;
            // short castle
            if(move.equals("O-O")){
                board.pieces[r][7] = new King(whitesTurn,new Position(r,7));
                board.pieces[r][5] = null;
                board.pieces[r][8] = null;
                board.pieces[r][6] = new Rook(whitesTurn,new Position(r,6));
            }else{ 
                // long castle
                board.pieces[r][3] = new King(whitesTurn,new Position(r,3));
                board.pieces[r][5] = null;
                board.pieces[r][1] = null;
                board.pieces[r][4] = new Rook(whitesTurn,new Position(r,4));
            }
            return move;
        }

        // take 
        if(move.contains("x")){
            move = move.replace("x", "");
            tookThisTurn = true;
        } //checkmate
        if(move.contains("#")){
            move = move.replace("#", "");
            mate = true;
        }// check
        if(move.contains("+")){
            move = move.replace("+", "");
            check = true;
        } 
        
        // pawn move
        if(!move.substring(0,1).matches("[NQRKB]")){

            String promo = "";
            
            Position newPos = tookThisTurn ? new Position(Integer.parseInt(move.substring(2,3)),charToColumn(move.charAt(1))) :
                                             new Position(Integer.parseInt(move.substring(1,2)),charToColumn(move.charAt(0)));
            int pieceColumn = tookThisTurn ? charToColumn(move.substring(0,1).charAt(0)) :
                                             0;
            for(PieceImpl p : board.getPiece("P")){
                // scan through all pawns on the board to see if they can make this move
                if(whitesTurn != p.isWhite()) continue;
                if(pieceColumn!=0 && p.getPos().getColumn() != pieceColumn) continue;
                if(p.isValidMove(newPos, tookThisTurn, board)){
                    String oldPos = p.getStringPos();
                    String divider = "";

                    // en passant
                    if(tookThisTurn && board.pieces[newPos.getRow()][newPos.getColumn()]==null){
                        int epChange = whitesTurn ? -1 : 1;
                        // send en-passanted pawn into the abyss
                        board.pieces[newPos.getRow()+epChange][newPos.getColumn()] = null;
                        enPassantMade = "ep";
                        divider = "x";
                    }
                    // no en passant was made, if there was a piece taken use x and if not use -
                    if(enPassantMade.equals("")){
                        divider = tookThisTurn ? "x"+board.pieces[newPos.getRow()][newPos.getColumn()].toString() : "-";
                    }
                    
                    // if the pawn took another pawn, no need to include P
                    if(divider.equals("xP")) divider = "x";

                    // remove pawn from old position
                    board.pieces[p.getPos().getRow()][p.getPos().getColumn()] = null;
                    
                    // make promotions
                    if(move.contains("=")){
                        PieceImpl newPiece;
                        System.out.println(move);
                        char promoPiece = tookThisTurn ? move.charAt(4) : move.charAt(3);
                        switch(promoPiece){
                            case 'Q' -> newPiece = new Queen(p.isWhite(),p.getPos());
                            case 'N' -> newPiece = new Knight(p.isWhite(),p.getPos());
                            case 'R' -> newPiece = new Rook(p.isWhite(),p.getPos());
                            case 'B' -> newPiece = new Bishop(p.isWhite(),p.getPos());
                            default -> newPiece = p;
                        }
                        p = newPiece;
                        promo = "=" + promoPiece;
                    }else{
                        // set pawn moved (for calculating two-step moves)
                        Pawn p1 = (Pawn) p; p1.movedYet = true;
                    }

                    // set pawn to new position
                    board.pieces[newPos.getRow()][newPos.getColumn()] = p;
                    p.setPos(newPos);

                    // set correct move formatting
                    String c = check ? "+" : "";
                    c = mate ? "#" : c;
                    
                    return oldPos+divider+newPos.getStringPos()+enPassantMade+promo+c;
                }
            }
        }else{ // piece move
            return parsePieceMove(move,tookThisTurn,check,mate);
        }

        System.out.println("failed to parse pawn move: " + move);
        System.out.println(board.toString());
        
        return "failed pawn move parse";
    }
    public static String parsePieceMove(String move,boolean took,boolean check,boolean mate){

        String piece = move.substring(0,1);
        Position newPos;
        
        int uniqueColumn = 0;
        int uniqueRow = 0;
        // move possible from two different pieces
        // eg. Nbd7 Knight on B column moves to d7
        // eg. R1a3 Rook on first row moves to a3
        if(move.length()==4){
            char originalPosition = move.substring(1,2).charAt(0);
            // if the starting position is a row
            if(Character.isDigit(originalPosition)){
                uniqueRow = Integer.parseInt(move.substring(1,2));
            }else{
                uniqueColumn = charToColumn(move.substring(1,2).charAt(0));
            }
            newPos = new Position(Integer.parseInt(move.substring(3,4)),charToColumn(move.charAt(2)));
        }else{
            newPos = new Position(Integer.parseInt(move.substring(2,3)),charToColumn(move.charAt(1)));
        }

        for(PieceImpl p : board.getPiece(piece)){
            // only check pieces for the colour whose turn it is
            if((whitesTurn && !p.isWhite()) || !whitesTurn && p.isWhite()) continue;
            // if the move is a four-char move, only check pieces in the specified column/row

            if(uniqueColumn!=0 && p.getPos().getColumn() != uniqueColumn) continue;
            if(uniqueRow!=0 && p.getPos().getRow() != uniqueRow) continue;
            if(p.isValidMove(newPos, false, board)){
                String oldPos = p.getStringPos();
                String divider = took ? "x"+board.pieces[newPos.getRow()][newPos.getColumn()].toString() : "-";
                if(divider.equals("xP")) divider = "x";
                board.pieces[newPos.getRow()][newPos.getColumn()] = p;
                board.pieces[p.getPos().getRow()][p.getPos().getColumn()] = null;
                p.setPos(newPos);
                String c = check ? "+" : "";
                        c = mate ? "#" : c;
                return piece+oldPos+divider+newPos.getStringPos()+c;
            }
        }
        System.out.println("failed to parse piece move: " + move);
        System.out.println(board.toString());
        
        return "failed move parse";
    }

    // methods for different combobox modes
    public static void testContents(String inputText){
        convert(inputText);
        StringBuilder printout = new StringBuilder();
        printout.append("String input = ");
        Scanner s = new Scanner(output.toString());
        while(s.hasNext()){
            printout.append("\"");
            int i = 0;
            while(i < 5 || !s.hasNext()){
                if(!s.hasNext()) break;
                printout.append(s.next());
                if(!s.hasNext()) break;
                printout.append(" " + s.next()+"\\n");
                i++;
            }
            printout.append("\"+\n");
        }
        s.close();
        printout.append("\"\";\n");
        printout.append(board.toNeatString());
        printout.append("\ncheck(input,board);");
        GUI.output.setText(printout.toString());
    }
    public static void main(String args[]){
        new GUI();
    }
}