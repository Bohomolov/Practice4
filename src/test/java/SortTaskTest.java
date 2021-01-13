import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SortTaskTest {
    private final SortTask sortTask;

    public SortTaskTest() {
        sortTask = new SortTask();
    }

    //====================================Sort Test=============================================
    static Stream<Arguments> bubbleSortTest() {
        int[] arrayInt_1 = {0, 0};
        int[] arrayInt_1_exp = {0, 0};
        int[] arrayInt_2 = {1, 0};
        int[] arrayInt_2_exp = {0, 1};
        int[] arrayInt_3 = {5, 6, 8, 3};
        int[] arrayInt_3_exp = {3, 5, 6, 8};
        int[] arrayInt_4 = {-1, 5, 9, 10};
        int[] arrayInt_4_exp = {-1, 5, 9, 10};
        int[] arrayInt_5 = {90, -80, 30, 55};
        int[] arrayInt_5_exp = {-80, 30, 55, 90};
        int[] arrayInt_6 = {-1, -8, -9, -22, 0};
        int[] arrayInt_6_exp = {-22, -9, -8, -1, 0};
        return Stream.of(
                arguments(arrayInt_1, arrayInt_1_exp),
                arguments(arrayInt_2, arrayInt_2_exp),
                arguments(arrayInt_3, arrayInt_3_exp),
                arguments(arrayInt_4, arrayInt_4_exp),
                arguments(arrayInt_5, arrayInt_5_exp),
                arguments(arrayInt_6, arrayInt_6_exp)
        );
    }

    @ParameterizedTest(name = "Bubble sort. Input data is {0}, {1} ")
    @MethodSource("bubbleSortTest")
    void bubbleSortTest_1(int[] intArray, int[] expected) {
        int[] actual = sortTask.bubbleSort(intArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBubbleSort_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sortTask.bubbleSort(null);
        }, "Array cannot be is empty.");
    }

    //====================================Binary Search Test=============================================
    static Stream<Arguments> binarySearchTest() {
        int[] arrayInt_1 = {0, 0};
        int[] arrayInt_2 = {1, 0};
        int[] arrayInt_3 = {5, 6, 8, 3};
        int[] arrayInt_4 = {-1, 5, 9, 10};
        int[] arrayInt_5 = {90, -80, 30, 55};
        int[] arrayInt_6 = {-1, -8, -9, -22, 0};
        int[] arrayInt_7 = {-1, -8, -9, -22, 0, 88, 95, 13, 17, 3, 7, 8};
        return Stream.of(
                arguments(arrayInt_1, 0, 0),
                arguments(arrayInt_2, 1, 2),
                arguments(arrayInt_3, 8, 8),
                arguments(arrayInt_4, 10, 11),
                arguments(arrayInt_5, 30, 30),
                arguments(arrayInt_6, -9, -9),
                arguments(arrayInt_7, 0, 1)
        );
    }

    @ParameterizedTest(name = "binary Search Test. Input data is {0}, {1},{2} ")
    @MethodSource("binarySearchTest")
    void binarySearchTest_1(int[] intArray, int expected, int searched) {
        int actual = sortTask.binarySearch(intArray, searched);
        assertEquals(expected, actual);
    }
}
