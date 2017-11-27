package com.sven.chess.model;

public class Rook extends Piece {

    public static final Rook INSTANCE = new Rook();
    
    private Rook() {
        
    }
	@Override
	public boolean isAttacked(final Position current, final Position target) {
		return current.getX() == target.getX() || current.getY() == target.getY();
	}

	@Override
	public String getName() {

		return "R";
	}

}
