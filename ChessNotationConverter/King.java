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
        int diffCol = Math.max(this.getPos().column, newPosition.column)
				- Math.min(this.getPos().column, newPosition.column);
		int diffRow = Math.max(this.getPos().row, newPosition.row)
				- Math.min(this.getPos().row, newPosition.row);
		return (diffCol == 1 && diffRow == 0) | (diffRow ==1 && diffCol == 0) |
                (diffCol == 1 && diffRow == 1);
    }
    
}
