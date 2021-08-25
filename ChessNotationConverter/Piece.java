public interface Piece {

	public boolean isWhite();
	public boolean isValidMove(Position newPosition, boolean takes, Board board);	

}
