package com.sven.chees.model;

import java.util.List;

public class King extends Piece {

	@Override
	public boolean isAttacked(Position current, Position target) {
		return Math.abs(current.getX() - target.getX()) <= 1 && Math.abs(current.getY() - target.getY()) <= 1;
	}

	@Override
	public List<Position> controlledPositions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {

		return "K";
	}

}
