package com.sven.chess.model;

public class Queen extends Piece
{

    public static final Queen INSTANCE = new Queen();

    @Override
    public boolean isAttacked(final Position current, final Position target)
    {

        return current.getX() == target.getX() || current.getY() == target.getY()
                || Math.abs(current.getX() - target.getX()) == Math.abs(
                        current.getY() - target.getY());
    }

    @Override
    public String getName()
    {
        return "Q";
    }

}
