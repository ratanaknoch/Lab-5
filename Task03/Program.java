 /**
 * The Subject class represents a course in the Year 2 program.
 * It contains information about the subject name, subject code, and credit hours.
 * 
 * @author Ratanak Noch Munny
 * @version 1.1
 * @since 2025-01-08
 */

 package Task03;

 import java.util.ArrayList;
 import java.util.Scanner;
 
 class Subject {
    // Constant: Maximum credit hours allowed for a subject
    private static final int MAX_CREDITS = 6;

    // Instance variables
    private String subjectName;
    private int creditHours;

    // Constructor
    public Subject(String subjectName, int creditHours) {
        this.subjectName = subjectName;
        setCreditHours(creditHours); // Use setter to enforce validation
    }

    // Getters and Setters
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        if (subjectName == null || subjectName.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be null or empty.");
        }
        this.subjectName = subjectName;
            }

            public int getCreditHours() {
                return creditHours;
            }

            public void setCreditHours(int creditHours) {
                try (Scanner scanner = new Scanner(System.in)) {
                    while (creditHours > MAX_CREDITS) {
                        System.out.print("Credit hours exceed " + MAX_CREDITS + ". Please re-enter credit hours: ");
                        creditHours = scanner.nextInt();
                    }
                }
                this.creditHours = creditHours;
            }

    // Static getter for constant
    public static int getMaxCredits() {
        return MAX_CREDITS;
    }

    @Override
    public String toString() {
        return "Subject: " + subjectName + ", Credit Hour: " + creditHours;
    }
}
 
 /**
  * The Program class provides a menu-driven interface to manage subjects.
  */
 public class Program {
     public static void main(String[] args) {
         ArrayList<Subject> subjects = new ArrayList<>();
         Scanner scanner = new Scanner(System.in);
         int choice;
 
         do {
             System.out.println("1. Add Subject");
             System.out.println("2. View Subjects");
             System.out.println("3. Exit");
             System.out.print("Enter your choice: ");
             choice = scanner.nextInt();
             scanner.nextLine(); // consume newline
 
             switch (choice) {
                 case 1:
                     System.out.print("Enter subject name: ");
                     String name = scanner.nextLine();
                     System.out.print("Enter credit hour: ");
                     int creditHour = scanner.nextInt();
                     try {
                         Subject subject = new Subject(name, creditHour);
                         subjects.add(subject);
                         System.out.println("Subject added successfully!");
                     } catch (IllegalArgumentException e) {
                         System.out.println(e.getMessage());
                     }
                     break;
                 case 2:
                     if (subjects.isEmpty()) {
                         System.out.println("No subjects available.");
                     } else {
                         for (Subject subject : subjects) {
                             System.out.println(subject);
                         }
                     }
                     break;
                 case 3:
                     System.out.println("Exiting...");
                     break;
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         } while (choice != 3);
 
         scanner.close();
     }
     } 