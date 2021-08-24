public class Pawn extends PieceImpl{

    public Pawn(boolean white,Position pos) {
        super(white,pos);
    }

    @Override
    public String toString(){
        return "P";
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece isTaken, Board board) {
        if(isTaken==null){
            return this.getPos().getColumn() == newPosition.getColumn() && Math.abs(this.getPos().getRow()-newPosition.getRow()) <= 2;
        }else{
            return Math.abs(this.getPos().getRow()-newPosition.getRow()) == 1 && Math.abs(this.getPos().getColumn()-newPosition.getColumn()) == 1;
        }
    }
    
}
