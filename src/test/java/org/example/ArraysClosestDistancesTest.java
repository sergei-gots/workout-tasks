package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class ArraysClosestDistancesTest {

    public static Stream<Arguments> prepareArrays() {
        return Stream.of(
                Arguments.of (
                        new int[] {1, 4, 10},
                        new int[] {2, 15, 20},
                        new int[] {10, 12},
                        new int[] {10, 10, 15 })
        );
    }

    @ParameterizedTest
    @MethodSource("prepareArrays")
    public void closest(int[] a, int[] b, int[] c, int[] expected) {
        ArraysClosestRoute arraysClosestDistances = new ArraysClosestRoute();
        int[] actual = arraysClosestDistances.closest(a, b, c);
        assertThat(actual).containsExactlyInAnyOrder(expected);
    }
}