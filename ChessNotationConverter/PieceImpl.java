public abstract class PieceImpl implements Piece{

    private Position pos;
    private boolean white;
    public Position getPos() {
        return pos;
    }
    public void setPos(Position pos) {
        this.pos = pos;
    }
    public boolean isWhite() {
        return white;
    }
    public void setWhite(boolean white) {
        this.white = white;
    }
    public String getStringPos(){
        StringBuilder p = new StringBuilder();
        p.append(Chess.columns[pos.column]);
        p.append(pos.row);
        return p.toString();
    }

    public boolean diagonal(Position newPos){
        int startCol = pos.column;
		int endCol = newPos.column;
		int startRow = pos.row;
		int endRow = newPos.row;
		int diffCol = Math.max(startCol,endCol) - Math.min(startCol,endCol);
		int diffRow = Math.max(startRow,endRow) - Math.min(startRow,endRow);

		if(diffCol != diffRow || diffCol == 0) {
			return false;
		}
        return true;
    }
    
    public PieceImpl(boolean white, Position pos){
        this.pos = pos;
        this.white = white;
    }
    
}
