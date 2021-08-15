public class Knight extends PieceImpl{

    public Knight(boolean white,Position pos) {
        super(white,pos);
    }

    @Override
    public String toString(){
        return "N";
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece isTaken, Board board) {
        // Code taken from SWEN221 project, author DJP
        int diffCol = Math.max(this.getPos().column, newPosition.column)
				- Math.min(this.getPos().column, newPosition.column);
		int diffRow = Math.max(this.getPos().row, newPosition.row)
				- Math.min(this.getPos().row, newPosition.row);
		return ((diffCol == 2 && diffRow == 1) || (diffCol == 1 && diffRow == 2));
    }
    
}
