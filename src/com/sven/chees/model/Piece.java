package com.sven.chees.model;

import java.util.List;

public abstract class Piece {

	public abstract boolean isAttacked(Position current, Position target);

	public abstract List<Position> controlledPositions();

	public abstract String getName();

}
