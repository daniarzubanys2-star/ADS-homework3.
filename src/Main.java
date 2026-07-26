import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstText = scanner.nextLine();
        String secondText = scanner.nextLine();

        if (firstText.length() != secondText.length()) {
            System.out.println("NO");
            return;
        }

        char[] firstCharacters = firstText.toCharArray();
        char[] secondCharacters = secondText.toCharArray();

        sortCharacters(firstCharacters, 0, firstCharacters.length - 1);
        sortCharacters(secondCharacters, 0, secondCharacters.length - 1);

        if (checkIdentical(firstCharacters, secondCharacters)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void sortCharacters(char[] characters, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitionIndex = partitionCharacters(characters, startIndex, endIndex);
            sortCharacters(characters, startIndex, partitionIndex - 1);
            sortCharacters(characters, partitionIndex + 1, endIndex);
        }
    }

    private static int partitionCharacters(char[] characters, int startIndex, int endIndex) {
        char pivot = characters[endIndex];
        int smallerIndex = startIndex - 1;

        for (int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) {
            if (characters[currentIndex] <= pivot) {
                smallerIndex++;
                swapCharacters(characters, smallerIndex, currentIndex);
            }
        }

        swapCharacters(characters, smallerIndex + 1, endIndex);
        return smallerIndex + 1;
    }

    private static void swapCharacters(char[] characters, int firstPosition, int secondPosition) {
        char temporary = characters[firstPosition];
        characters[firstPosition] = characters[secondPosition];
        characters[secondPosition] = temporary;
    }

    private static boolean checkIdentical(char[] firstArray, char[] secondArray) {
        for (int index = 0; index < firstArray.length; index++) {
            if (firstArray[index] != secondArray[index]) {
                return false;
            }
        }
        return true;
    }
}
