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
        System.out.println(newPosition.toString() + " begets " + this.getPos().getRow());
        return this.getPos().getRow() == newPosition.getRow() | this.getPos().getColumn() == newPosition.getColumn() | this.diagonal(newPosition);
    }
}
