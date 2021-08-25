public class Knight extends PieceImpl{

    public Knight(boolean white,Position pos) {
        super(white,pos);
    }

    @Override
    public String toString(){
        return "N";
    }

    @Override
    public boolean isValidMove(Position newPosition, boolean takes, Board board) {
        int diffCol = Math.max(this.getPos().getColumn(), newPosition.getColumn())
				- Math.min(this.getPos().getColumn(), newPosition.getColumn());
		int diffRow = Math.max(this.getPos().getRow(), newPosition.getRow())
				- Math.min(this.getPos().getRow(), newPosition.getRow());
		return ((diffCol == 2 && diffRow == 1) || (diffCol == 1 && diffRow == 2));
    }
    
}
