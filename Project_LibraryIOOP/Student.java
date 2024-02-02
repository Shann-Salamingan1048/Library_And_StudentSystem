package Project_LibraryIOOP;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Student extends Library implements student_responsibility{
    private int LRN;
    private int Tuition_fee;
    private HashMap<String, Integer> Grades_subjects = new HashMap<>();
    private Address Address; // Objects of Objects
    private int Student_age;
    private String Student_name;
    private int Student_school_ID;
    private String Grade_level;
    public void addGrades_subjects(String sub, Integer grade){this.Grades_subjects.put(sub, grade);}
    public HashMap<String, Integer> getGrades_subjects(){ return Grades_subjects;}
    public void removeGrades_subjects(String sub){ this.Grades_subjects.remove(sub);}
    public void modifyGrades_subjects(String sub, int grade){ this.Grades_subjects.replace(sub,grade);}
    public void findSubs_Specific_grade(int grade){
        int count_subs_specific_grade = 0;
        HashMap<String,Integer> print_specific_grade = new HashMap<>();
        for (Map.Entry<String, Integer> entry : Grades_subjects.entrySet()) {
            if (entry.getValue() == grade) {
                print_specific_grade.put(entry.getKey(),entry.getValue());
                count_subs_specific_grade++;
            }
        }
        String are_or_is = (count_subs_specific_grade > 1) ? "There are " : "There is ";
        String subject_or_subjects = (count_subs_specific_grade > 1) ? " subjects " : " subject ";

        System.out.println(are_or_is + count_subs_specific_grade + subject_or_subjects + "that have a grade of " + grade);
        for(String i : print_specific_grade.keySet())
            System.out.println(i + " = " + print_specific_grade.get(i));
    }
    public void clear_all_grade(){this.Grades_subjects.clear();}

    public void setGrade_level(String gradeLevel){this.Grade_level = gradeLevel;}
    public String getGrade_level(){return Grade_level;}
    public void setLRN(int lrn){this.LRN = lrn;}
    public int getLRN(){return LRN;}
    public void setTuition_fee(int tuition_fee){ this.Tuition_fee = tuition_fee;}
    public int getTuition_fee(){ return Tuition_fee; }

    Student(){
        super();
        this.LRN = 0;
        this.Tuition_fee = 0;
        this.Grade_level = "Unknown";
        this.Grades_subjects.put("Unknown", 0);
        this.Address = new Address(); // empty
    }
    Student(String student_name, int tuition_fee, int lrn, int student_age, int student_school_ID, String gradelevel, HashMap<String, Integer> grades_subjects, Address address){
        super(student_age,student_name,student_school_ID);
        this.LRN = lrn;
        this.Tuition_fee = tuition_fee;
        this.Grade_level = gradelevel;
        this.Grades_subjects = grades_subjects;
        this.Address = address; // Objects of Objects
    }
    public void getAddress(){ // Objects of Objects, Start of Address
        System.out.printf("%-15s%-15s%n","Address: ", Address.getCity() + ", " + Address.getStreet() + ", " + Address.getZipcode());
    }
    public void setCity(String city){this.Address.setCity(city);}
    public String getCity(){return Address.getCity();}
    public void setStreet(String street){this.Address.setStreet(street);}
    public String getStreet(){return Address.getStreet();}
    public void setZipcode(int zipcode){this.Address.setZipcode(zipcode);}
    public int getZipcode(){return Address.getZipcode();}
    // end of Address
    public void IntroduceYourSelf(){
        System.out.printf("%-15s%-15s%n", "Name:", getBook_user_name());
        System.out.printf("%-15s%-15d%n", "Age:", getUser_age());
        System.out.printf("%-15s%-15s%n", "Grade level:", Grade_level);
        System.out.printf("%-15s%-15d%n", "LRN:", LRN);
    }
    public void grades_and_average(){
        String subject_or_subjects = (Grades_subjects.size() > 1) ? "Subjects:" : "Subject:";
        String grade_or_grades = (Grades_subjects.size() > 1) ? "Grades:" : "Grade:";
        System.out.printf("%-35s%-35s%n", subject_or_subjects , grade_or_grades);
        for(String i : Grades_subjects.keySet()){
            System.out.printf("%-35s%-35d%n", i, Grades_subjects.get(i));

        }
        System.out.printf("%-35s%-35d%n", "Average: ", average());
        System.out.println();
    }
    public void write_in_report_card() {
        try {
            FileWriter writer = new FileWriter("C:/Users/USER/Documents/1. Batak Time!/1. Coding/Java/Basta Java/src/Project_LibraryIOOP/Student_reportCard.txt", true);

            writer.write("Student Report Card\n");
            writer.append(String.format("%-35s%-35s%n", "Name:", getBook_user_name()));
            writer.append(String.format("%-35s%-35d%n", "Age:", getUser_age()));
            writer.append(String.format("%-35s%-35s%n", "Grade level:", Grade_level));
            writer.append(String.format("%-35s%-35d%n", "LRN:", LRN));
            writer.append("\n");
            String subject_or_subjects = (Grades_subjects.size() > 1) ? "Subjects:" : "Subject:";
            String grade_or_grades = (Grades_subjects.size() > 1) ? "Grades:" : "Grade:";
            writer.append(String.format("%-35s%-35s%n", subject_or_subjects, grade_or_grades));
            for (String subject : Grades_subjects.keySet()) {
                writer.append(String.format("%-35s%-35d%n", subject, Grades_subjects.get(subject)));
            }

            writer.append(String.format("%-35s%-35d%n", "Average: ", average()));
            writer.append("\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int average(){
        int sum = 0;
        for (int grade : Grades_subjects.values()) {
            sum += grade;
        }
        return sum / Grades_subjects.size();
    }
    public void read_reportCard(){
        try {
            FileReader reader = new FileReader("C:/Users/USER/Documents/1. Batak Time!/1. Coding/Java/Basta Java/src/Project_LibraryIOOP/Student_reportCard.txt");
            int data;
            while((data = reader.read())!= -1){ // put the (data = reader.read()) in while loop so that it will not do infinite loop
                // if it is -1 then it will stop the while loop
                System.out.print((char) data); // convert data into char
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
