package com.sven.chees.model;

import java.util.List;

public class AttackedPiece extends Piece {

	public static final AttackedPiece INSTANCE = new AttackedPiece();

	@Override
	public boolean isAttacked(Position current, Position target) {
		return false;
	}

	@Override
	public List<Position> controlledPositions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "_";
	}
}