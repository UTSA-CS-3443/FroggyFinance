package lab2apps.calculator;

/*import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

import javax.swing.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    private double result;
    private String firstNumber = "";
    private String currentNumber = "";
    private String calculationType;
    private Text savedNumbers;
    private JButton button1;
    private boolean Number = true;

    @FXML
    private TextField textField;

    public void clearAction(ActionEvent event) {
        if (Number) {
            if (firstNumber.equals("")) {
                textField.setText("");
                calculationType = "";
                Number = true;
                firstNumber = "";
                currentNumber = "";
                updateTextField();
            } else {
                firstNumber = "";
            }
        } else {
            if (currentNumber.equals("")) {
                textField.setText("");
                calculationType = "";
                Number = true;
                firstNumber = "";
                currentNumber = "";
                updateTextField();
            } else {
                currentNumber = "";
            }
        }

        updateTextField();
    }

    public void equalAction(ActionEvent event) {
        //solve();
    }

    public void posAction(ActionEvent event) {
        if (Number) {

            if (firstNumber.contains("-")) {
                firstNumber = firstNumber.substring(1);
            } else {
                firstNumber = "-" + firstNumber;
            }

        } else {

            if (currentNumber.contains("-")) {
                currentNumber = currentNumber.substring(1);
            } else {
                currentNumber = "-" + currentNumber;
            }

        }
        updateTextField();
    }

    public void decAction(ActionEvent event) {
        if (Number) {
            if (!firstNumber.contains("."))
                firstNumber = firstNumber + ".";
        } else {
            if (!currentNumber.contains("."))
                currentNumber = currentNumber + ".";
        }
        updateTextField();
    }

    public void plus(ActionEvent event) {
        calculationType = "+";
        Number = false;
        updateScreen();
    }

    public void min(ActionEvent event) {
        calculationType = "-";
        Number = false;
        updateTextField();
    }

    public void mult(ActionEvent event) {
        calculationType = "*";
        Number = false;
        updateTextField();
    }

    public void div(ActionEvent event) {
        calculationType = "/";
        Number = false;
        updateTextField();
    }

    @FXML
    void addAction(ActionEvent event) {
        calculationSetup("+");
    }
    void multiplyAction(ActionEvent event) {
        calculationSetup("*");
    }
    void minusAction(ActionEvent event) {
        calculationSetup("-");
    }
    void divideAction(ActionEvent event) {
        calculationSetup("/");
    }

    public void calculationSetup(String CalculationType) {
        this.calculationType = CalculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
    }
    @FXML
    void calculate(ActionEvent event) {
        int firstNumberInt = Integer.parseInt(firstNumber);
        int currentNumberInt = Integer.parseInt(currentNumber);

        switch (calculationType) {
            case "+": {
                int result = firstNumberInt + currentNumberInt;
                savedNumbers.setText(String.valueOf(result));
                textField.setText(String.valueOf(result));
                break;
            }
            case "-": {
                int result = firstNumberInt - currentNumberInt;
                savedNumbers.setText(String.valueOf(result));
                textField.setText(String.valueOf(result));
                break;
            }
            case "*": {
                int result = firstNumberInt * currentNumberInt;
                savedNumbers.setText(String.valueOf(result));
                textField.setText(String.valueOf(result));
                break;
            }
            case "÷": {
                int result = firstNumberInt / currentNumberInt;
                savedNumbers.setText(String.valueOf(result));
                textField.setText(String.valueOf(result));
                break;
            }
        }
    }

    @FXML
    private void initialize() {}

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }

    @FXML
    protected void one(ActionEvent event) { addNumber("1");}
    @FXML
    protected void two(ActionEvent event) { addNumber("2");}
    @FXML
    protected void three(ActionEvent event) { addNumber("3");}
    @FXML
    protected void four(ActionEvent event) { addNumber("4");}
    @FXML
    protected void five(ActionEvent event) { addNumber("5");}
    @FXML
    protected void six(ActionEvent event) { addNumber("6");}
    @FXML
    protected void seven(ActionEvent event) { addNumber("7");}
    @FXML
    protected void eight(ActionEvent event) { addNumber("8");}
    @FXML
    protected void nine(ActionEvent event) { addNumber("9");}
    @FXML
    void zero(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("0");
        }
    }


    private void updateScreen(){
        if (Number){
            textField.setText(firstNumber);
        } else {
            textField.setText(calculationType + " " + currentNumber);
        }
    }
    @FXML
    public void updateTextField() { textField.setText(currentNumber); }
    public void addNumber(String number) {
        currentNumber = currentNumber + number;
        updateTextField();
    }
}
*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Controller class for a simple calculator application using JavaFX.
 * Handles all button events and updates the screen accordingly.
 */
public class HelloController {

    @FXML
    private TextField textField;

    private boolean justCalculated = false;

    private String n1 = "";
    private String n2 = "";
    private String lastN2 = "";
    private boolean firstNumber = true;
    private String operator = "";
    private String lastOperator = "";
    private double lastResult = 0;

