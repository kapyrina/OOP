package Kalkulator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Control control = new Control();
        Scanner scanner = new Scanner(System.in);
        double result;
        int selectedAction = 0;
        String expr = "";

        while (selectedAction != 3){
            System.out.println();
            System.out.println("Меню:\n1. Решить уравнение\n2. История\n3. Выход");
            try {
                selectedAction = scanner.nextInt();
                System.out.println();
                if (selectedAction == 1) {
                    System.out.println("Введите уравнение, которе необходимо посчитать: ");
                    expr = scanner.next();
                    result = control.showUserChoise(selectedAction, expr);
                    System.out.println();
                    System.out.println("Ответ: " + result);
                    System.out.println();
                    System.out.println("Хотите ли вы сохранить уравнение с ответом в отдельном файле? (Да/Нет)");
                    String userChoise = scanner.next();
                    System.out.println();
                    if (userChoise.equals("Да")) {
                        System.out.println("Введите имя файла:");
                        String name = scanner.next();
                        name = control.saveFileEquation(expr, String.valueOf(result), name);
                        System.out.println("Файл сохранен в " + name + "\nПереход к меню...");
                    } else if (userChoise.equals("Нет")) {
                        System.out.println("Переход к меню...");
                    } else System.out.println("Введено неверное значение.\nПереход к меню...");
                } else if (selectedAction == 2) {
                    List<String> equ = control.sendHistoryOfEquations(), ans = control.sendHistoryOfAnsvers();
                    for (int i = 0; i < equ.size(); i++){
                        System.out.println("Уравнение: " + equ.get(i) + "\tОтвет: " + ans.get(i));
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
