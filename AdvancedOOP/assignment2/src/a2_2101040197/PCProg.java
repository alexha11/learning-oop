package a2_2101040197;
import static utils.TextIO.getln;
import static utils.TextIO.putln;
import static utils.TextIO.writeFile;
import static utils.TextIO.writeStandardOutput;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.TextIO;

/**
 * @overview PCProg is a program that captures data about PC objects and
 *           displays a report about them on the console.
 * 
 * @attributes objs Set<PC>
 * 
 * @object A typical PCProg is {c1,...,cn} where c1,...,cn are pcs
 * 
 * @abstract_properties mutable(objs)=true /\ optional(objs)=false
 * 
 * @author dmle
 */
public class PCProg {
	private static final Object YES = "Y";
	@DomainConstraint(mutable = true, optional = false)
	private Set<PC> objs;

	/**
	 * @effects initialise this to have an empty set of PCs
	 */
	public PCProg() {
		objs = new Set<>();
	}

	/**
	 * @effects if objs is not empty display to the standard console a text-based
	 *          tabular report on objs return this report else display nothing and
	 *          return null
	 */
	public String displayReport() {
		if (objs.size() > 0) {
			Vector<PC> pcs = objs.getElements();

			PCReport reportObj = new PCReport();
			return reportObj.displayReport(pcs.toArray(new PC[pcs.size()]));
		} else {
			return null;
		}
	}

	/**
	 * @effects save report to a file pcs.txt in the same directory as the program's
	 */
	public void saveReport(String report) {
		String fileName = "pcs.txt";
		writeFile(fileName);
		putln(report);
		writeStandardOutput();
	}

	/**
	 * @effect captures data about PC objects from user input, creates PC objects
	 * using PCFactory, and adds them to objs set. If the created PC object
	 * fails the repOK() check, display an error message and recursively
	 * calls createObjects() again. After adding PC objects to objs set,
	 * asks user if they want to continue or not. If user chooses to
	 * continue, recursively calls createObjects() again. If user chooses
	 *  to stop, calls displayReport() to generate and display the report.
	 */
	public void createObjects() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the model: ");
		String model = sc.nextLine();
		System.out.println("Enter the year: ");
		int year = sc.nextInt();
		System.out.println("Enter the manufacturer: ");
		String manufacturer = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter the number of components: ");
		Set<String> components = new Set<>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter component " + (i + 1) + ": ");
			String c = sc.next();
			components.insert(c);
		}
		PC pc = PCFactory.getFactory().createPC(model, year, manufacturer, components);
		if (!pc.repOK()) {
			System.out.println();
			createObjects();
		} else {
			objs.insert(pc);
			System.out.println("Do you want to continue, Y or N");
			char option = sc.next().charAt(0);
			if (option == 'Y') {
				createObjects();
			} else if (option == 'N') {
				String report = displayReport();
				System.out.println(report);
			}
		}
	}

	/**
	 * get the last elements in set
	 * @return
	 */
	public PC getObjects() {
		return objs.getElements().lastElement();
	}

	/**
	 * The run method
	 * 
	 * @effects initialise an instance of PCProg create objects from data entered by
	 *          the user display a report on the objects prompt user to save report
	 *          to file if user answers "Y" save report else end
	 */
	public static void main(String[] args) {
		//
		PCProg prog = new PCProg();

		// create objects
		try {
			prog.createObjects();
			// display report
			String report = prog.displayReport();
			System.out.println(report);
			if (report != null) {
				// prompt user to save report
				putln("Save report to file? [Y/N]");
				String toSave = getln();
				if (toSave.equals("Y")) {
					prog.saveReport(report);
					putln("report saved");
				}
			}

		} catch (NotPossibleException e) {
			System.err.printf("%s: %s%n", e, e.getMessage());
		}
		putln("~END~");
	}

}
