import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int packagesCount = scanner.nextInt();
        int[] weights = new int[packagesCount];

        for (int index = 0; index < packagesCount; index++) {
            weights[index] = scanner.nextInt();
        }

        int shippingDays = scanner.nextInt();

        int minimumCapacity = calculateMinimumCapacity(weights, shippingDays);
        System.out.println(minimumCapacity);
    }

    private static int calculateMinimumCapacity(int[] weights, int shippingDays) {
        int lowerBound = findMaximumWeight(weights);
        int upperBound = calculateTotalWeight(weights);

        while (lowerBound < upperBound) {
            int middleCapacity = lowerBound + (upperBound - lowerBound) / 2;

            if (canShipWithinDays(weights, middleCapacity, shippingDays)) {
                upperBound = middleCapacity;
            } else {
                lowerBound = middleCapacity + 1;
            }
        }

        return lowerBound;
    }

    private static boolean canShipWithinDays(int[] weights, int truckCapacity, int maxDays) {
        int requiredDays = 1;
        int currentDayLoad = 0;

        for (int packageWeight : weights) {
            if (currentDayLoad + packageWeight <= truckCapacity) {
                currentDayLoad += packageWeight;
            } else {
                requiredDays++;
                currentDayLoad = packageWeight;

                if (requiredDays > maxDays) {
                    return false;
                }
            }
        }

        return requiredDays <= maxDays;
    }

    private static int findMaximumWeight(int[] weights) {
        int maximum = weights[0];
        for (int index = 1; index < weights.length; index++) {
            if (weights[index] > maximum) {
                maximum = weights[index];
            }
        }
        return maximum;
    }

    private static int calculateTotalWeight(int[] weights) {
        int total = 0;
        for (int weight : weights) {
            total += weight;
        }
        return total;
    }
}