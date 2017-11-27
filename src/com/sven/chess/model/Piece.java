package com.sven.chess.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

	public abstract boolean isAttacked(Position current, Position target);

    public List<Position> getControlledPositions(final Position current, final ChessBoard board)
    {
        List<Position> positions = new ArrayList<>();
        for (int y = 0; y < board.getHeight(); y++) {
            
            for (int x = 0; x < board.getWidth(); x++) {
                
                Position target = new Position(x, y);
                if (this.isAttacked(current, target)) {
                    positions.add(target);
                }
            }
        }
        return positions;
    }

	public abstract String getName();

}
