package programming.my_assignments;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise1 {

    private static List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    private static List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");


    private static List<Integer> squareAndCollect(List<Integer> numbers, Function<Integer, Integer> mapFunction) {
        List<Integer> sqNumbers = numbers.stream()
                .map(mapFunction)
                .collect(Collectors.toList());
        return sqNumbers;
    }



    public static void main(String[] args) {

        //Exercise 1 - print only odd numbers from list
        System.out.println("Exercise 1: Print only odd numbers from list.");
        numbers.stream()
                .filter(number -> number%2 != 0)
                .forEach(System.out::println);

        //Exercise 2 - print all courses
        System.out.println("\nExercise 2: Print all course names from list.");
        courses.stream()
                .forEach(System.out::println);

        //Exercise 3 - print all courses containing "spring"
        System.out.println("\nExercise 3: Print all course names from list containing 'Spring'.");
        courses.stream()
                .filter(name -> name.toLowerCase().contains("spring"))
                .forEach(System.out::println);

        //Exercise 4 - print all courses containing at least four characters
        System.out.println("\nExercise 4: Print all course names containing at least four characters.");
        courses.stream()
                .filter(name -> name.length() >= 4)
                .forEach(System.out::println);

        //Exercise 5 - print the cube of each number in the list
        System.out.println("\nExercise 5: Print the cube of each number in the list.");
        numbers.stream()
                .map(number -> number * number * number)
                .forEach(System.out::println);

        //Exercise 6 - print the number of characters in each course name
        System.out.println("\nExercise 6: Print the number of characters in each course name.");
        courses.stream()
                .map(String::length)
                .forEach(System.out::println);

        //Exercise 7 - square every number in list then get sum of squares
        System.out.println("\nExercise 7: Square every number in list then get sum of squares.");
        Integer sOfS_result = numbers.stream()
                .map(number -> number * number)
                //.reduce(0, (aggregate,number) -> aggregate + number)
                .reduce(0, Integer::sum);
        System.out.println(sOfS_result);

        //Exercise 8 - Cube every number in list then get sum of squares
        System.out.println("\nExercise 8: Cube every number in list then get sum of cubes.");
        Integer sOfC_result = numbers.stream()
                .map(number -> number * number * number)
                //.reduce(0, (aggregate,number) -> aggregate + number)
                .reduce(0, Integer::sum);
        System.out.println(sOfC_result);

        //Exercise 9 - Sum of odd numbers in list
        System.out.println("\nExercise 9: Sum of odd numbers in list.");
        Integer sOfO_result = numbers.stream()
                .filter(number -> number%2 != 0)
                .reduce(0, Integer::sum);
        System.out.println(sOfO_result);

        //Exercise 10 - Create a list of only even numbers from numbers list
        System.out.println("Exercise 10: Create a list of only even numbers from list.");
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number%2 == 0)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        //Exercise 11 - Create a list of length of all course titles from course list
        System.out.println("\nExercise 11: Create a list of length of all course titles from course list.");
        List<Integer> courseLengths = courses.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(courseLengths);

        //Exercise 12 - Find Functional Interface behind second arg of reduce method. Create an implementation instead.
        System.out.println("\nExercise 12: Implemented functional interface for Integer::sum.");
        BinaryOperator<Integer> sumOperation = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        int sum = numbers.stream()
                .reduce(0, sumOperation);
        System.out.println(sum);

        //Exercise 13 - Perform Behaviour Parameterization for mapping logic
        System.out.println("\nExercise 13: Perform Behaviour Parameterization for mapping logic.");
        List<Integer> sqNumbers = squareAndCollect(numbers, number -> number * number);
        System.out.println(sqNumbers);

        //Exercise 14 - Create BiPredicate
        System.out.println("\nExercise 14: Implement BiPredicate.");
        BiPredicate <Integer, Integer> biPred =(t, j) -> {
                if (t.intValue() > j.intValue() && t.intValue() > 5)
                    return true;
                else
                    return false;
            };

    }

}
