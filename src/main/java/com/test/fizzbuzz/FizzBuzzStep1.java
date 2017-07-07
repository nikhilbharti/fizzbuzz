package com.test.fizzbuzz;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FizzBuzzStep1 {

    private final String fizzBuzz = "fizzbuzz";
    private final String buzz = "buzz";
    private final String fizz = "fizz";

    /**
     * Method create output string message from continues range of numbers based on following criteria:
     * if the number is divisible by 3 change the number to 'fizz'
     * if the number is divisible by 5 change the number to 'buzz'
     * if the number is divisible by 5 && 3 change the number to 'fizzbuzz'
     * @param from input range from value
     * @param to input range to value
     * @return String message string with above criteria applied
     */
    public String getFizzBuzz(int from, int to) {
        StringBuilder builder = new StringBuilder();
        Stream<String> fizzBuzzStream = getFizzBuzzStreamFrom(from);

        fizzBuzzStream.limit(to).forEach(data -> {
            builder.append(data);
            builder.append(" ");
        });

        builder.setLength(builder.length() - 1);
        return builder.toString();
    }

    /**
     * Method create stream of strings after iterating over 'from' input value and apply
     * function messagefinder to each input number
     * @param from input range from value
     * @return Stream of String after applying logic of divisible by 3,5,15
     */
    private Stream<String> getFizzBuzzStreamFrom(int from) {
        Stream<Integer> numbers = Stream.iterate(from, o -> o+1);
        return numbers.map(messageFinder);
    }

    Predicate<Integer> isDivisibleBy3 = number -> Objects.equals(number % 3, 0);
    Predicate<Integer> isDivisibleBy5 = number -> Objects.equals(number % 5, 0);
    Predicate<Integer> isDivisibleBy3And5 = number -> Objects.equals(number % 15, 0);

    /**
     * Method takes number as input and return a String after applying Predicate to it
     */
    Function<Integer, String> messageFinder = (digit) ->
            isDivisibleBy3And5.test(digit) ? fizzBuzz :
                    (isDivisibleBy3.test(digit) ? fizz :
                            (isDivisibleBy5.test(digit) ? buzz :
                                    digit.toString()));

}

