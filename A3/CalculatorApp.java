import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
public class CalculatorApp extends Application {
    //  Variables
    public StringBuilder currentInput = new StringBuilder();
    public String lastOperation = "";       //  ---
    public double lastNumber = 0;
    public double result = 0;
    public boolean canClearDisplay = false;
    public Label displayLabel;

    //  Main Method
    public static void main(String[] args) {
        launch(args);
    }

    //  Start method - This method acts as the driver for the program.
    public void start(Stage primaryStage) {
        //  Set up the structure of the Calculator Gui, the window name, and the button/field names.
        primaryStage.setTitle("Calculator");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        displayLabel = new Label("0");
        displayLabel.setMinSize(160, 40);
        grid.add(displayLabel, 0, 0, 4, 1);
        String[][] buttonLabels = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "=", "+"},
                {"+/-", "C", "AC", "☺"}
        };

        //  Set the value for each button.
        for (int i = 0; i < buttonLabels.length; i++) {
            for (int j = 0; j < buttonLabels[i].length; j++) {
                String label = buttonLabels[i][j];  //  Cache button name
                Button button = new Button(label);  //  Create button object with label as name.
                button.setMinSize(40, 40);
                button.setOnAction(e -> handleButtonClick(label));  //  Add action to the button.  When the button is clicked, it will use the label (button name) to determine action.
                grid.add(button, j, i + 1); //  Add the button to the program.
            }
        }

        //  Create the scene
        Scene scene = new Scene(grid, 222, 333);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //  The button runs this method will check the input string and run the appropriate method.
    public void handleButtonClick(String buttonLabel) {
        if(!canClearDisplay){
            resetAllValues();
        }

        if (buttonLabel.matches("[0-9]")) {
            handleDigitInput(buttonLabel);  //  Number input
        } else {
            switch (buttonLabel) {
                case "+/-":
                    changeSign();   //  Toggle positive and negative
                    break;
                case ".":
                    handleDecimalPoint();   //  Add decimal point
                    break;
                case "=":
                    performOperation(); //  Calculate result
                    break;
                case "C":
                    clearLast();    //  Clear the last action/number/operation.
                    break;
                case "AC":
                    clearAll(); //  Clear all
                    break;
                default:
                    handleOperation(buttonLabel);   //  Handles extraneous circumstances.
            }
        }
        checkForError();    //  Check if the output exceeds 8 characters.
        updateDisplay();    //  Update the result
    }

    //  This method will add digits to the operation.  The max character size is 8.
    public void handleDigitInput(String digit) {
        if (currentInput.length() < 8) {
            currentInput.append(digit);
        }
    }

    //  This method adds a decimal point to a given number if it does not already exist.
    public void handleDecimalPoint() {
        if (!currentInput.toString().contains(".")) {
            currentInput.append(".");
        }
    }

    //  This method handles extraneous circumstances.  Perform arithmetic operations if the last operation is not empty or skip otherwise.
    public void handleOperation(String operation) {
        if (!lastOperation.isEmpty()) {
            //  If the last operation is not empty, perform the operation.
            performOperation();
            lastOperation = operation;  //  Update the last operation.
        } 
        else {
            //  If the last operation is empty, perform the following code.
            lastOperation = operation;  //  Update the last operation.
            lastNumber = Double.parseDouble(currentInput.toString());   //  Convert the currentInput from StringBuilder to double.  Store as lastNumber
            currentInput.setLength(0);  //  Clear the display field.
        }
    }

    //  Perform addition, subtraction, multiplication, or division on the provided numbers based on the operation character.
    public void performOperation() {
        if (!currentInput.toString().isEmpty()) {
            //  If the input is not empty, the following code will run.
            double currentNumber = Double.parseDouble(currentInput.toString()); //  Convert the StringBuilder value to a String, then convert from String to double.
            switch (lastOperation) {
                case "+":
                    result = lastNumber + currentNumber;    //  Add numbers
                    break;
                case "-":
                    result = lastNumber - currentNumber;    //  Subtract numbers
                    break;
                case "*":
                    result = lastNumber * currentNumber;    //  Multiply numbers
                    break;
                case "/":
                    if (currentNumber != 0) {
                        result = lastNumber / currentNumber;    //  If the denominator is not equal to zero, then divide.
                    } else {
                        displayError(); //  Display error if dividing by zero.
                        return;
                    }
                    break;
            }
            lastNumber = result;    //  Set the result to the new lastNumber.
            currentInput.setLength(0);  //  Erase the input field.
            currentInput.append(result);    //  Add the result to the input field.
            lastOperation = "";         //  Erase the last operation.
        }
    }

    //  Toggle sign between positive and negative for numbers.
    public void changeSign() {
        if (!currentInput.toString().isEmpty() && !currentInput.toString().equals("0")) {
            //  Only run the following code when the input is not empty and not equal to zero.
            double number = Double.parseDouble(currentInput.toString());    //  Convert to double
            number *= -1;   //  Multiply by -1.  Thus, positive numbers become negative and negative numbers become positive.
            currentInput.setLength(0);  //  Clear result field.
            currentInput.append(number);    //  Add number to result field.
        }
    }

    //  Clear the last character or operation from the display.
    public void clearLast() {
        if (!currentInput.toString().isEmpty()) {
            //  If the currentInput is not empty, then clear the last character.
            currentInput.setLength(currentInput.length() - 1);
        } else if (!lastOperation.isEmpty()) {
            //  Otherwise, if the last operation is not empty, set the input to the last number.
            lastOperation = "";
            currentInput.append(Double.toString(lastNumber));   //FIX: C issue here.
        }
    }

    //  AC Method - This method clears everything.
    public void clearAll() {
        currentInput.setLength(0);  //  Clear display field.
        currentInput.append("0");   //  Set the display to zero.
        updateDisplay();    //  Update the display
        canClearDisplay = false;    //  Toggle off
    }

    //  This method updates the display of the calculator.
    public void updateDisplay() {
        //  Set the display to currentInput
        displayLabel.setText(currentInput.toString());
    }

    //  This method reports that an error occured.
    public void displayError() {
        currentInput.setLength(0);  //  Clear display
        currentInput.append("ERR"); //  Add "Err" to display.
        updateDisplay();    //  Update the display
        canClearDisplay = false;    //  Toggle off
    }

    public void resetAllValues(){
        lastOperation = ""; //  Clear last operation.
        lastNumber = 0; //  Clear last number.
        result = 0; //  cleart the result.
        currentInput.setLength(0);  //  Clear display field.
        canClearDisplay = true; //  Toggle on
    }

    //  If the output exceeds 8 characters, display "ERR" for error.
    public void checkForError(){
        int maxDigits = 8;  //  Only 8 digits are allowed in the output.
        int containsDecimal = currentInput.indexOf(".") > -1 ? 1 : 0;   //  If a decimal exists, set this variable to 1, otherwise set to 0.
        int containsNegativeSign = currentInput.indexOf("-") > -1 ? 1 : 0;   //  If a negative sign exists, set this variable to 1, otherwise set to 0.

        //  If the output exceeds 8 digits, throw an error.  Since the length of the characters in the string are
        //  being measured, decimals and negative signs are ignored when determing the number of digits in the output.
        if(currentInput.length() > (maxDigits + containsDecimal + containsNegativeSign)){
            displayError(); //  An error is shown in the ouput.
        }
    }
}