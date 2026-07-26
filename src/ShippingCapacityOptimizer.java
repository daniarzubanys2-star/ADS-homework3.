import java.util.Scanner;

public class ShippingCapacityOptimizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int[] values = new int[arraySize];

        for (int index = 0; index < arraySize; index++) {
            values[index] = scanner.nextInt();
        }

        sortAscending(values, 0, values.length - 1);

        double median = computeMedian(values);

        if (median == (int) median) {
            System.out.println((int) median);
        } else {
            System.out.println(median);
        }
    }

    private static void sortAscending(int[] values, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitionIndex = partitionValues(values, startIndex, endIndex);
            sortAscending(values, startIndex, partitionIndex - 1);
            sortAscending(values, partitionIndex + 1, endIndex);
        }
    }

    private static int partitionValues(int[] values, int startIndex, int endIndex) {
        int pivot = values[endIndex];
        int smallerIndex = startIndex - 1;

        for (int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) {
            if (values[currentIndex] <= pivot) {
                smallerIndex++;
                swapValues(values, smallerIndex, currentIndex);
            }
        }

        swapValues(values, smallerIndex + 1, endIndex);
        return smallerIndex + 1;
    }

    private static void swapValues(int[] values, int firstPosition, int secondPosition) {
        int temporary = values[firstPosition];
        values[firstPosition] = values[secondPosition];
        values[secondPosition] = temporary;
    }

    private static double computeMedian(int[] sortedValues) {
        int middleIndex = sortedValues.length / 2;

        if (sortedValues.length % 2 == 1) {
            return sortedValues[middleIndex];
        } else {
            return (sortedValues[middleIndex - 1] + sortedValues[middleIndex]) / 2.0;
        }
    }
}