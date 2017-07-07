package com.test.fizzbuzz;


import com.greghaskins.spectrum.Spectrum;
import com.greghaskins.spectrum.Variable;
import com.greghaskins.spectrum.dsl.gherkin.Gherkin;
import org.junit.Assert;
import org.junit.runner.RunWith;

import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.*;

@RunWith(Spectrum.class)
public class FizzBuzzStep3Test {
    {

        feature("fizzbuzz", () -> {

            scenarioOutline("should be able to identify number divisible by 3", (number, expectedBoolean) -> {

                        Variable<FizzBuzzStep3> fizzBuzz = new Variable<>();
                        Variable<Boolean> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep3()));

                        when("called getFizzBuzz",
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

                        Variable<FizzBuzzStep3> fizzBuzz = new Variable<>();
                        Variable<Boolean> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep3()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().isDivisibleBy5.test(number)));

                        then("output should be " + expectedBoolean,
                                () -> Assert.assertEquals(message.get(), expectedBoolean));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(3, false),
                            Gherkin.example(5, true),
                            Gherkin.example(10, true)

                    ));


            scenarioOutline("should be able to identify number divisible by 15", (number, expectedBoolean) -> {

                        Variable<FizzBuzzStep3> fizzBuzz = new Variable<>();
                        Variable<Boolean> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep3()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().isDivisibleBy3And5.test(number)));

                        then("output should be "+ expectedBoolean,
                                () -> Assert.assertEquals(message.get(), expectedBoolean));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(3, false),
                            Gherkin.example(5, false),
                            Gherkin.example(15, true),
                            Gherkin.example(30, true)

                    ));


            scenarioOutline("should be able to identify correct message as per the digit passed", (digit, expectedMessage) -> {

                        Variable<FizzBuzzStep3> fizzBuzz = new Variable<>();
                        Variable<String> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep3()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().messageFinder.apply(digit)));

                        then("output should be "+ expectedMessage,
                                () -> Assert.assertEquals(message.get(), expectedMessage));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(5, "buzz"),
                            Gherkin.example(15, "fizzbuzz"),
                            Gherkin.example(29, "29")

                    ));


            scenarioOutline("should be able to identify number contains 3", (number, expectedBoolean) -> {

                        Variable<FizzBuzzStep3> fizzBuzz = new Variable<>();
                        Variable<Boolean> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep3()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().doesContains3.test(number)));

                        then("output should be "+ expectedBoolean,
                                () -> Assert.assertEquals(message.get(), expectedBoolean));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(3, true),
                            Gherkin.example(5, false),
                            Gherkin.example(15, false),
                            Gherkin.example(30, true)

                    ));

            scenarioOutline("should return proper message for a range", (startFrom, take, expectedMessage) -> {

                        Variable<FizzBuzzStep3> fizzBuzz = new Variable<>();
                        Variable<String> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep3()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().getFizzBuzz(startFrom, take)));

                        then("output should be "+ expectedMessage,
                                () -> Assert.assertEquals(message.get(), expectedMessage));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(1, 20, "1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz 16 17 fizz 19 buzz"
                                    + "\n" + "fizz: 4" + "\n" + "buzz: 3" + "\n" + "fizzbuzz: 1" + "\n" + "luck: 2" + "\n" + "number: 10"),
                            Gherkin.example(3, 7, "luck 4 buzz fizz 7 8 fizz" + "\n" + "fizz: 2" + "\n" + "buzz: 1" + "\n" + "fizzbuzz: 0" + "\n" + "luck: 1" + "\n" + "number: 3")
                    ));

            scenarioOutline("should return proper message for a range with digit contain 3", (startFrom, take, expectedMessage) -> {

                        Variable<FizzBuzzStep3> fizzBuzz = new Variable<>();
                        Variable<String> message = new Variable<>();
                        given("fizz buzz is initialized",
                                () -> fizzBuzz.set(new FizzBuzzStep3()));

                        when("called getFizzBuzz",
                                () -> message.set(fizzBuzz.get().getFizzBuzz(startFrom, take)));

                        then("output should be " + expectedMessage,
                                () -> Assert.assertEquals(message.get(), expectedMessage));

                    },
                    Gherkin.withExamples(
                            Gherkin.example(1, 4, "1 2 luck 4" +  "\n" + "fizz: 0" + "\n" + "buzz: 0" + "\n" + "fizzbuzz: 0" + "\n" + "luck: 1" + "\n" + "number: 3"),
                            Gherkin.example(12, 3, "fizz luck 14" +  "\n" + "fizz: 1" + "\n" + "buzz: 0" + "\n" + "fizzbuzz: 0" + "\n" + "luck: 1" + "\n" + "number: 1")

                    ));

        });
    }


}