    /**
     * Exits the application.
     */
    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }

    /**
     * Clears the current input depending on which number is being entered.
     *
     * @param event The ActionEvent triggered by the clear button.
     */
    public void clear(ActionEvent event) {
        if (firstNumber) {
            if (n1.equals("")) {
                textField.setText("");
                operator = "";
                firstNumber = true;
                n1 = "";
                n2 = "";
                updateScreen();
            } else {
                n1 = "";
            }
        } else {
            if (n2.equals("")) {
                textField.setText("");
                operator = "";
                firstNumber = true;
                n1 = "";
                n2 = "";
                updateScreen();
            } else {
                n2 = "";
            }
        }

        updateScreen();
    }

    /**
     * Triggers calculation based on the current operator and numbers.
     *
     * @param event The ActionEvent triggered by the equal button.
     */
    public void equal(ActionEvent event) {
        calculate();
    }

    /**
     * Toggles the sign (+/-) of the current number being entered.
     * @param event The ActionEvent triggered by the pos button.
     */
    public void pos(ActionEvent event) {
        // Case: after calculation, allow toggling result sign
        if (!firstNumber && n2.isEmpty()) {
            if (!n1.isEmpty()) {
                if (n1.startsWith("-")) {
                    n1 = n1.substring(1);
                } else {
                    n1 = "-" + n1;
                }
            }
            // Reset the operator if user is just toggling sign of the result
            operator = "";
            firstNumber = true;
        } else if (firstNumber) {
            if (!n1.isEmpty()) {
                if (n1.startsWith("-")) {
                    n1 = n1.substring(1);
                } else {
                    n1 = "-" + n1;
                }
            }
        } else {
            if (!n2.isEmpty()) {
                if (n2.startsWith("-")) {
                    n2 = n2.substring(1);
                } else {
                    n2 = "-" + n2;
                }
            }
        }

        updateScreen();
    }

    /**
     * Adds a decimal point to the current number.
     * @param event The ActionEvent triggered by the decimal button.
     */
    public void dec(ActionEvent event) {
        if (firstNumber) {
            if (!n1.contains("."))
                //textField.setText("." + n1 + "");
                n1 += ".";
        } else {
            if (!n2.contains("."))
                //textField.setText("." + n1 + "" +operator + n2);
                n2 += ".";
        }
        updateScreen();
    }

    /** Sets operator to addition. */
    public void plus(ActionEvent event) {
        operator = "+";
        firstNumber = false;
        updateScreen();
    }

    /** Sets operator to subtraction. */
    public void min(ActionEvent event) {
        operator = "-";
        firstNumber = false;
        updateScreen();
    }

    /** Sets operator to multiplication. */
    public void mult(ActionEvent event) {
        operator = "*";
        firstNumber = false;
        updateScreen();
    }

    /** Sets operator to division. */
    public void div(ActionEvent event) {
        operator = "/";
        firstNumber = false;
        updateScreen();
    }

    /**
     * Sets operator to exponentiation.
     *
     * @param event The ActionEvent triggered by the exponent button.
     */
    public void expo(ActionEvent event) {
        /*try {
            if (firstNumber) {
                if (!n1.isEmpty()) {
                    double result = Math.pow(Double.parseDouble(n1), Integer.parseInt(n2));
                    n1 = String.valueOf(result);
                    updateScreen(n1);
                }
            } else if (!firstNumber) {
                if (!n2.isEmpty()) {
                    double result = Math.sqrt(Double.parseDouble(n2));
                    n2 = String.valueOf(result);
                    updateScreen(n1 + operator + n2);
                }
            }
            else {
                updateScreen("Error");
            }
        } catch (NumberFormatException e) {
            updateScreen("Error");
        }*/
        operator = "^";
        firstNumber = false;
        updateScreen();
    }

    /**
     * Calculates the square root of the current number (n1 or n2).
     *
     * @param event The ActionEvent triggered by the sqrt button.
     */
    public void sqrt(ActionEvent event) {
        try {
            if (firstNumber) {
                if (!n1.isEmpty()) {
                    double result = Math.sqrt(Double.parseDouble(n1));
                    n1 = String.valueOf(result);
                    updateScreen(n1);
                }
            }
            else if (n2.isEmpty()) {
                double result = Math.sqrt(Double.parseDouble(n1));
                n1 = String.valueOf(result);
                updateScreen(n1);
            }
            else if (!firstNumber) {
                if (!n2.isEmpty()) {
                    double result = Math.sqrt(Double.parseDouble(n2));
                    n2 = String.valueOf(result);
                    updateScreen(n1 + operator + n2);
                }
            }
            else {
                updateScreen("Error");
            }
        } catch (NumberFormatException e) {
            updateScreen("Error");
        }
    }

    /** Appends 0 to the current number. */
    public void zero(ActionEvent event) {
        if (justCalculated) {
            n1 = "0";
            operator = "";
            n2 = "";
            firstNumber = true;
            justCalculated = false;
        }
        else if (firstNumber) {
            n1 += "0";}
        else{
            n2 += "0";}
        updateScreen();
    }

    /** Appends 1 to the current number. */
    public void one(ActionEvent event) {
        if (justCalculated) {
            n1 = "0";
            operator = "";
            n2 = "";
            firstNumber = true;
            justCalculated = false;
        }
        else if (firstNumber) {
            n1 += "1";}
        else {
            n2 += "1";}
        updateScreen();
    }

    /** Appends 2 to the current number. */
    public void two(ActionEvent event) {
        if (justCalculated) {
            n1 = "2";
            operator = "";
            n2 = "";
            firstNumber = true;
            justCalculated = false;
        } else if (firstNumber)
            n1 += "2";
        else
            n2 += "2";
        updateScreen();
    }

    /** Appends 3 to the current number. */
    public void three(ActionEvent event) {
        if (justCalculated) {
            n1 = "3";
            operator = "";
            n2 = "";
            firstNumber = true;
            justCalculated = false;
        }else if (firstNumber)
            n1 += "3";
        else
            n2 += "3";
        updateScreen();
    }

    /** Appends 4 to the current number. */
    public void four(ActionEvent event) {
        if (justCalculated) {
            n1 = "4";
            operator = "";
            n2 = "";
            firstNumber = true;
            justCalculated = false;
        }
        else if (firstNumber)
            n1 += "4";
        else
            n2 += "4";
        updateScreen();
    }

    /** Appends 5 to the current number. */
    public void five(ActionEvent event) {
        if (justCalculated) {
            n1 = "5";
            operator = "";
            n2 = "";
            firstNumber = true;
            justCalculated = false;
        }
        else if (firstNumber)
            n1 += "5";
        else
            n2 += "5";
        updateScreen();
    }

    /** Appends 6 to the current number. */
    public void six(ActionEvent event) {
        if (justCalculated) {
            n1 = "6";
            operator = "";
            n2 = "";
            firstNumber = true;
            justCalculated = false;
        } else if (firstNumber)
            n1 += "6";
        else
            n2 += "6";
        updateScreen();
    }

    /** Appends 7 to the current number. */
    public void seven(ActionEvent event) {
        if (justCalculated) {
            n1 = "7";
            operator = "";
            n2 = "";
            firstNumber = true;
            justCalculated = false;
        } else if (firstNumber)
            n1 += "7";
        else
            n2 += "7";
        updateScreen();
    }

    /** Appends 8 to the current number. */
    public void eight(ActionEvent event) {
        if (justCalculated) {
            n1 = "8";
            operator = "";
            n2 = "";
            firstNumber = true;
            justCalculated = false;
        }else if (firstNumber)
            n1 += "8";
        else
            n2 += "8";
        updateScreen();
    }

    /** Appends 9 to the current number. */
    public void nine(ActionEvent event) {
        if (justCalculated) {
            n1 = "9";
            operator = "";
            n2 = "";
            firstNumber = true;
            justCalculated = false;
        }else if (firstNumber)
            n1 += "9";
        else
            n2 += "9";
        updateScreen();
    }

    /**
     * Updates the display based on the current operands and operator.
     */
    private void updateScreen(){
        if (firstNumber){
            textField.setText(n1);
        }
        else {
            textField.setText(n1 + operator + n2);
        }
    }

    /**
     * Updates the display with a specific string.
     *
     * @param s The string to be displayed.
     */
    private void updateScreen(String s) {
        textField.setText(s);
    }

    /**
     * Performs the calculation using the current operator and operands.
     */
    private void calculate() {
        if (n2.equals(""))
            n2 = lastN2;
        if (!n2.equals("") && !n1.equals("")) {
            if (operator.equals(""))
                operator = lastOperator;

            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);

            switch (operator) {
                case "+":
                    lastResult = num1 + num2;
                    updateScreen(String.valueOf(lastResult));
                    break;
                case "-":
                    lastResult = num1 - num2;
                    updateScreen(String.valueOf(lastResult));
                    break;
                case "*":
                    lastResult = num1 * num2;
                    updateScreen(String.valueOf(lastResult));
                    break;
                case "/":
                    lastResult = num1 / num2;
                    updateScreen(String.valueOf(lastResult));
                    break;
                case "^":
                    lastResult = Math.pow(num1, num2);
                    updateScreen(String.valueOf(lastResult));
                    n2 = "";
                    operator = "";
                    break;
                case "√":
                    /*try {
                        if (firstNumber) {
                            if (!n1.isEmpty()) {
                                double result = Math.sqrt(Double.parseDouble(n1));
                                n1 = String.valueOf(result);
                                updateScreen(n1);
                            }
                        } else if (!firstNumber) {
                            if (!n2.isEmpty()) {
                                double result = Math.sqrt(Double.parseDouble(n2));
                                n2 = String.valueOf(result);
                                updateScreen(n1 + operator + n2);
                            }
                        }
                        else {
                            updateScreen("Error");
                        }
                    } catch (NumberFormatException e) {
                        updateScreen("Error");
                    }*/
                    lastResult = Math.sqrt(Double.parseDouble(lastN2));
                    updateScreen(String.valueOf(lastResult));
            }

            lastN2 = n2;
            lastOperator = operator;

            n1 = String.valueOf(lastResult);
            n2 = "";
            firstNumber = false;
        }
    }
}
