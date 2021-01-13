import utils.Constants;

public class SortTask {
    public int[] bubbleSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException(Constants.ARRAY_CANNOT_BE_EMPTY);
        }
        for (int i = array.length; i > 0; i--) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
        return array;
    }

    public int binarySearch(int[] intArray, int searchedNumber) {
      
        bubbleSort(intArray);
        int firstIndex = 0;
        int lastIndex = intArray.length - 1;
        int indexOutput = 0;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (intArray[middleIndex] == searchedNumber) {
                return intArray[middleIndex];
            } else if (intArray[middleIndex] < searchedNumber) {
                firstIndex = middleIndex + 1;
            } else if (intArray[middleIndex] > searchedNumber) {
                lastIndex = middleIndex - 1;
            }
            indexOutput = middleIndex;
        }
        int result = intArray[indexOutput];
        return result;
    }

}
