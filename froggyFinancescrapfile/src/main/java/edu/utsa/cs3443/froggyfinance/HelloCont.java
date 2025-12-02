package edu.utsa.cs3443.froggyfinance;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.util.Stack;

public class HelloCont {

    private Stage stage;
    private Scene previousScene;

    @FXML
    private TextField textField;

    public void setPreviousScene(Stage stage, Scene previousScene) {
        this.stage = stage;
        this.previousScene = previousScene;
    }

    @FXML
    private void onExitButtonClick() {
        if (stage != null && previousScene != null) {
            stage.setScene(previousScene);
        }
    }

    // Number buttons
    @FXML private void one() { appendText("1"); }
    @FXML private void two() { appendText("2"); }
    @FXML private void three() { appendText("3"); }
    @FXML private void four() { appendText("4"); }
    @FXML private void five() { appendText("5"); }
    @FXML private void six() { appendText("6"); }
    @FXML private void seven() { appendText("7"); }
    @FXML private void eight() { appendText("8"); }
    @FXML private void nine() { appendText("9"); }
    @FXML private void zero() { appendText("0"); }
    @FXML private void dec() { appendText("."); }

    // Operators
    @FXML private void plus() { appendText("+"); }
    @FXML private void min() { appendText("-"); }
    @FXML private void mult() { appendText("*"); }
    @FXML private void div() { appendText("/"); }

    // Calculator actions
    @FXML private void equal() {
        if (textField != null && !textField.getText().isEmpty()) {
            try {
                double result = evaluate(textField.getText());
                textField.setText(String.valueOf(result));
            } catch (Exception e) {
                textField.setText("Error");
            }
        }
    }

    @FXML private void clear() { textField.setText(""); }

    @FXML private void pos() {
        if (textField != null && !textField.getText().isEmpty()) {
            String value = textField.getText();
            if (value.startsWith("-")) textField.setText(value.substring(1));
            else textField.setText("-" + value);
        }
    }

    @FXML private void sqrt() {
        if (textField != null && !textField.getText().isEmpty()) {
            try {
                double val = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.sqrt(val)));
            } catch (NumberFormatException e) {
                textField.setText("Error");
            }
        }
    }

    @FXML private void expo() {
        if (textField != null && !textField.getText().isEmpty()) {
            textField.setText(textField.getText() + "^");
        }
    }

    private void appendText(String s) {
        if (textField != null) {
            if ("0".equals(textField.getText()) || textField.getText().equals("Error")) textField.setText(s);
            else textField.setText(textField.getText() + s);
        }
    }

    // -----------------------
    // Simple evaluator for + - * / only
    private double evaluate(String expr) {
        // Remove spaces
        expr = expr.replaceAll("\\s", "");
        Stack<Double> numbers = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;
        while (i < expr.length()) {
            char c = expr.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    sb.append(expr.charAt(i++));
                }
                numbers.push(Double.parseDouble(sb.toString()));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char op = ops.pop();
                    numbers.push(applyOp(a, b, op));
                }
                ops.push(c);
                i++;
            } else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }
        while (!ops.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char op = ops.pop();
            numbers.push(applyOp(a, b, op));
        }
        return numbers.pop();
    }

    private int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    private double applyOp(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
}
