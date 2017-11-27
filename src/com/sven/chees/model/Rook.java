package com.sven.chees.model;

import java.util.List;

public class Rook extends Piece {

	@Override
	public boolean isAttacked(Position current, Position target) {
		return current.getX() == target.getX() || current.getY() == target.getY();
	}

	@Override
	public List<Position> controlledPositions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {

		return "R";
	}

}
