package org.example;

/**
 * Класс должен реализовать метод,
 * принимающий на вход 3 массива и
 * возвращающий массив с тремя числами -
 * по одному из каждого переданного массива,
 * которые образуют минимальный по размеру из возможных диапазонов,
 * а третье число находилось бы внутри этого диапазона включительно ЕСЛИ ТАКОЕ ЧИСЛО СУЩЕСТВУЕТ (поправка Гоца)
 * Порядок вывода числе не принципиален
 * <p>
 * int[] closest(int[] a, int[] b, int[] c) :
 * // a = {1, 4, 10};
 * // b = {2, 15, 20};
 * // c = {10, 12};
 * // result = {10, 15, 10} - ДОЛЖНО БЫТЬ result = {10, 15, 12} - ГОЦ
 * <p>
 * <p>
 * // a = {20, 24, 99};
 * // b = {2, 19, 22, 79, 122};
 * // c = {10, 12, 23, 24, 911, 912};
 * // result = {24, 22, 23}
 **/
public class ArraysClosestRoute {

    public int[] closest(int[] a, int[] b, int[] c) {

        int[] result = new int[3];

        long distanceMin = Integer.MAX_VALUE * 2L;

        for(int ai: a) {
            for(int bj: b) {
                int currentMax = Math.max(ai, bj);
                int currentMin = Math.min(ai, bj);
                int distanceAiBj = currentMax - currentMin;

                if (distanceAiBj > distanceMin) {
                    continue;
                }

                for(int ck: c) {
                    int distance = distanceAiBj;
                    if (ck < currentMin) {
                        distance =  currentMax - ck;
                    }
                    else if (ck > currentMax) {
                        distance =  ck - currentMin;
                    }
                    //check if this third number is distinctive to all the existing numbers within the found minimal range
                    else if (ck != result[2] && ck != result[0] && ck != result[1]) {
                        result[2] = ck;
                        distanceMin = distance;
                    }
                    if (distance < distanceMin) {
                        distanceMin = distance;
                        result[0] = ai;
                        result[1] = bj;
                        result[2] = ck;
                    }
                }
            }
        }
        return result;
    }
}
