package src;
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
        // check that there isn't a piece in the way of a double move
        int ahead = this.isWhite() ? 1 : -1;
        Position p = this.getPos();
        boolean clearSpaceAhead = board.pieceAt(p.getRow() + ahead,p.getColumn()) == null;
        // if it has already moved, it can only move one square
        int reach = movedYet ? 1 : 2;
        // if there's a piece in front of it, it can't move anywhere
        if(reach == 2 && !clearSpaceAhead) reach = 0;

        int rowDiff = p.getRow()-newPosition.getRow();
        if(!takes){
            return this.getPos().getColumn() == newPosition.getColumn() && Math.abs(rowDiff) <= reach && (this.isWhite() ? rowDiff < 0 : rowDiff > 0);
        }else{
            return Math.abs(this.getPos().getRow()-newPosition.getRow()) == 1 && Math.abs(this.getPos().getColumn()-newPosition.getColumn()) == 1;
        }
    }
    
}
