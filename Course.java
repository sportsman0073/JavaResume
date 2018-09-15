/**
 * Course
 *
 * Abstraction of a college course. Each course is uniquely identifiable by its course name.
 *
 * @author Nicholas Koontz
 *
 * @version date of completion
 *
 */

public class Course {
    /**
     * Maximum number of students allowed to be enrolled in a Course
     */
    protected final static int MAX_STUDENTS = 100;

    private String name;
    private Professor professor;
    private Teacher[] teachers;
    private Student[] students;

    /**
     * Constructs a Course object with the corresponding parameters as its name and a reference to the lead Professor.
     * Creates an array to contain at most 100 students enrolled in the course and ensures the Professor adds the course
     * to their list of courses.
     *
     * @param name Name of the Course to be offered.
     * @param professor A reference to the lead professor for the course.
     */
    public Course(String name, Professor professor) {
        //TODO: Initialize field variables for this Course object
        this.name = name;
        this.professor = professor;
        professor.addCourse(this);
        this.teachers = new Teacher[5];
        this.students = new Student[MAX_STUDENTS];
    }

    /**
     * Adds student to the course. Throws AddToCourseException if the course is full, if student is null, or
     * if the student is already enrolled in the course
     *
     * @param student Student to be added to the Course
     * @throws AddToCourseException If the course is full, if student is null, or if the student is already enrolled in
     * the course
     */
    public void addStudent(Student student) throws AddToCourseException {
        //TODO: Add student to Course, if possible

        for (int i = 0; i < students.length; i++) {
            if (student != null && students[i] == null) {
                        this.students[i] = student;
                        return;
            }else if((student != null) && students[i] != null && this.students[i].equals(student)){
                throw new AddToCourseException("You are already in the course!");
            }

        }
        throw new AddToCourseException("The course is full.");

    }

    /**
     * Removes student from the course. Throws DropFromCourseException if student is null or if the student
     * is not enrolled in the course.
     *
     * @param student Student to be removed from the course
     * @throws DropFromCourseException If student is null or if the student is not enrolled in the course.
     */
    public void dropStudent(Student student)throws DropFromCourseException{
        //TODO: Remove student from Course, if possible
        for (int i = 0; i < students.length; i++) {

            if(students[i] != null && students[i].equals(student)){
                this.students[i] = null;
                return;
            }
        }
        throw new DropFromCourseException("You are not in the course!");

    }

    /**
     * Adds teacher to the course. If the teachers array is full, then its size is doubled and the teacher is added.
     * A Teacher may teach the same course more than once (like having multiple sections). Throws AddToCourseException
     * if teacher is null. The teacher should add this course to their personal list of courses.
     *
     * @param teacher Teacher to be added to the Course
     * @throws AddToCourseException If the course is full or if teacher is null
     */
    public void addTeacher(Teacher teacher) throws AddToCourseException {
        //TODO: Add teacher to Course, if possible, and add Course to teacher's array of Courses.
        if(teacher == null){
            throw new AddToCourseException("Please enter an actual teacher's name");
        }else{
            for (int i = 0; i < teachers.length ; i++) {

                if (teachers[i] == null) {
                    teachers[i] = teacher;
                    teacher.addCourse(this);
                    return;
                }
            }
            Teacher temp[] = new Teacher[teachers.length*2];
            for (int i = 0; i < teachers.length; i++) {
                temp[i] = teachers[i];
            }
            this.teachers = temp;
            for (int i = 0; i < teachers.length ; i++) {

                if (teachers[i] == null) {
                    teachers[i]=teacher;
                    teacher.addCourse(this);
                    break;

                }
            }

        }


    }

    /**
     * Removes teacher from the courses's array of teachers. If teacher teaches multiple instances of the
     * course, only one is removed. Throws DropFromCourseException if teacher is null or if teacher is not found.
     *
     * @param teacher Teacher to be added to the Course
     * @throws DropFromCourseException Uf teacher is null or if teacher is not found.
     */
    public void dropTeacher(Teacher teacher)throws DropFromCourseException{
        //TODO: Remove teacher from Course, if possible, and remove Course from teacher's array of Courses.
        for (int i = 0; i < teachers.length; i++) {
            if (teacher != null && teachers[i] != null && teachers[i].equals(teacher)) {
                teacher.dropCourse(this);
                teachers[i] = null;
                return;
            }

        }
        throw new DropFromCourseException("This Teacher does not teach this course please insert another teacher's name!");

    }

    /**
     * @return Reference to Professor leading this Course
     */
    public Professor getProfessor() {
        //TODO: Return a reference to the Professor for this course.
        this.professor.addCourse(this);
        return this.professor;
    }

    /**
     * Creates and returns a new array containing the list of Students. The new array should have a length equal to the
     * number of students currently enrolled in the course. Returns an array of length 0 if the course has no Students.
     *
     * @return A new array containing the Course's Students with no null elements.
     */
    public Student[] getRoster() {
        //TODO: Create and return a new array containing references to each Student in this course's Student array
        int count = 0;

        for (int i = 0; i < students.length; i++) {
            if(students[i] != null){
                count++;
            }
        }

        Student[] roster = new Student[count];
        for (int i = 0, j = 0; i < students.length; i++) {
            if(students[i] != null) {
                roster[j++] = students[i];
            }
        }
        return roster;
    }

    /**
     * @return The name of the Course
     */
    public String getName() {
        //TODO: Return the name of this course

        return this.name;
    }

    /**
     * Returns a new array containing the Courses's Teachers. The new array should have a length equal to the
     * number of Teachers currently teaching the course, duplicates included. Returns an array of length 0 if the course
     * has no Teachers.
     *
     * @return A new array containing the Course's Teachers with no null elements.
     */
    public Teacher[] getTeachers() {
        //TODO: Create and return a new array containing references to each Teacher in this course's Teacher array, including duplicates
        Teacher[] courseTeachers = new Teacher[teachers.length];
        if(teachers.length == 0){
            return courseTeachers;
        }else {
            for (int i = 0; i < teachers.length; i++) {
                if(teachers[i] != null) {
                    courseTeachers[i] = this.teachers[i];
                }
            }
        }return courseTeachers;


    }

    /**
     * Makes professor the Course professor and updates the old and new Professors involved accordingly.
     *
     * @param professor Reference to Professor object to be made the lead Professor of the course.
     */
    public void changeProfessor(Professor professor) {
        //TODO: Change the Professor for this Course and add/remove the course from the respective Professor's arrays of courses
        professor.addCourse(this);
        this.professor.dropCourse(this);
        this.professor = professor;


    }

    /**
     * Returns a String representation of the Course object. This method must exist, but will not be tested.
     *
     * @return String
     */
    public String toString() {
        return "";
    }
}
