import java.util.Scanner;

public class StudentGrades2 {
        
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            System.out.print("Введите количество студентов: ");

    int numStudents = input.nextInt();
            System.out.print("Введите количество дисциплин: ");
        
    int numSubjects = input.nextInt();

        String[] studentNames = new String[numStudents];
        String[] subjectNames = new String[numSubjects];
    int[][] grades = new int[numStudents][numSubjects];

    // Ввод имен студентов
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Введите ФИО студента " + (i + 1) + ": ");
            studentNames[i] = input.next();
        }

    // Ввод названий предметов
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Введите название предмета " + (i + 1) + ": ");
            subjectNames[i] = input.next();
        }

    // Ввод оценок студентов
        for (int i = 0; i < numStudents; i++) {
        for (int j = 0; j < numSubjects; j++) {
            System.out.print("Введите оценку " + subjectNames[j] + " для студента " + studentNames[i] + ": ");
            grades[i][j] = input.nextInt();
            }
        }

    // Расчет среднего балла для каждого студента
       double[] avgGrades = new double[numStudents];
            for (int i = 0; i < numStudents; i++) {
            int sum = 0;
            
            for (int j = 0; j < numSubjects; j++) {
            sum += grades[i][j];
            }
            
        avgGrades[i] = (double) sum / numSubjects;
        }

    // Вывод таблицы оценок и среднего балла
        System.out.print("\n");
        System.out.print("Имя студента\t");
            for (int i = 0; i < numSubjects; i++) {
            System.out.print(subjectNames[i] + "\t");
            }
            
        System.out.print("Средний балл\n");

        for (int i = 0; i < numStudents; i++) {
            System.out.print(studentNames[i] + "\t\t");
        for (int j = 0; j < numSubjects; j++) {
            System.out.print(grades[i][j] + "\t\t");
            }
            System.out.print(avgGrades[i] + "\n");
            }

    // Расчет статистики успеваемости
            int numExcellent = 0;
            int numGood = 0;
            int numSatisfactory = 0;
            int numUnsatisfactory = 0;

            for (int i = 0; i < numStudents; i++) {
                if (avgGrades[i] >= 4.5) {
                numExcellent++;
            } else if (avgGrades[i] >= 3.5) {
            numGood++;
            } else if (avgGrades[i] >= 2.5) {
            numSatisfactory++;
            } else {
            numUnsatisfactory++;
        }
    }

            // Вывод статистики успеваемости
        System.out.println("\nСтатистика успеваемости:");
        System.out.println("Отличники: " + numExcellent);
        System.out.println("Хорошисты: " + numGood);
        System.out.println("Удовлетворительно: " + numSatisfactory);
        System.out.println("Неудовлетворительно: " + numUnsatisfactory);
    }
}
