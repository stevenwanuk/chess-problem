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

        // ChessBoard chessBoard =
        // new ChessBoard(3, 3,
        // Arrays.asList(King.INSTANCE, King.INSTANCE, Rook.INSTANCE));

        // ChessBoard chessBoard =
        // new ChessBoard(4, 4,
        // Arrays.asList(Rook.INSTANCE, Rook.INSTANCE, Knight.INSTANCE,
        // Knight.INSTANCE, Knight.INSTANCE, Knight.INSTANCE));

        ChessBoard chessBoard =
                new ChessBoard(7, 7,
                        Arrays.asList(King.INSTANCE, King.INSTANCE, Queen.INSTANCE,
                                Queen.INSTANCE, Bishop.INSTANCE, Bishop.INSTANCE,
                                Knight.INSTANCE));

        List<List<Piece>> permutations = new ArrayList<>();
        getPermutations(permutations, new ArrayList<Piece>(), chessBoard.getPieces());

        List<String> subSymmetry = new ArrayList<>();
        List<String> subNoSymmetry = new ArrayList<>();

        List<String> ps =
                permutations.stream().map(s -> s.stream().map(t -> t.getName()).collect(
                        Collectors.joining())).sorted().collect(Collectors.toList());
        ;

        ps.stream().forEach(s -> {

            String rs = new StringBuffer(s).reverse().toString();
            if (!subSymmetry.contains(rs) && !subSymmetry.contains(s)
                    && !subNoSymmetry.contains(rs) && !subNoSymmetry.contains(s))
            {
                if (rs.equalsIgnoreCase(s))
                {
                    subSymmetry.add(s);
                }
                else
                {
                    subNoSymmetry.add(s);
                }

            }
        });

        List<List<Piece>> subSymmetryPermutations = permutations.stream().filter(s -> subSymmetry.contains(
                s.stream().map(j -> j.getName()).collect(Collectors.joining()))).collect(
                        Collectors.toList());
        
        List<List<Piece>> subNoSymmetryPermutations = permutations.stream().filter(s -> subNoSymmetry.contains(
                s.stream().map(j -> j.getName()).collect(Collectors.joining()))).collect(
                        Collectors.toList());
        System.out.println("sub permutations:" + subNoSymmetryPermutations.size() + subSymmetryPermutations.size());
        
        if (isDebugEnabled)
        {

            for (List<Piece> permutation : subNoSymmetryPermutations)
            {
                String str = permutation.stream().map(s -> s.getName()).collect(
                        Collectors.joining());
                System.out.println(str);
            }
            
            for (List<Piece> permutation : subSymmetryPermutations)
            {
                String str = permutation.stream().map(s -> s.getName()).collect(
                        Collectors.joining());
                System.out.println(str);
            }
        }

        // place piece to board
        int totalSymmetry = 0;
        int totalNoSymmetry = 0;
        int index = 0;
        for (List<Piece> permutation : subSymmetryPermutations)
        {
            System.out.println(String.format("subSymmetry[%s] ...", index++));
            ChessLayout layout = new ChessLayout(chessBoard, permutation);
            List<Map<Integer, Piece>> result = layout.getAllResult();
            if (isDebugEnabled)
            {
                result.forEach(s -> {
                    layout.print(s);
                    System.out.println("");
                    System.out.println("------------------------");
                });
            }
            totalSymmetry += result.size();
        }
        
        for (List<Piece> permutation : subNoSymmetryPermutations)
        {
            System.out.println(String.format("subNoSymmetry[%s] ...", index++));
            ChessLayout layout = new ChessLayout(chessBoard, permutation);
            List<Map<Integer, Piece>> result = layout.getAllResult();
            if (isDebugEnabled)
            {
                result.forEach(s -> {
                    layout.print(s);
                    System.out.println("");
                    System.out.println("------------------------");
                });
            }
            totalNoSymmetry += result.size();
        }
        System.out.println(String.format("total: %s in %s secs", totalSymmetry + totalNoSymmetry * 2,
                (System.currentTimeMillis() - curr) / 1000));
    }

    public static List<List<Piece>> filter(final List<List<Piece>> permutations)
    {

        List<String> ps =
                permutations.stream().map(s -> s.stream().map(t -> t.getName()).collect(
                        Collectors.joining())).sorted().collect(Collectors.toList());
        ;

        List<String> rps = new ArrayList<String>();
        ps.stream().forEach(s -> {

            String rs = new StringBuffer(s).reverse().toString();
            if (!rps.contains(rs) && !rps.contains(s))
            {
                rps.add(s);
            }
        });

        List<List<Piece>> sub = permutations.stream().filter(s -> rps.contains(
                s.stream().map(j -> j.getName()).collect(Collectors.joining()))).collect(
                        Collectors.toList());
        System.out.println("sub permutations:" + sub.size());
        return sub;
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
