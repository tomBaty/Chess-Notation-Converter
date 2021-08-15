import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    public static Piece[][] pieces = new Piece[9][9];

    public Board(){
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
        pieces[8][5] = new King(false,new Position(8,4));
    }
    
    public List<Piece> getPiece(Piece piece){
        return Arrays.stream(pieces).flatMap(x -> Arrays.stream(x)).filter(x -> x.toString().equals(piece.toString())).map(x -> (Piece) x).collect(Collectors.toList());
    }

    public Piece pieceAt(int row,int column){
        return pieces[row][column];
    }

}
