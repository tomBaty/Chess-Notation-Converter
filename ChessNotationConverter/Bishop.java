public class Bishop extends PieceImpl{

    public Bishop(boolean white,Position pos) {
        super(white,pos);
    }

    @Override
    public String toString(){
        return "B";
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece isTaken, Board board) {
        return this.diagonal(newPosition);
    }
    
}

