public class King extends PieceImpl{

    public King(boolean white,Position pos) {
        super(white,pos);
    }

    @Override
    public String toString(){
        return "K";
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece isTaken, Board board) {
        int diffCol = Math.max(this.getPos().getColumn(), newPosition.getColumn())
				- Math.min(this.getPos().getColumn(), newPosition.getColumn());
		int diffRow = Math.max(this.getPos().getRow(), newPosition.getRow())
				- Math.min(this.getPos().getRow(), newPosition.getRow());
		return (diffCol == 1 && diffRow == 0) | (diffRow ==1 && diffCol == 0) |
                (diffCol == 1 && diffRow == 1);
    }
    
}
