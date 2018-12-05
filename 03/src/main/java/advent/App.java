/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package advent;

import java.util.ArrayList;
import java.util.List;

public class App {

	int overlaps;
	List<String> input;
	// List<Claim> claimsList;
	Claims claims;

	public App(List<String> input) {
		claims = new Claims(input);
	}

	public static void main(String[] args) {
		App app = new App(ReadInput.getInput());
		app.run();
	}
	private void run() {
		
		Fabric fabric = new Fabric();
		
		fabric.setClaims(claims);

		System.out.println("Overlap size: " + fabric.checkOverlaps());
		System.out.println("Single claimer: " + fabric.findSingleClaim());

	}

}
