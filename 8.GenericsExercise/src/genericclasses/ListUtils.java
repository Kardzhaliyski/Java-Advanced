package genericclasses;

import java.util.List;

public class ListUtils  {

    public ListUtils() {

    }

    public static <T> void swapElements(List<T> list, int index1, int index2) {
        if(index1 > list.size() - 1 || index1 < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds for " + index1);
        } else if (index2 > list.size() -1 || index2 < 0 ) {
            throw new IndexOutOfBoundsException("Index out of bounds for " + index2);
        }

        T tempElement = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, tempElement);
    }

    public static <T extends Comparable<T>> int countGreaterElements(List<T> list, T element) {
        int count = 0;
        for (T t : list) {
            if(element.compareTo(t) < 0) {
                count++;
            }
        }

        return count;
    }
}
