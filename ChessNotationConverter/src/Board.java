package src;

import java.util.List;
import java.util.ArrayList;

public class Board {

    public PieceImpl[][] pieces;
    public Board board;

    public Board(){

        this.pieces = new PieceImpl[9][9];
        // rooks
        pieces[1][1] = new Rook(true,new Position(1,1));
        pieces[1][8] = new Rook(true,new Position(1,8));
        pieces[8][1] = new Rook(false,new Position(8,1));
        pieces[8][8] = new Rook(false,new Position(8,8));

        // knights
        pieces[1][2] = new Knight(true,new Position(1,2));
        pieces[1][7] = new Knight(true,new Position(1,7));
        pieces[8][2] = new Knight(false,new Position(8,2));
        pieces[8][7] = new Knight(false,new Position(8,7));

        // bishops
        pieces[1][3] = new Bishop(true,new Position(1,3));
        pieces[1][6] = new Bishop(true,new Position(1,6));
        pieces[8][3] = new Bishop(false,new Position(8,3));
        pieces[8][6] = new Bishop(false,new Position(8,6));

        // king + queen
        pieces[1][4] = new Queen(true,new Position(1,4));
        pieces[1][5] = new King(true,new Position(1,5));
        pieces[8][4] = new Queen(false,new Position(8,4));
        pieces[8][5] = new King(false,new Position(8,5));

        for(int i = 0; i < 9; i ++){
            pieces[2][i] = new Pawn(true,new Position(2,i));
            pieces[7][i] = new Pawn(false,new Position(7,i));
        }

        board = this;
    }
    
    public List<PieceImpl> getPiece(String piece){
        List<PieceImpl> matches = new ArrayList<>();
        for(int i = 1; i < 9; i ++){
            for(int j = 1; j < 9; j ++){
                if(pieces[i][j]!=null){
                    if(pieces[i][j].toString().equals(piece)){
                        matches.add(pieces[i][j]);
                    }
                }
            }
        }
        return matches;
        // return Arrays.stream(pieces).flatMap(x -> Arrays.stream(x)).filter(x -> x.toString().equals(piece)).collect(Collectors.toList());
    }

    public PieceImpl pieceAt(int row,int column){
        return pieces[row][column];
    }

    public String toString(){
        StringBuilder b = new StringBuilder();
        for(int i = 8; i > 0; i --){
            for(int j = 1; j < 9; j ++){
                b.append("|");
                if(pieces[i][j] == null){
                    b.append("_");
                }else{
                    Piece piece = pieces[i][j];
                    String p = piece.isWhite() ? piece.toString() : piece.toString().toLowerCase();
                    b.append(p);
                }
            }
            b.append("|\n");
        }
        return b.toString();
    }
    public String toNeatString(){
        StringBuilder b = new StringBuilder();
        b.append("String board =  ");
        for(int i = 8; i > 0; i --){
            b.append("\"" + i);
            for(int j = 1; j < 9; j ++){
                b.append("|");
                if(pieces[i][j] == null){
                    b.append("_");
                }else{
                    Piece piece = pieces[i][j];
                    String p = piece.isWhite() ? piece.toString() : piece.toString().toLowerCase();
                    b.append(p);
                }
            }
            b.append("|\\n\"+\n");
        }
        b.append("\"  a b c d e f g h\";");
        return b.toString();
    }

}
