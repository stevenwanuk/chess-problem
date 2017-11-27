package com.sven.chess.model;

public class Knight extends Piece
{
    public static final Knight INSTANCE = new Knight();

    @Override
    public boolean isAttacked(final Position current, final Position target)
    {
        // L movement
        int dx = Math.abs(current.getX() - target.getX());
        int dy = Math.abs(current.getY() - target.getY());

        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    @Override
    public String getName()
    {
        return "N";
    }
}
