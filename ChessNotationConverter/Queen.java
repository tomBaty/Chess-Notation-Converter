public class Queen extends PieceImpl{

    public Queen(boolean white,Position pos) {
        super(white,pos);
    }

    @Override
    public String toString(){
        return "Q";
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece isTaken, Board board) {
        return this.getPos().row == newPosition.row | this.getPos().column == newPosition.column |
        this.diagonal(newPosition);
    }
    
}
