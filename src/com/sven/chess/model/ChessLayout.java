package com.sven.chess.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessLayout
{

    private ChessBoard board;
    private List<Map<Integer, Piece>> result = new ArrayList<>();
    private List<Piece> permutation;
    private int total = 0;

    public ChessLayout(final ChessBoard board, final List<Piece> permutation)
    {
        this.board = board;
        this.permutation = permutation;
        total = board.getHeight() * board.getWidth();
    }

    public List<Map<Integer, Piece>> getAllResult()
    {

        Map<Integer, Piece> layout = new HashMap<>();
        for (int i = 0; i < total; i++)
        {
            layout.put(i, EmptyPiece.INSTANCE);
        }
        this.placeAll(layout, permutation, 0);
        return result;
    }

    public void placeAll(final Map<Integer, Piece> layout, final List<Piece> permutation,
            final int offset)
    {

        if (permutation.isEmpty())
        {

            // found a solution;
            result.add(layout);
            return;
        }

        List<Piece> subPermutation = new ArrayList<>(permutation);
        Piece piece = subPermutation.remove(0);

        for (int i = offset; i < total; i++)
        {

            if (this.isPlaceable(i, layout, piece))
            {

                Map<Integer, Piece> subLayout = new HashMap<>(layout);

                this.place(piece, subLayout, i);
                this.placeAll(subLayout, subPermutation, i + 1);
            }
        }
    }

    public int getOffset(final Position position)
    {
        return position.getY() * board.getHeight() + position.getX();
    }

    public Position getPosition(final int offset)
    {
        return new Position(offset % board.getHeight(), offset / board.getHeight());
    }

    public boolean isPlaceable(final int offset, final Map<Integer, Piece> layout,
            final Piece piece)
    {

        if (layout.get(offset) != EmptyPiece.INSTANCE) {
            return false;
        }
        
        List<Position> positions =
                piece.getControlledPositions(getPosition(offset), board);
        boolean isPlaceable = !positions.stream().filter(s -> {

            int o = getOffset(s);
            return !(layout.get(o) instanceof EmptyPiece);

        }).findAny().isPresent();

        return isPlaceable;
    }

    public void place(final Piece piece, final Map<Integer, Piece> layout,
            final int offset)
    {
        layout.put(offset, piece);

        List<Position> positions =
                piece.getControlledPositions(getPosition(offset), board);
        positions.forEach(s -> {

            int o = getOffset(s);
            if (layout.get(o) == EmptyPiece.INSTANCE)
            {
                layout.put(o, AttackedPiece.INSTANCE);
            }
        });
    }

    public void print(final Map<Integer, Piece> layout)
    {
        for (int i = 0; i < total; i++)
        {

            if (i % board.getWidth() == 0)
            {
                System.out.println("");
            }
            System.out.print(layout.get(i).getName());
        }
    }
}
