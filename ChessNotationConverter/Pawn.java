public class Pawn extends PieceImpl{

    public Pawn(boolean white,Position pos) {
        super(white,pos);
    }

    public boolean movedYet = false;

    @Override
    public String toString(){
        return "P";
    }

    @Override
    public boolean isValidMove(Position newPosition, boolean takes, Board board) {
        int reach = movedYet ? 1 : 2;
        if(!takes){
            return this.getPos().getColumn() == newPosition.getColumn() && Math.abs(this.getPos().getRow()-newPosition.getRow()) <= reach;
        }else{
            return Math.abs(this.getPos().getRow()-newPosition.getRow()) == 1 && Math.abs(this.getPos().getColumn()-newPosition.getColumn()) == 1;
        }
    }
    
}
