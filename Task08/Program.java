package Task08;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;
 
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
                while (creditHours > MAX_CREDITS) {
                        System.out.print("Credit hours exceed " + MAX_CREDITS + ". Please re-enter credit hours: ");
                        Scanner scanner = new Scanner(System.in);
                        creditHours = scanner.nextInt();
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
class Session {
    private Subject subject;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location; // Add location attribute

    public Session(Subject subject, LocalTime startTime, LocalTime endTime, String location) {
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;  // Initialize location
    }


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }




    @Override
    public String toString() {
        return "Session{" +
                subject +
                ", startTime= " + startTime +
                ", endTime= " + endTime +
                ", location='" + location + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(subject, session.subject) && Objects.equals(startTime, session.startTime) && Objects.equals(endTime, session.endTime) && Objects.equals(location, session.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, startTime, endTime, location);
    }
}


 /**
  * The Program class provides a menu-driven interface to manage subjects.
  */
 public class Program {
     public static void main(String[] args) {
         ArrayList<Subject> subjects = new ArrayList<>();
         ArrayList<Session> sessions = new ArrayList<>();
         Scanner scanner = new Scanner(System.in);
         int choice;
 
         do {
             System.out.println("1. Add Subject");
             System.out.println("2. View Subjects");
             System.out.println("3. Add Session");
             System.out.println("4. View Sessions"); // New menu option
             System.out.println("5. Exit"); // New menu option
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
                 case 5:
                     System.out.println("Exiting...");
                     break;
                 case 3: 
                 System.out.print("Enter subject name for the session: ");
                 String subjectName = scanner.nextLine();

                 // Find the Subject object based on the entered name
                 Subject sessionSubject = null;
                 for (Subject s : subjects) {
                 if (s.getSubjectName().equals(subjectName)) {
                 sessionSubject = s;
                 break;
                 
        }
    }

                 if (sessionSubject == null) {
                 System.out.println("Subject not found. Please add the subject first.");
    } else {
    System.out.print("Enter start time (HH:MM): ");
    String startTimeStr = scanner.nextLine();
    System.out.print("Enter end time (HH:MM): ");
    String endTimeStr = scanner.nextLine();
    System.out.print("Enter Location: ");
    String location = scanner.nextLine();

    try {
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);

        // Validate that end time is after start time (optional)
        if (endTime.isBefore(startTime)) {
            System.out.println("End time cannot be before start time.");
            break; // Exit the case if invalid input
        }

        // Create and add the session
        Session newSession = new Session(sessionSubject, startTime, endTime, location);
        sessions.add(newSession);
        System.out.println("Session added successfully!");
    } catch (DateTimeParseException e) {
        System.out.println("Invalid time format. Please use HH:MM.");
    }
}
break;
            case 4:  
            if (sessions.isEmpty()) {
                System.out.println("No sessions available.");
            } else {
                for (Session session : sessions) {
                    System.out.println(session);
                }
            }
            break;       
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         } while (choice != 5);
 
         scanner.close();
     }
     } 