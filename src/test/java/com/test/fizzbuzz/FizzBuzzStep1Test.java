package com.test.fizzbuzz;


import com.greghaskins.spectrum.Spectrum;
import com.greghaskins.spectrum.Variable;
import com.greghaskins.spectrum.dsl.gherkin.Gherkin;
import org.junit.Assert;
import org.junit.runner.RunWith;

import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.*;

@RunWith(Spectrum.class)
public class FizzBuzzStep1Test {
    {

        feature("FizzBuzz", () -> {


            scenarioOutline("should be able to identify number divisible by 3", (number, expectedBoolean) -> {

                        Variable<FizzBuzzStep1> fizzBuzz = new Variable<>();
                        Variable<Boolean> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep1()));

                        when("called isDivisibleBy3 predicate",
                                () -> message.set(fizzBuzz.get().isDivisibleBy3.test(number)));

                        then("output should be " + expectedBoolean,
                                () -> Assert.assertEquals(message.get(), expectedBoolean));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(3, true),
                            Gherkin.example(5, false),
                            Gherkin.example(9, true)

                    ));


            scenarioOutline("should be able to identify number divisible by 5", (number, expectedBoolean) -> {

                        Variable<FizzBuzzStep1> fizzBuzz = new Variable<>();
                        Variable<Boolean> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep1()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().isDivisibleBy5.test(number)));

                        then("output should be "+ expectedBoolean,
                                () -> Assert.assertEquals(message.get(), expectedBoolean));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(3, false),
                            Gherkin.example(5, true),
                            Gherkin.example(10, true)

                    ));


            scenarioOutline("should be able to identify number divisible by 3 and 5", (number, expectedBoolean) -> {

                        Variable<FizzBuzzStep1> fizzBuzz = new Variable<>();
                        Variable<Boolean> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep1()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().isDivisibleBy3And5.test(number)));

                        then("output should be " + expectedBoolean,
                                () -> Assert.assertEquals(message.get(), expectedBoolean));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(3, false),
                            Gherkin.example(5, false),
                            Gherkin.example(15, true),
                            Gherkin.example(30, true)

                    ));


            scenarioOutline("should be able to identify correct message as per the digit passed", (digit, expectedMessage) -> {

                        Variable<FizzBuzzStep1> fizzBuzz = new Variable<>();
                        Variable<String> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep1()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().messageFinder.apply(digit)));

                        then("output should be " + expectedMessage,
                                () -> Assert.assertEquals(message.get(), expectedMessage));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(5, "buzz"),
                            Gherkin.example(15, "fizzbuzz"),
                            Gherkin.example(29, "29")

                    ));

            scenarioOutline("should return proper message for values divisible by 3", (startFrom, take, expectedMessage) -> {

                        Variable<FizzBuzzStep1> fizzBuzz = new Variable<>();
                        Variable<String> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep1()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().getFizzBuzz(startFrom, take)));

                        then("output should be " + expectedMessage,
                                () -> Assert.assertEquals(message.get(), expectedMessage));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(6, 3, "fizz 7 8"),
                            Gherkin.example(7, 3, "7 8 fizz")

                    ));


            scenarioOutline("should return proper message for values divisible by 5", (startFrom, take, expectedMessage) -> {

                        Variable<FizzBuzzStep1> fizzBuzz = new Variable<>();
                        Variable<String> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep1()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().getFizzBuzz(startFrom, take)));

                        then("output should be " + expectedMessage,
                                () -> Assert.assertEquals(message.get(), expectedMessage));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(4, 2, "4 buzz"),
                            Gherkin.example(5, 3, "buzz fizz 7")

                    ));


            scenarioOutline("should return proper message for values divisible by both 3 and 5", (startFrom, take, expectedMessage) -> {

                        Variable<FizzBuzzStep1> fizzBuzz = new Variable<>();
                        Variable<String> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep1()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().getFizzBuzz(startFrom, take)));

                        then("output should be "+expectedMessage,
                                () -> Assert.assertEquals(message.get(), expectedMessage));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(15, 3, "fizzbuzz 16 17"),
                            Gherkin.example(15, 6, "fizzbuzz 16 17 fizz 19 buzz")

                    ));

            scenarioOutline("should return proper message for a range", (startFrom, take, expectedMessage) -> {

                        Variable<FizzBuzzStep1> fizzBuzz = new Variable<>();
                        Variable<String> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep1()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().getFizzBuzz(startFrom, take)));

                        then("output should be " + expectedMessage,
                                () -> Assert.assertEquals(message.get(), expectedMessage));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(15, 3, "fizzbuzz 16 17"),
                            Gherkin.example(15, 6, "fizzbuzz 16 17 fizz 19 buzz")

                    ));


        });
    }


}
