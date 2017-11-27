package com.sven.chess.model;

import java.util.ArrayList;
import java.util.List;

public class EmptyPiece extends Piece {

	public static final EmptyPiece INSTANCE = new EmptyPiece();

	@Override
	public boolean isAttacked(final Position current, final Position target) {
		return false;
	}


	@Override
	public String getName() {
		return "_";
	}

    @Override
    public List<Position> getControlledPositions(final Position current, final ChessBoard board)
    {
        return new ArrayList<>();
    }
}