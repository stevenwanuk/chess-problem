package com.sven.chess.model;

public class Bishop extends Piece
{

    public static final Bishop INSTANCE = new Bishop();
    
    @Override
    public boolean isAttacked(final Position current, final Position target)
    {
        return Math.abs(current.getX() - target.getX()) == Math.abs(
                current.getY() - target.getY());
    }

    @Override
    public String getName()
    {
        return "B";
    }

}
