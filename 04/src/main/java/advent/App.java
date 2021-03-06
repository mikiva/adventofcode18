/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package advent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class App
{

	private static Map<Integer, Guard> gMap = new HashMap<>();

	public static void main(String[] args)
	{

		List<String> input = ReadInput.getInput();

		Collections.sort(input);
		// print(input);
		Guard g1 = part1(input);
		System.out.printf("Part 1 Answer: Minute %d * id %d = %d", g1.getMostFrequentMinute()[0], g1.getGuardID(),
				g1.getMostFrequentMinute()[0] * g1.getGuardID());
		System.out.println();
		Guard g2 = part2();
		System.out.printf("Part 2 Answer: Minute %d * id %d = %d", g2.getMostFrequentMinute()[0], g2.getGuardID(),
				g2.getMostFrequentMinute()[0] * g2.getGuardID());

	}

	public static Guard part1(List<String> input)
	{
		EntryScanner entry = new EntryScanner();

		boolean awake = true;
		int gid = -1;

		int down = -1;
		int up = -1;
		for (String line : input)
		{
			if (line.contains("Guard"))
			{
				gid = entry.getGuardID(line);
				if (!gMap.containsKey(gid))
				{
					gMap.put(gid, new Guard(gid));
				}
			}

			else if (line.contains("asleep"))
			{
				down = entry.sleepOrWakeUp(line);
				gMap.get(gid);
				awake = !awake;
			} else if (line.contains("wakes"))
			{
				up = entry.sleepOrWakeUp(line);

				gMap.get(gid).addSleep(down, up);
				awake = !awake;
			}
		}

		Iterator<?> it = gMap.entrySet().iterator();

		int minutes = 0;
		int id = -1;
		Guard guard = null;
		while (it.hasNext())
		{
			int min = 0;
			Map.Entry<Integer, Guard> pair = (Map.Entry<Integer, Guard>) it.next();

			Guard g = pair.getValue();

			for (int in : g.getSleepTime())
			{
				min += in;
			}

			if (min > minutes)
			{
				guard = g;
				minutes = min;
				id = g.getGuardID();
			}

		}

		return guard;

	}

	public static Guard part2()
	{
		Iterator<?> it = gMap.entrySet().iterator();

		int minutes[] = new int[2];
		int id = -1;
		Guard guard = null;
		while (it.hasNext())
		{
			Map.Entry<Integer, Guard> pair = (Map.Entry<Integer, Guard>) it.next();

			Guard g = pair.getValue();

			int[] in = g.getMostFrequentMinute();

			if (in[1] > minutes[1])
			{
				guard = g;
				minutes[0] = in[0];
				minutes[1] = in[1];
				id = g.getGuardID();
			}

		}

		return guard;
	}

	public static void print(List<String> list)
	{
		for (String s : list)
			System.out.println(s);
	}

}