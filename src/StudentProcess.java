import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentProcess {
    public static void main(String[] args) {

        Student[] students = { new Student("Jack", "Smith", 50.0, "IT"), new Student("Aaron", "Johnson", 76.0, "IT"),
                new Student("Maaria", "White", 35.8, "Business"), new Student("John", "White", 47.0, "Media"),
                new Student("Laney", "White", 62.0, "IT"), new Student("Jack", "Jones", 32.9, "Business"),
                new Student("Wesley", "Jones", 42.89, "Media") };

        List<Student> studentsList = new ArrayList<>(Arrays.asList(students));

        getAllStudents(studentsList);

        getGradesFiftyToHundred(studentsList);

        getFirstGradeFiftyToHundred(studentsList);

        sortByName(studentsList);

        getUniqueLastNames(studentsList);

        getGroupedByDepartments(studentsList);

        getNumbersByDepartments(studentsList);

        getSumOfGrades(studentsList);

        getAvarageOfGrades(studentsList);
    }

    public static void getAllStudents(List<Student> studentsList) {
        bannerCreator("All Of The Students");
        studentsList.stream().forEach(System.out::println);
    }

    /**
     * Filters students who had mark between 50 and 100 then sorts it by their grade
     * returns Stream type
     */
    public static void getGradesFiftyToHundred(List<Student> studentsList) {
        bannerCreator("Students who got a grade between 50 and 100");
        studentsList.stream().filter(s -> s.getGrade() < 100 && s.getGrade() >= 50)
                .sorted((s1, s2) -> Double.valueOf(s1.getGrade()).compareTo(s2.getGrade()))
                .forEach(System.out::println);
        ;
    }

    /**
     * Filters students who had mark between 50 and 100 then sorts it by their grade
     * at last finds the first element in stream returns optional type
     */
    public static void getFirstGradeFiftyToHundred(List<Student> studentsList) {
        bannerCreator("First Student who got a grade between 50 and 100");
        System.out.println(studentsList.stream().filter(s -> s.getGrade() < 100 && s.getGrade() >= 50)
                .sorted((s1, s2) -> Double.valueOf(s1.getGrade()).compareTo(s2.getGrade())).findFirst().get());
    }

    /**
     * Sorts last names then firstnames in ascending order with comparator class
     * then sorts it in descending order at last prints it one by one
     */
    public static void sortByName(List<Student> studentsList) {
        Comparator<Student> firstNameComparator = Comparator.comparing(Student::getFirstName);
        Comparator<Student> lastNameComparator = Comparator.comparing(Student::getLastName);
        bannerCreator("Lastname then firstname ascending");
        studentsList.stream().sorted(firstNameComparator).sorted(lastNameComparator).forEach(System.out::println);
        bannerCreator("Lastname then firstname descending");
        studentsList.stream().sorted(firstNameComparator.reversed()).sorted(lastNameComparator.reversed())
                .forEach(System.out::println);
    }

    /**
     * Displays all of the unique last names from the data then sorts and at last
     * prints it one by one
     */
    public static void getUniqueLastNames(List<Student> studentsList) {
        bannerCreator("Unique Last Names");
        studentsList.stream().map(s -> s.getLastName()).distinct().sorted().forEach(System.out::println);
        ;
    }

    public static void getGroupedByDepartments(List<Student> studentsList) {
        Map<String, List<Student>> studentsMap = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
        bannerCreator("IT Department");
        studentsMap.get("IT").forEach(System.out::println);
        bannerCreator("Media Department");
        studentsMap.get("Media").forEach(System.out::println);
        bannerCreator("Business Department");
        studentsMap.get("Business").forEach(System.out::println);
    }

    public static void getNumbersByDepartments(List<Student> studentsList) {
        Map<String, Long> counting = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        bannerCreator("Count Of Students By Departments");
        System.out.println("IT Department has " + counting.get("IT") + " students");
        System.out.println("Media Department has " + counting.get("Media") + " students");
        System.out.println("Business Department has " + counting.get("Business") + " students");
    }

    public static void getSumOfGrades(List<Student> studentsList) {
        bannerCreator("Sum Of All Grades");
        System.out.println(studentsList.stream().mapToDouble(s -> s.getGrade()).sum());
    }

    public static void getAvarageOfGrades(List<Student> studentsList) {
        DecimalFormat df = new DecimalFormat("0.00");
        bannerCreator("Avarage Of All Grades");
        System.out.println(df.format(studentsList.stream().mapToDouble(s -> s.getGrade()).average().getAsDouble()));
    }

    public static void bannerCreator(String title){
        System.out.println("----------------------------------");
        System.out.println(title);
        System.out.println("----------------------------------");
    }

}