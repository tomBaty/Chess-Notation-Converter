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
        p.append(Chess.columns[pos.getColumn()-1]);
        p.append(pos.getRow());
        return p.toString();
    }

    public boolean diagonal(Position newPos){
        int startCol = this.getPos().getColumn();
		int endCol = newPos.getColumn();
		int startRow = this.getPos().getRow();
		int endRow = newPos.getRow();
		int diffCol = Math.abs(startCol-endCol);
		int diffRow = Math.abs(startRow-endRow);

        System.out.println(diffCol + " " + diffRow);

		if(diffCol != diffRow || diffCol == 0) {
            System.out.println("bad diag");
			return false;
		}
        return true;
    }
    
    public PieceImpl(boolean white, Position pos){
        this.pos = pos;
        this.white = white;
    }
    
}
