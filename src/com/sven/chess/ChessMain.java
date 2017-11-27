package com.sven.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sven.chess.model.Bishop;
import com.sven.chess.model.ChessBoard;
import com.sven.chess.model.ChessLayout;
import com.sven.chess.model.King;
import com.sven.chess.model.Knight;
import com.sven.chess.model.Piece;
import com.sven.chess.model.Queen;

public class ChessMain
{

    public static void main(final String[] args)
    {

        long curr = System.currentTimeMillis();
        boolean isDebugEnabled = false;
        

//        ChessBoard chessBoard =
//                new ChessBoard(3, 3,
//                        Arrays.asList(King.INSTANCE, King.INSTANCE, Rook.INSTANCE));

//        ChessBoard chessBoard =
//                new ChessBoard(4, 4,
//                        Arrays.asList(Rook.INSTANCE, Rook.INSTANCE, Knight.INSTANCE,
//                                Knight.INSTANCE, Knight.INSTANCE, Knight.INSTANCE));
        
        ChessBoard chessBoard =
                new ChessBoard(7, 7,
                        Arrays.asList(King.INSTANCE, King.INSTANCE, Queen.INSTANCE,
                                Queen.INSTANCE, Bishop.INSTANCE, Bishop.INSTANCE, Knight.INSTANCE));

        List<List<Piece>> permutations = new ArrayList<>();
        getPermutations(permutations, new ArrayList<Piece>(), chessBoard.getPieces());

        System.out.println(String.format("found %s permutations", permutations.size()));
        if (isDebugEnabled)
        {

            for (List<Piece> permutation : permutations)
            {
                String str = permutation.stream().map(s -> s.getName()).collect(
                        Collectors.joining());
                System.out.println(str);
            }
        }

        // place piece to board
        int total = 0;
        int index = 0;
        for (List<Piece> permutation : permutations)
        {
            System.out.println(String.format("permutation[%s] ...", index++));
            ChessLayout layout = new ChessLayout(chessBoard, permutation);
            List<Map<Integer, Piece>> result = layout.getAllResult();
            if (isDebugEnabled) {
            result.forEach(s -> {
                layout.print(s);
                System.out.println("");
                System.out.println("------------------------");
            });
            }
            total += result.size();
        }
        System.out.println(String.format("total: %s in %s secs", total, (System.currentTimeMillis() - curr) / 1000));
    }

    public static <T> void getPermutations(final List<List<T>> permutations,
            final List<T> collection, final List<T> distribution)
    {

        if (distribution.size() == 0)
            permutations.add(collection);
        else
        {

            List<T> distinctedDistribution =
                    distribution.stream().distinct().collect(Collectors.toList());

            for (int i = 0; i < distinctedDistribution.size(); i++)
            {

                List<T> subCollection = new ArrayList<T>(collection);
                List<T> subSistribution = new ArrayList<T>(distribution);

                T t = distinctedDistribution.get(i);
                subCollection.add(t);
                subSistribution.remove(t);

                getPermutations(permutations, subCollection, subSistribution);
            }
        }
    }
}
