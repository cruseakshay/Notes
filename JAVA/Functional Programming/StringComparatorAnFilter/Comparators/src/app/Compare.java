package app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Compare {
	public static void printPeople(final String message, final List<Person> people) {

		System.out.println(message);
		people.forEach(System.out::println);
	}

	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(new Person("John", 20), new Person("Sara", 21),
				new Person("Jane", 21), new Person("Greg", 35));
		{
			System.out.println("//" + "START:AGE_ASCEND_OUTPUT");
			
			/*
			 * sorted() accepts Comparator Functional Interface for Sorting the objects from stream.
			 */
			final List<Person> ascendingAge = people.stream().sorted((person1, person2) -> person1.ageDifference(person2))
					.collect(Collectors.toList());
			printPeople("Sorted in ascending order by age:", ascendingAge);
			System.out.println("//" + "END:AGE_ASCEND_OUTPUT");
		}
		{
			// Using method reference.
			System.out.println("//" + "START:AGE_ASCEND_MR_OUTPUT");
			
			
			/* 
			 * Special case of Method Reference.
			 * we have two parameters and we want those to be split, the first to be used as a target to the method and the second as an argument.
			 * */
			final List<Person> ascendingAge = people.stream().sorted(Person::ageDifference).collect(Collectors.toList());
			printPeople("Sorted in ascending order by age with method reference: ", ascendingAge);
		    System.out.println("//" + "END:AGE_ASCEND_MR_OUTPUT");
		}
		{
			System.out.println("//" + "START:AGE_DESCEND_OUTPUT");
			
			printPeople("Sorted in descending order by age: ",  
					people.stream().sorted(
							// the first parameter is not used as a target to the method, but rather as its argument. [does not follow the parameter-routing conventions for method reference]
							(person1, person2) -> person2.ageDifference(person1)
							).collect(Collectors.toList()));
			System.out.println("//" + "END:AGE_DESCEND_OUTPUT");
		}
		

	}
}
