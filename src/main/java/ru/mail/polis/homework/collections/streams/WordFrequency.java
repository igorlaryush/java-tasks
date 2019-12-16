package ru.mail.polis.homework.collections.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Написать программу, которая из текста (стрим строк), возвращает 10 самых популярных слов (В порядке убывания частоты).
 * Словом считается последовательность символов из букв и цифр от пробела до пробела или знака препинания (.,!:-?;).
 * (Посмотрите статические методы в классе Character)
 *
 * <p>
 * В исходном стриме строка - это строка из книги, которая может содержать в себе много слов.
 *
 * <p>
 * Если слов в стриме меньше 10, то вывести все слова. Если слова имеют одинаковое количество упоминаний, то выводить
 * в лексикографическом порядеке.
 * Слова надо сравнивать без учета регистра.
 *
 * @@ -21,8 +26,17 @@
 * Если будут использоваться условные операторы, то оценка максимальная оценка 2 балла.
 */
public class WordFrequency {
    public static List<String> wordFrequency(Stream<String> lines) {
        System.out.println("da".compareTo("ne"));
        return lines
                .flatMap(line -> Arrays.stream(line.split("[ .,!:-?;]")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter((entry) -> !entry.getKey().isBlank())
                .sorted(
                        ((Comparator<Map.Entry<String, Long>>) (o1, o2) -> o1.getValue().compareTo(o2.getValue())).reversed().thenComparing(Map.Entry::getKey)
                )
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}