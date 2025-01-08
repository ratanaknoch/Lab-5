package Task01;

public class Program {
    // Constant: Maximum credit hours allowed for a subject
    private static final int MAX_CREDITS = 6;

    // Instance variables
    private String subjectName;
    private String subjectCode;
    private int creditHours;

    // Constructor
    public Program(String subjectName, String subjectCode, int creditHours) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.creditHours = creditHours;
    }

    // Getters and Setters
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    /**
     * Sets the credit hours for the subject.
     * 
     * @param creditHours The number of credit hours for the subject.
     * @throws IllegalArgumentException if credit hours exceed MAX_CREDITS.
     */
    public void setCreditHours(int creditHours) {
        if (creditHours > MAX_CREDITS) {
            throw new IllegalArgumentException("Credit hours cannot exceed " + MAX_CREDITS);
        }
        this.creditHours = creditHours;
    }

    // Static getter for constant
    public static int getMaxCredits() {
        return MAX_CREDITS;
    }
}