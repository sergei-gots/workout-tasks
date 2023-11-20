package org.example;


import java.util.Arrays;


/**
 * Задача
 * <p>
 * <p>
 * Псевдокод
 * Данный псевдокод используется для описания алгоритмов.
 * <p>
 * 1. Отступ от левого поля указывает на уровень вложенности.
 * 2. Циклы while, for, repeat и условные конструкции имеют тот же смысл, что и в pascal-е.
 * 3. Символ “--” обозначает комментарий
 * 4. Символ “:=” обозначает присваивание
 * 5. Переменные локальны в рамках процедуры, если не оговорено иначе
 * 6. Индекс массива пишется в квадратных скобках, конструкция A[i] означает i элемент в массиве A
 * 7. Возможно использование объектов, состоящих из нескольких полей, или имеющих несколько атрибутов,
 * значения поля записывается как ИмяПоля[ИмяОбъекта].
 * К примеру, длина массива A записывается как Length[A]; что означают квадратные скобки
 * - выясняется по контексту (переменная, обозначающая массив, или объект является указателем
 * на составляющие его данные). После присвоения y:=x для любого поля f будет выполняться равенство f[y]=f[x];
 * определение того, что является атрибутом – функция, переменная или что-либо еще,
 * то делается по контексту.
 * 8. Указатель может иметь специальное значение NIL, не указывающее ни на какой объект.
 * 9. Параметры передаются по значению: вызванная процедура получает собственную копию параметров,
 * изменения параметров внутри процедуры снаружи не видно. При передаче объектов копируется указатель на данные,
 * соответствующие этому объекту.
 * <p>
 * Функция сортирующая массив элементов A:
 * <code>
 * Sort(A, p, r)
 * 1    if p < r
 * 2        then q := round_half_down((p+r)/2)
 * 3            Sort(A,p,q)
 * 4            Sort(A,q+1,r)
 * 5            Merge(A,p,q,r)
 * </code>
 * <p>
 * Пример массива:
 * A = (5,2,4,6,1,3,2,6)
 * <p>
 * Примера запуска:
 * Sort(A,1,length[A])
 * <p>
 * <p>
 * Необходимо:
 * Разработать алгоритм функции Merge(A, p, q, r) на любом удобном вам языке,
 * с использованием дополнительной памяти или без нее, как вам будет быстрее или удобнее в реализации.
 * Если у вас получится - с радостью ждем вас для прохождения дополнительного тестирования.
 **/
public class RecursiveMergeSort {


    public static void main(String[] args) {

        sortAndPrint(new int [] {5, 2, 4, 6, 1, 3, 2, 6});
        sortAndPrint(new int [] {5, -2, -4, -6, -111, -3333, -20000, -60000, -7_000_000});
        sortAndPrint(new int [] {5, 2, 4, 6, 1, 2, 6});
        sortAndPrint(new int [] {5, 2, 4, 6, 1, 3, 2});
        sortAndPrint(new int [] {5});
        sortAndPrint(new int [] {5, 4});
        sortAndPrint(new int [] {5, 4, 5});

    }

    public static void sortAndPrint(int[] array) {
        sort(array, 1, array.length);
        print(array, "Sorted array");
    }


    public static void print(int[] array, String description) {
        System.out.println(description + ": " + Arrays.toString(array));
    }


    private static void sort(int[] arr, int p, int r) {

        if (p < r) {
            int q = (p + r) / 2;
            sort(arr, p, q);
            sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    /** Sorts two already sorted parts of an array between themselves.
     * The parts are located between the indexes p and r split down the middle with the index q.
     * Note: the numeration of indexes starts with the "1". This means that if
     * we have e.g. p == 1, q == 4 and r == 8
     * then the first part of subarray will include items with indexes between
     * p-1 and q-1 inclusive (i.e. 0, 1, 2 and 3) and the second part will include
     * items with indexes between q and r-1 (i.e 4, 5, 6  and 7).
     * @param p   start index
     * @param q   middle index
     * @param r   end index
     * @param arr array to sort
     */

    public static void merge(int[] arr, int p, int q, int r) {

        final int n = r - p + 1;
        int [] currentResult = new int[n];

        int k = 0;
        int i = p - 1;
        int j = q;

        while (i < q && j < r) {
                if (arr[i] < arr[j]) {
                    currentResult[k++] = arr[i++];
                }
                else if (arr[i] == arr[j]) {
                    currentResult[k++] = arr[i++];
                    currentResult[k++] = arr[j++];
                }
                else {
                    currentResult[k++] = arr[j++];
                }
        }

        System.arraycopy(arr, (i < q)? i : j , currentResult, k, n-k);
        System.arraycopy(currentResult, 0, arr, p-1, n);
    }
}
