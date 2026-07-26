import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int[] numbers = new int[arraySize];

        for (int index = 0; index < arraySize; index++) {
            numbers[index] = scanner.nextInt();
        }

        int targetOrder = scanner.nextInt();

        sortAscending(numbers, 0, numbers.length - 1);

        int kthSmallest = extractKthElement(numbers, targetOrder);
        System.out.println(kthSmallest);
    }

    private static void sortAscending(int[] numbers, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitionIndex = partitionNumbers(numbers, startIndex, endIndex);
            sortAscending(numbers, startIndex, partitionIndex - 1);
            sortAscending(numbers, partitionIndex + 1, endIndex);
        }
    }

    private static int partitionNumbers(int[] numbers, int startIndex, int endIndex) {
        int pivot = numbers[endIndex];
        int smallerIndex = startIndex - 1;

        for (int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) {
            if (numbers[currentIndex] <= pivot) {
                smallerIndex++;
                swapNumbers(numbers, smallerIndex, currentIndex);
            }
        }

        swapNumbers(numbers, smallerIndex + 1, endIndex);
        return smallerIndex + 1;
    }

    private static void swapNumbers(int[] numbers, int firstPosition, int secondPosition) {
        int temporary = numbers[firstPosition];
        numbers[firstPosition] = numbers[secondPosition];
        numbers[secondPosition] = temporary;
    }

    private static int extractKthElement(int[] sortedNumbers, int targetOrder) {
        return sortedNumbers[targetOrder - 1];
    }
}