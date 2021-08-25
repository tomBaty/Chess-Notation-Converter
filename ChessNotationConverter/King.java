public class King extends PieceImpl{

    public King(boolean white,Position pos) {
        super(white,pos);
    }

    @Override
    public String toString(){
        return "K";
    }

    @Override
    public boolean isValidMove(Position newPosition, boolean takes, Board board) {
        int diffCol = Math.abs(this.getPos().getColumn() - newPosition.getColumn());
		int diffRow = Math.abs(this.getPos().getRow() - newPosition.getRow());
		return (diffCol == 1 && diffRow == 0) | (diffRow ==1 && diffCol == 0) |
                (diffCol == 1 && diffRow == 1);
    }
    
}
