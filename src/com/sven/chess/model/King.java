package com.sven.chess.model;

public class King extends Piece
{

    public static final King INSTANCE = new King();

    private King(){
        
    }
    @Override
    public boolean isAttacked(final Position current, final Position target)
    {
        return Math.abs(current.getX() - target.getX()) <= 1
                && Math.abs(current.getY() - target.getY()) <= 1;
    }

    @Override
    public String getName()
    {

        return "K";
    }

}
