package edu.utsa.cs3443.froggyfinance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for a simple JavaFX calculator.
 * <p>
 * This class manages all button interactions, maintains calculator state,
 * performs arithmetic operations, and updates the display field accordingly.
 * </p>
 */
public class HelloCont {

    /** Stage used to change scenes when exiting the calculator. */
    private Stage stage;

    /** The scene shown before opening this calculator window. */
    private Scene previousScene;

    /** Text field displaying current input and calculation results. */
    @FXML
    private TextField textField;

    /** Indicates whether the last operation performed was a calculation. */
    private boolean justCalculated = false;

    /** First operand of the calculation. */
    private String n1 = "";

    /** Second operand of the calculation. */
    private String n2 = "";

    /** Stores the previous n2 value to support repeated equals operations. */
    private String lastN2 = "";

    /** True when entering the first operand, false when entering the second. */
    private boolean firstNumber = true;

    /** Current operator the user has selected. */
    private String operator = "";

    /** Stores the previous operator to support repeated equals operations. */
    private String lastOperator = "";

    /** Stores the result of the most recent calculation. */
    private double lastResult = 0;

    /**
     * Sets the previous scene so that the calculator can return to it when exiting.
     *
     * @param stage the main application stage
     * @param previousScene the scene to return to on exit
     */
    public void setPreviousScene(Stage stage, Scene previousScene) {
        this.stage = stage;
        this.previousScene = previousScene;
    }

    /**
     * Handles the exit button click and returns to the previous scene.
     */
    @FXML
    private void onExitButtonClick() {
        if (stage != null && previousScene != null) {
            stage.setScene(previousScene);
        }
    }

    /**
     * Clears the current input. Clears n1 or n2 depending on the user's
     * current entry state. If all fields are empty, fully resets the calculator.
     *
     * @param event triggered by pressing the clear button
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
     * Executes the calculation when the equals button is pressed.
     *
     * @param event triggered by the equals button
     */
    public void equal(ActionEvent event) {
        calculate();
    }

    /**
     * Toggles the sign of the current operand.
     *
     * @param event triggered by pressing the +/- button
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
     * Adds a decimal point to the current number if one is not already present.
     *
     * @param event triggered by pressing the decimal button
     */
    public void dec(ActionEvent event) {
        if (firstNumber) {
            if (!n1.contains("."))
                n1 += ".";
        } else {
            if (!n2.contains("."))
                n2 += ".";
        }
        updateScreen();
    }

    /** Sets the operator to addition. */
    public void plus(ActionEvent event) {
        operator = "+";
        firstNumber = false;
        updateScreen();
    }

    /** Sets the operator to subtraction. */
    public void min(ActionEvent event) {
        operator = "-";
        firstNumber = false;
        updateScreen();
    }

    /** Sets the operator to multiplication. */
    public void mult(ActionEvent event) {
        operator = "*";
        firstNumber = false;
        updateScreen();
    }

    /** Sets the operator to division. */
    public void div(ActionEvent event) {
        operator = "/";
        firstNumber = false;
        updateScreen();
    }

    /**
     * Sets the operator to exponentiation.
     *
     * @param event triggered by pressing the exponent (^) button
     */
    public void expo(ActionEvent event) {
        operator = "^";
        firstNumber = false;
        updateScreen();
    }

    /**
     * Calculates and displays the square root of the current operand.
     * Accepts sqrt on either n1 or n2 depending on state.
     *
     * @param event triggered by pressing the sqrt button
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
     * Updates the calculator display based on the current operands and operator.
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
     * Updates the display with a specific message or number.
     *
     * @param s the text to show on the display
     */
    private void updateScreen(String s) {
        textField.setText(s);
    }

    /**
     * Performs the calculation for the current operator and operands.
     * Supports repeated equals presses by reusing lastOperator and lastN2.
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
