package ru.mai;

/**
 * Строковые классы
 */
public class Main {

    /*
        Сортировка строк осуществляется лексикографически
        01_fileName.txt
        02_fileName.txt
        03_fileName.txt
        04_fi
        05_fileName.txt
        06_fileName.txt
        07_f
        08_fileName.txt
        09_fileName.txt
        10_file
     */

    public static void main(String[] args) {
        // String - неизменямый тип данных, от класса нельзя наследоваться
        String s1 = "abc   hhhhh  hhh ddd";
        String s2 = "ab";
        String s3 = new String("abc");
        String s4 = "abc";
        String s5 = s3;
        String s6 = new String("   ab  c                 ");
        char[] chars = {'a', 'b'};
        String s7 = new String(chars);

        // Сравнение срок: правильное сравнение по значению - это использование метода equals
        if (s1 == s3) {
            System.out.println("s1 = s3");
        }

        s1 = s1 + "ddd";

        if (s1 == s4) {
            System.out.println("s1 = s4");
        }

        if (s3 == s6) {
            System.out.println("s3 = s6");
        }

        if (s3 == s5) {
            System.out.println("s3 = s5");
        }

        if (s1 == s2) {
            System.out.println("s1 = s2");
        }

        if (s1 == s3) {
            System.out.println("s1 = s3");
        }

        if (s1.equals(s2)) {
            System.out.println("s1 = s2");
        }

        if (s1.equals(s3)) {
            System.out.println("s1 = s3");
        }

        // trim - не изменяет исходную строку
        System.out.println(s6);
        System.out.println(s6.trim());
        System.out.println(s6);

        // Преобразование строки к набору символов
        char[] chars1 = s1.toCharArray();
        s1.chars().forEach(System.out::println);

        // Сравнение строк - по умолчанию лексисографически
        System.out.println(s1.compareTo(s2));
        System.out.println(s2.compareTo(s1));
        System.out.println(s1.compareToIgnoreCase(s4));

        // split - разбиение строки на набор строк по переданному разделителю (в т.ч. регулярному выражению)
        String[] strs = s1.split(" ");
        for(String str : strs) {
            System.out.println(str);
        }

        // Конкатенация и умножение строк
        s3 = s1 + s2 + s1 + s1 + s2;
        s3 = s1.concat(s2);

        System.out.println(s1.repeat(3));
        System.out.println(s1.length());

        // Изменяемые строки - StringBuilder и StringBuffer
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.append(123);
        System.out.println(sb);

        // Размер и емкость
        System.out.println(sb.length());
        System.out.println(sb.capacity());

        sb.setCharAt(1, 'z');
        System.out.println(sb);

        sb.deleteCharAt(1);
        System.out.println(sb);

        sb.deleteCharAt(1);
//        sb.deleteCharAt(-1);
        sb.insert(1, "dddd123");
        System.out.println(sb);

        s3 = s1 + s2 + s1 + s1 + s2;
        StringBuilder sb1 = new StringBuilder(s1);
        sb1.append(s2).append(s3).append(s1).append(s1);

        // Сравнение производительности строковых классов
        testTimeForStringsClasses();
    }

    /**
     * Сравнение производительности строковых классов
     */
    private static void testTimeForStringsClasses() {

        long ts1 = System.nanoTime();

        String testStr = "aaa";
        for (int i = 0; i < 10000; i++) {
            testStr += "bbb";
            testStr += i;
        }

        long te1 = System.nanoTime();

        System.out.println("Time for String: " + (te1 - ts1) / 1e6 + "ms");

        long ts2 = System.nanoTime();

        StringBuffer testStr2 = new StringBuffer("aaa");

        for (int i = 0; i < 10000; i++) {
            testStr2.append("bbb");
            testStr2.append(i);
        }

        long te2 = System.nanoTime();

        System.out.println("Time for StringBuffer: " +
                (te2 - ts2) / 1e6 + "ms");

        long ts3 = System.nanoTime();

        StringBuilder testStr3 = new StringBuilder("aaa");

        for (int i = 0; i < 10000; i++) {
            testStr3.append("bbb");
            testStr3.append(i);
        }

        long te3 = System.nanoTime();

        System.out.println("Time for StringBuilder: " + (te3 - ts3) / 1e6 + "ms");
    }
}


