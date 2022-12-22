/*
Project 1
Nikole Solano and Kenny La
*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to my Personal Management Program\n");

		options(scan);
	}

	// -----------------------------------------------------------------------------
	// -----------------------------------------------------------------------------
	/*
	 * Method displays 7 options that prompt a user input & contains switch cases
	 * relative to option numbers
	 * 
	 * Runs indefinitely until case == 7 (exit program)
	 */
	static void options(Scanner scan) {

		Faculty faculty1 = new Faculty();

		Student student1 = new Student();
		Student student2 = new Student();

		StaffMember staff1 = new StaffMember();

		boolean loop = true;

		while (loop) {

			System.out.println("\nChoose one of the options:\n");
			System.out.println("1- Enter the information of the faculty member");
			System.out.println("2- Enter the information of the two students");
			System.out.println("3- Print tuition invoice");
			System.out.println("4- Print faculty information");
			System.out.println("5- Enter the information of the staff member");
			System.out.println("6- Print the information of the staff member");
			System.out.println("7- Exit Program\n");
			System.out.print("Enter your selection: ");

			switch (scan.next()) {

			case "1": // Enter the information of the faculty member

				if (faculty1.getName() == null) {
					System.out.print("Enter the name of the faculty: ");
					scan.nextLine();
					faculty1.setName(scan.nextLine());
					System.out.print("Enter the ID: ");
					faculty1.setId(scan.next());

					boolean test = true;
					scan.nextLine();
					while (test) {
						System.out.print("Enter the Rank: ");
						faculty1.setRank(scan.nextLine());

						if (faculty1.getRank().equalsIgnoreCase("professor")
								|| faculty1.getRank().equalsIgnoreCase("adjunct")) {
							test = false;
						} else
							System.out.println("Invalid - try again");
					}

					boolean test2 = true;
					while (test2) {
						System.out.print("Enter the Department: ");
						faculty1.setDepartment(scan.nextLine());

						if (faculty1.getDepartment().equalsIgnoreCase("mathematics")
								|| faculty1.getDepartment().equalsIgnoreCase("engineering")
								|| faculty1.getDepartment().equalsIgnoreCase("english")) {
							test2 = false;
						} else
							System.out.println("Invalid - try again");
					}
					System.out.println("Faculty successfully added!");
				}

				else {
					System.out.print("You already have a faculty filled in. "
							+ "Do you want to update their information? Enter Y/y for yes or N/n for no: ");

					String choice = scan.next();

					if (choice.equalsIgnoreCase("y")) {

						System.out.print("Enter the name of the faculty: ");
						scan.nextLine();
						faculty1.setName(scan.nextLine());
						System.out.print("Enter the ID: ");
						faculty1.setId(scan.next());

						boolean test = true;
						scan.nextLine();
						while (test) {
							System.out.print("Enter the Rank: ");
							faculty1.setRank(scan.nextLine());

							if (faculty1.getRank().equalsIgnoreCase("professor")
									|| faculty1.getRank().equalsIgnoreCase("adjunct")) {
								test = false;
							} else
								System.out.println("Invalid - try again");
						}

						boolean test2 = true;
						while (test2) {
							System.out.print("Enter the Department: ");
							faculty1.setDepartment(scan.nextLine());

							if (faculty1.getDepartment().equalsIgnoreCase("mathematics")
									|| faculty1.getDepartment().equalsIgnoreCase("engineering")
									|| faculty1.getDepartment().equalsIgnoreCase("english")) {
								test2 = false;
							} else
								System.out.println("Invalid - try again");
						}
						System.out.println("Faculty successfully added!");

					} else if (choice.equalsIgnoreCase("n")) {
						System.out.println("Okay, update aborted.");
					} else
						System.out.println("Invalid - try again");
				}
				break;

			case "2": // Enter the information of the two students

				if (student1.getName() == null) {
					System.out.println("\nSTUDENT 1");
					System.out.println("---------");
					System.out.print("Enter the name of the student: ");
					scan.nextLine();
					student1.setName(scan.nextLine());
					System.out.print("Enter the ID: ");
					student1.setId(scan.next());
					System.out.print("Enter the GPA: ");
					student1.setGpa(scan.nextDouble());
					System.out.print("Enter the credit hours: ");
					student1.setCreditHours(scan.nextInt());
					System.out.println("Student 1 successfully added!\n");

					System.out.println("\nSTUDENT 2");
					System.out.println("---------");
					System.out.print("Enter the name of the student: ");
					scan.nextLine();
					student2.setName(scan.nextLine());
					System.out.print("Enter the ID: ");
					student2.setId(scan.next());
					System.out.print("Enter the GPA: ");
					student2.setGpa(scan.nextDouble());
					System.out.print("Enter the credit hours: ");
					student2.setCreditHours(scan.nextInt());
					System.out.println("Student 2 successfully added!\n");
				}

				else {

					System.out.print("You already have two students filled in. "
							+ "Do you want to update their information? Enter Y/y for yes or N/n for no: ");

					String choice2 = scan.next();

					if (choice2.equalsIgnoreCase("y")) {
						System.out.println("\nSTUDENT 1");
						System.out.println("---------");
						System.out.print("Enter the name of the student: ");
						scan.nextLine();
						student1.setName(scan.nextLine());
						System.out.print("Enter the ID: ");
						student1.setId(scan.next());
						System.out.print("Enter the GPA: ");
						student1.setGpa(scan.nextDouble());
						System.out.print("Enter the credit hours: ");
						student1.setCreditHours(scan.nextInt());
						System.out.println("Student 1 successfully added!\n");

						System.out.println("\nSTUDENT 2");
						System.out.println("---------");
						System.out.print("Enter the name of the student: ");
						scan.nextLine();
						student2.setName(scan.nextLine());
						System.out.print("Enter the ID: ");
						student2.setId(scan.next());
						System.out.print("Enter the GPA: ");
						student2.setGpa(scan.nextDouble());
						System.out.print("Enter the credit hours: ");
						student2.setCreditHours(scan.nextInt());
						System.out.println("Student 2 successfully added!\n");
					} else if (choice2.equalsIgnoreCase("n")) {
						System.out.println("Okay, update aborted.");
					} else
						System.out.println("Invalid - try again");
				}
				break;

			case "3": // Print tuition invoice

				if (student1.getName() == null)
					System.out.println("Sorry! Students do not exist.");

				else {
					int fees = 52;
					double discount = .15;
					double creditHourCost = 236.45;
					double totalPayment;
					double discountApplied;
					double discountedPayment;

					System.out.print("Enter 1 for " + student1.getName().toUpperCase() + " or Enter 2 for "
							+ student2.getName().toUpperCase() + ": ");
					int studentSelect = scan.nextInt();

					if (studentSelect == 1) {

						System.out.println("\nHere is the tuition invoice for " + student1.getName().toUpperCase());
						System.out.println("-------------------------------------------------------------------");
						System.out.println(student1.getName().toUpperCase() + " " + student1.getId().toUpperCase());
						System.out.println("Credit hours: " + student1.getCreditHours() + " ($236.45/credit hour)");
						System.out.println("Fees: $" + fees);

						if (student1.getGpa() >= 3.85) {

							totalPayment = (student1.getCreditHours() * creditHourCost) + fees;
							discountApplied = totalPayment * discount;
							discountedPayment = totalPayment - discountApplied;

							System.out.printf("Total payment (after discount): $%.2f ($%.2f discount applied)\n",
									discountedPayment, discountApplied);
							System.out.println("-------------------------------------------------------------------");
						}

						else {
							totalPayment = (student1.getCreditHours() * creditHourCost) + fees;
							System.out.printf("Total payment (after discount): $%.2f ($0 discount applied)\n",
									totalPayment);
							System.out.println("-------------------------------------------------------------------");
						}
					}

					else if (studentSelect == 2) {

						System.out.println("\nHere is the tuition invoice for " + student2.getName().toUpperCase());
						System.out.println("-------------------------------------------------------------------");
						System.out.println(student2.getName().toUpperCase() + " " + student2.getId().toUpperCase());
						System.out.println("Credit hours: " + student2.getCreditHours() + " ($236.45/credit hour)");
						System.out.println("Fees: $" + fees);

						if (student2.getGpa() >= 3.85) {

							totalPayment = (student2.getCreditHours() * creditHourCost) + fees;
							discountApplied = totalPayment * discount;
							discountedPayment = totalPayment - discountApplied;

							System.out.printf("Total payment (after discount): $%.2f ($%.2f discount applied)\n",
									discountedPayment, discountApplied);
							System.out.println("-------------------------------------------------------------------");
						}

						else {
							totalPayment = (student2.getCreditHours() * creditHourCost) + fees;
							System.out.printf("Total payment (after discount): $%.2f ($0 discount applied)\n",
									totalPayment);
							System.out.println("-------------------------------------------------------------------");
						}
					}
				}

				break;

			case "4": // Print faculty information

				if (faculty1.getName() == null)
					System.out.println("Sorry! Faculty does not exist.");

				else {
					System.out.println("-------------------------------------------------------------------");
					System.out.println(faculty1.getName().toUpperCase() + " " + faculty1.getId().toUpperCase());
					System.out.println(faculty1.getDepartment().substring(0, 1).toUpperCase()
							+ faculty1.getDepartment().substring(1).toLowerCase() + " Department, "
							+ faculty1.getRank().toUpperCase());
					System.out.println("-------------------------------------------------------------------");
				}
				break;

			case "5": // Enter the information of the staff member

				if (staff1.getName() == null) {
					System.out.print("Enter the name of the staff member: ");
					scan.nextLine();
					staff1.setName(scan.nextLine());
					System.out.print("Enter the ID: ");
					staff1.setId(scan.next());

					boolean test3 = true;
					scan.nextLine();
					while (test3) {
						System.out.print("Enter the Department: ");
						staff1.setDepartment(scan.nextLine());

						if (staff1.getDepartment().equalsIgnoreCase("mathematics")
								|| staff1.getDepartment().equalsIgnoreCase("engineering")
								|| staff1.getDepartment().equalsIgnoreCase("english")) {
							test3 = false;
						} else
							System.out.println("Invalid - try again");
					}
					System.out.print("Enter the Status (P for part time or F for full time): ");
					staff1.setStatus(scan.next());

					if (staff1.getStatus().equalsIgnoreCase("p"))
						staff1.setStatus("PART TIME");
					else if (staff1.getStatus().equalsIgnoreCase("f"))
						staff1.setStatus("FULL TIME");

					System.out.println("Staff Member successfully added!");
				}

				else {
					System.out.print("You already have a staff member filled in. "
							+ "Do you want to update their information? Enter Y/y for yes or N/n for no: ");

					String choice3 = scan.next();

					if (choice3.equalsIgnoreCase("y")) {
						System.out.print("Enter the name of the staff member: ");
						scan.nextLine();
						staff1.setName(scan.nextLine());
						System.out.print("Enter the ID: ");
						staff1.setId(scan.next());

						boolean test3 = true;
						scan.nextLine();
						while (test3) {
							System.out.print("Enter the Department: ");
							staff1.setDepartment(scan.nextLine());

							if (staff1.getDepartment().equalsIgnoreCase("mathematics")
									|| staff1.getDepartment().equalsIgnoreCase("engineering")
									|| staff1.getDepartment().equalsIgnoreCase("english")) {
								test3 = false;
							} else
								System.out.println("Invalid - try again");
						}
						System.out.print("Enter the Status (P for part time or F for full time): ");
						staff1.setStatus(scan.next());

						if (staff1.getStatus().equalsIgnoreCase("p"))
							staff1.setStatus("PART TIME");

						else if (staff1.getStatus().equalsIgnoreCase("f"))
							staff1.setStatus("FULL TIME");
						System.out.println("Staff Member successfully added!");

					} else if (choice3.equalsIgnoreCase("n")) {
						System.out.println("Okay, update aborted.");
					} else
						System.out.println("Invalid - try again");
				}
				break;

			case "6": // Print the information of the staff member

				if (staff1.getName() == null)
					System.out.println("Sorry! Staff member does not exist.");

				else {
					System.out.println("-------------------------------------------------------------------");
					System.out.println(staff1.getName().toUpperCase() + " " + staff1.getId().toUpperCase());
					System.out.println(staff1.getDepartment().substring(0, 1).toUpperCase()
							+ staff1.getDepartment().substring(1).toLowerCase() + " Department, "
							+ staff1.getStatus().toUpperCase());
					System.out.println("-------------------------------------------------------------------");
				}
				break;

			case "7": // Exit Program

				System.out.println("\nGoodbye!");
				loop = false;
				break;

			default:

				System.out.print("Invalid entry - please try again");
				break;
			}
		}
	}
}

// Classes used and their getters/setters
class Faculty {

	private String name;
	private String id;
	private String rank;
	private String department;

	// --------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}

class Student {

	private String name;
	private String id;
	private double gpa;
	private int creditHours;

	// --------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
}

class StaffMember {

	private String name;
	private String id;
	private String department;
	private String status;

	// --------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}