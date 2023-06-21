package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWork {
    private Path pathExpression = Path.of("HistoryOfExpression.txt");
    private Path pathAnswers = Path.of("HistoryOfAnswers.txt");
    private List<String> Expressions= new ArrayList<>();
    private List<String> Answers= new ArrayList<>();

    public List<String> showHistoryExpresson() {
        try {
            if (!Files.exists(pathExpression)) {
                Files.createFile(pathExpression);
            }
            Expressions = Files.readAllLines(pathExpression);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Expressions;
    }

    public List<String> showHistoryAnswer() {
        try {
            if (!Files.exists(pathAnswers)) {
                Files.createFile(pathAnswers);
            }
            Answers = Files.readAllLines(pathAnswers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Answers;
    }

    public void writeExpresson(String expr) throws IOException {
        showHistoryExpresson();
        Expressions.add(expr);
        Files.write(pathExpression, Expressions);
    }

    public void writeAnswer(String answ) throws IOException {
        showHistoryAnswer();
        Answers.add(answ);
        Files.write(pathAnswers, Answers);
    }

    public String writeAnotherFile (String expr, String answ, String name) throws IOException {
        String way = name + ".txt";
        Path cd = Path.of(way);
        Files.createFile(cd);
        Files.write(cd, ("Уравнение: " + expr + " Ответ: " + answ).getBytes());
        return way;
    }
}
