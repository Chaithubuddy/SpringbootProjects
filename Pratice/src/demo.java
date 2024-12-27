import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class demo {

	// 1,1,1,1,2,2,2,3,3,4

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 4);
		
	Map<Integer, Long>count=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

	System.out.println(count);
	
	}

	public static void main1(String[] args) {

		// apple, banana ,grapes

		// Arrays.asList(apple, banana ,grapes")

		ArrayList<String> listOfFruits = new ArrayList<>();
		listOfFruits.add("apple");
		listOfFruits.add("banana");
		listOfFruits.add("grapes");
		listOfFruits.add("mango");

	}

}
