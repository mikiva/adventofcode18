/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package advent;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App
{

	private static List<String> stepInput = ReadInput.getInput();


	public static void main(String[] args)
	{
		//createSteps();
		Runner runner = new Runner(stepInput);
		
	}

	public static void createSteps()
	{

			for (String input : stepInput)
			{
				char step = getStep(input);


			}

	}

	public static char getStep(String in)
	{

		String regex = "^Step (?<step>\\S).*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(in);

		if (m.find())
		{
			return m.group("step").charAt(0);
		}

		return '0';
	}

	public void tryStep(char step)
	{

	}
}