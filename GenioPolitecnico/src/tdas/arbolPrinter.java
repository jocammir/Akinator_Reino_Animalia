
package tdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class arbolPrinter {

    public static <T extends Comparable<T>> void printNode(nodoAB<T> root) {
        int maxLevel = arbolPrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<nodoAB<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || arbolPrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        arbolPrinter.printWhitespaces(firstSpaces);

        List<nodoAB<T>> newNodes = new ArrayList<nodoAB<T>>();
        for (nodoAB<T> node : nodes) {
            if (node != null) {
                System.out.print(node.getContenido());
                newNodes.add(node.getIzq());
                newNodes.add(node.getDer());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            arbolPrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                arbolPrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    arbolPrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getIzq() != null)
                    System.out.print("/");
                else
                    arbolPrinter.printWhitespaces(1);

                arbolPrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).getDer() != null)
                    System.out.print("\\");
                else
                    arbolPrinter.printWhitespaces(1);

                arbolPrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(nodoAB<T> node) {
        if (node == null)
            return 0;

        return Math.max(arbolPrinter.maxLevel(node.getIzq()), arbolPrinter.maxLevel(node.getDer())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}