package src;
public class Queen extends PieceImpl{

    public Queen(boolean white,Position pos) {
        super(white,pos);
    }

    @Override
    public String toString(){
        return "Q";
    }

    @Override
    public boolean isValidMove(Position newPosition, boolean takes, Board board) {
        return this.getPos().getRow() == newPosition.getRow() | this.getPos().getColumn() == newPosition.getColumn() | this.diagonal(newPosition);
    }
}
