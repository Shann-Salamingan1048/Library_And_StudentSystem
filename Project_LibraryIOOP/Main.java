package Project_LibraryIOOP;

import java.util.HashMap;

public class Main {
    public static void main(String [] args){
        HashMap<String, Integer> initial_grades_subs = new HashMap<>();
        initial_grades_subs.put("Computer Programming", 99);
        initial_grades_subs.put("Data Structure and Algorithms", 96);
     /*   Student s1 = new Student();
        s1.IntroduceYourSelf();
        s1.setUser_age(18);
        s1.BorrowBook();
     */
        Student s2 = new Student("Shann Delfin C. Salamingan III", 50000,8884129,19,9285,"Grade 11", initial_grades_subs, new Address("Surigao City", "Barangay San Juan", 8400));
/*
        s2.IntroduceYourSelf();
        s2.BuyBook(1000);
 */
/*
        s2.addGrades_subjects("Math", 98);
        s2.addGrades_subjects("Science", 99);
        s2.modifyGrades_subjects("Math", 100);
        s2.grades_and_average();
        s2.removeGrades_subjects("Science");
        s2.addGrades_subjects("English", 100);
        s2.addGrades_subjects("TLE", 100);
        s2.grades_and_average();
        s2.findSubs_Specific_grade(99);
        System.out.println();
        System.out.println(s2.getGrades_subjects());
        s2.clear_all_grade();
        s2.addGrades_subjects("Discrete Mathematics", 91);
        s2.grades_and_average();
        // s2.write_in_report_card();
        s2.read_reportCard();
        System.out.println(s2.getTuition_fee());
*/
        // s2.BorrowBook();
        // s2.Book1.setBook_price(1000);
        // s2.BuyBook(900);
        Student s3 = new Student();
        s3.addGrades_subjects("Math", 100);
        System.out.println(s3.getGrades_subjects());
        s3.removeGrades_subjects("Unknown");
        System.out.println(s3.getGrades_subjects());
        s2.setZipcode(9022);
        s2.IntroduceYourSelf();
        s2.getAddress();
        s3.getAddress();
    }
}
