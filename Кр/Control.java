package Kalkulator;

import Model.Calc;
import Model.FileWork;

import java.io.IOException;
import java.util.List;

public class Control {

    Calc calc = new Calc();
    FileWork fileWork = new FileWork();

    public double showUserChoise (int flag, String expr) throws IOException {
        double result = calc.solveEquation(expr);
        fileWork.writeExpresson(expr);
        fileWork.writeAnswer(String.valueOf(result));
        return result;
    }

    public String saveFileEquation(String expr, String answ, String name) throws IOException {
        return fileWork.writeAnotherFile(expr, answ, name);
    }

    public List<String> sendHistoryOfEquations(){
        return fileWork.showHistoryExpresson();
    }

    public List<String> sendHistoryOfAnsvers(){
        return fileWork.showHistoryAnswer();
    }
}
