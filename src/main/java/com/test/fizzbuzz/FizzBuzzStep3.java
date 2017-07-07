package com.test.fizzbuzz;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class FizzBuzzStep3 {

    private final String LUCK = "luck";
    private final String FIZZBUZZ = "fizzbuzz";
    private final String BUZZ = "buzz";
    private final String FIZZ = "fizz";
    private final String NUMBER = "number";
    private final String SEPARATOR = " ";

    /**
     * This method create output string message from continues range of numbers based on following criteria:
     * If the number contains a 3 change the number to 'lucky'
     * if the number is divisible by 3 change the number to 'fizz'
     * if the number is divisible by 5 change the number to 'buzz'
     * if the number is divisible by 5 && 3 change the number to 'fizzbuzz'
     * also appends the stats about how many times the individual word (fizz,buzz,fizzbuzz,luck,number) comes in the output message
     * @param from input range from value
     * @param to input range to value
     * @return String message string with above criteria applied
     */
    public String getFizzBuzz(int from, int to) {
        StringBuilder builder = new StringBuilder();
        Stream<String> fizzBuzzStream = getFizzBuzzStreamFrom(from);
        fizzBuzzStream.limit(to).forEach(data -> builder.append(data).append(SEPARATOR));
        builder.setLength(builder.length() - 1);
        addStats(builder);
        return builder.toString();
    }

    /**
     * Method add stats counts to the StringBuilder
     * @param message input StringBuilder message string
     */
    private void addStats(StringBuilder message) {
        Map<String, Integer> stats = getStats(message);
        message.append("\n");
        message.append("fizz: ").append(stats.getOrDefault(FIZZ,0)).append("\n");
        message.append("buzz: ").append(stats.getOrDefault(BUZZ,0)).append("\n");
        message.append("fizzbuzz: ").append(stats.getOrDefault(FIZZBUZZ,0)).append("\n");
        message.append("luck: ").append(stats.getOrDefault(LUCK,0)).append("\n");
        message.append("number: ").append(stats.getOrDefault(NUMBER,0));
    }

    /**
     * Method takes message as input, create arrayStream and apply grouping and sum function.
     * @param message input string message
     * @return Integer count of individual word (fizz,buzz,fizzbuzz,luck,number)
     */
    private Map<String, Integer> getStats(StringBuilder message) {
        return Arrays.stream(message.toString().split(SEPARATOR))
                .map(n -> isNumber.test(n) ? NUMBER : n)
                .collect(groupingBy(Function.identity(), summingInt(e -> 1)));
    }

    /**
     * Method create stream of strings after iterating over 'from' input value and apply
     * function messagefinder to each input number
     * @param from input range from value
     * @return Stream of String after applying logic of divisible by 3,5,15
     */
    private Stream<String> getFizzBuzzStreamFrom(Integer from) {
        Stream<Integer> numbers = Stream.iterate(from, o -> o + 1);
        return numbers.map(messageFinder);
    }


    Predicate<Integer> isDivisibleBy3 = number -> Objects.equals(number % 3, 0);
    Predicate<Integer> isDivisibleBy5 = number -> Objects.equals(number % 5, 0);
    Predicate<Integer> isDivisibleBy3And5 = number -> Objects.equals(number % 15, 0);
    Predicate<Integer> doesContains3 = number -> String.valueOf(number).contains("3");
    Predicate<String> isNumber = Pattern.compile("[-+]?\\d*\\.?\\d+").asPredicate();

    /**
     * Method takes number as input and return a String after applying Predicates to it
     */
    Function<Integer, String> messageFinder = (digit) ->
            doesContains3.test(digit) ? LUCK :
                    isDivisibleBy3And5.test(digit) ? FIZZBUZZ :
                            (isDivisibleBy3.test(digit) ? FIZZ :
                                    (isDivisibleBy5.test(digit) ? BUZZ :
                                            digit.toString()));

}

