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
            return this.getPos().column == newPosition.column && Math.abs(this.getPos().row-newPosition.row) <= 2;
        }else{
            return Math.abs(this.getPos().row-newPosition.row) == 1 && Math.abs(this.getPos().column-newPosition.column) == 1;
        }
    }
    
}
