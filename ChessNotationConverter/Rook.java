public class Rook extends PieceImpl{

    public Rook(boolean white,Position pos) {
        super(white,pos);
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece isTaken, Board board) {
        return this.getPos().getRow() == newPosition.getRow() | this.getPos().getColumn() == newPosition.getColumn();
    }
    
}
