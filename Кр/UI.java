import java.util.Scanner;
public class UI {

    public void ui(){
        rules();
        menu();
    }
    private void rules(){
        System.out.println("--------------------Правила ввода---------------------");
        System.out.println("-Числа и матеметические операторы вводить через пробел\n" +
                "Вводим пример таким образом: ( ( 7 + 8 * 23 / 2.5 ) ^ 23 )\n");
    };
    public void menu(){
        System.out.println("---------------------Калькулятор----------------------");
        System.out.println("Чтобы открыть прошлые вычисления нажмите 1");
        System.out.println("Чтобы получить решение нажмите 2");
        System.out.println("Чтобы выйти нажмите 9");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n==1 | n==2 | n==9) {
            if (n == 1) {
                PastCalculatins pastCalculatins = new PastCalculatins();
                pastCalculatins.pastUr();
            }
            if (n == 2) {
                EquationCalculations op = new EquationCalculations();
                op.enub();
            }
            if (n == 9) {
                System.out.println("Пока!");
                System.exit(0);
            }
        }
        else {
            System.out.println("Вы выбрали не существующие действие");
        }
    }
}
