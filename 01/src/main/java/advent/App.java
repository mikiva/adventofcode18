/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class App {

	private int sum;
	private List<Integer> frequencies;
	private Integer firstFrequency;
	private boolean found;
	private Set<Integer> set;

	public App() {
		this.firstFrequency = null;
		this.frequencies = new ArrayList<Integer>();
		this.sum = 0;
		this.found = false;
		this.set = new HashSet<>();
	}

	public List<Integer> getFrequencies() {
		return frequencies;
	}

	public static void main(String[] args) {

		System.out.println("Sum at end: " + part1());
		System.out.println("First repeated: " +part2());

	}
	private static Integer part1()
	{

		App app = new App();
		List<String> inputs = app.getInputs();

		int sum = app.addP1(inputs);


		return sum;
	}
	private static Integer part2()
	{
		App app = new App();
		List<String> inputs = app.getInputs();
		while (!(app.found)) {

			app.run(inputs);
		}

		return app.getSum();

	}

	public int addP1(List<String> input)
	{
		int sum = 0;
		for(String s : input)
		{
			sum += Integer.parseInt(s);
		}
		return sum;
	}

	public void run(List<String> inputs) {
		for (String in : inputs) {
			
			
			if (!checkFrequency()) {
				this.found = true;
				return;
				
			}
			
			addNumber(in);
			
		}
		
	}

	private void addNumber(String number) {

		char operator = number.charAt(0);

		int num = Integer.parseInt(number.substring(1));

		switch (operator) {
		case '+':
			setSum(num);
			break;
		case '-':
			setSum(-num);
			break;
		}

	}

	private boolean checkFrequency() {

		Integer currentResult = (Integer) getSum();
		return set.add(currentResult);
	}

	private void setSum(int num) {
		this.sum += num;
	}

	private int getSum() {
		return this.sum;
	}

	private List<String> getInputs() {
		List<String> inputs = new ArrayList<String>();

		ClassLoader classLoader = getClass().getClassLoader();

		File file = new File(classLoader.getResource("input.txt").getFile());
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				inputs.add(line);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return inputs;

	}
}
