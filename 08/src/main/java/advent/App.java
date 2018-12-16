/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package advent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {

	public static void main(String[] args) throws Exception{

		File file = new File(App.class.getClassLoader().getResource("input.txt").getFile());

		BufferedReader br = new BufferedReader(new FileReader(file));

		String[] inputArr = br.readLine().split("\\s");

		System.out.println(inputArr.length);
		for (String s : inputArr)
		{
			System.out.println(s);
		}
	}

}