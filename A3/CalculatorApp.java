import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
public class CalculatorApp extends Application {
    public StringBuilder currentInput = new StringBuilder();
    public String lastOperation = "";
    public double lastNumber = 0;
    public double result = 0;
    public boolean clearDisplay = false;
    public Label displayLabel;
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
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
        for (int i = 0; i < buttonLabels.length; i++) {
            for (int j = 0; j < buttonLabels[i].length; j++) {
                String label = buttonLabels[i][j];
                Button button = new Button(label);
                button.setMinSize(40, 40);
                button.setOnAction(e -> handleButtonClick(label));
                grid.add(button, j, i + 1);
            }
        }
        Scene scene = new Scene(grid, 222, 333);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void handleButtonClick(String buttonLabel) {
        if (buttonLabel.matches("[0-9]")) {
            handleDigitInput(buttonLabel);
        } else {
            switch (buttonLabel) {
                case "+/-":
                    changeSign();
                    break;
                case ".":
                    handleDecimalPoint();
                    break;
                case "=":
                    performOperation();
                    break;
                case "C":
                    clearLast();
                    break;
                case "AC":
                    clearAll();
                    break;
                default:
                    handleOperation(buttonLabel);
            }
        }
        updateDisplay();
    }
    public void handleDigitInput(String digit) {
        if (currentInput.length() < 8) {
            currentInput.append(digit);
        }
    }
    public void handleDecimalPoint() {
        if (!currentInput.toString().contains(".")) {
            currentInput.append(".");
        }
    }
    public void handleOperation(String operation) {
        if (!lastOperation.isEmpty()) {
            performOperation();
            lastOperation = operation;
            clearDisplay = true;
        } 
        else {
            lastOperation = operation;
            lastNumber = Double.parseDouble(currentInput.toString());
            currentInput.setLength(0);
        }
    }
    public void performOperation() {
        if (!currentInput.toString().isEmpty()) {
            double currentNumber = Double.parseDouble(currentInput.toString());
            switch (lastOperation) {
                case "+":
                    result = lastNumber + currentNumber;
                    break;
                case "-":
                    result = lastNumber - currentNumber;
                    break;
                case "*":
                    result = lastNumber * currentNumber;
                    break;
                case "/":
                    if (currentNumber != 0) {
                        result = lastNumber / currentNumber;
                    } else {
                        displayError();
                        return;
                    }
                    break;
            }
            lastNumber = result;
            currentInput.setLength(0);
            currentInput.append(result);
            lastOperation = "";
            clearDisplay = true;
        }
    }
    public void changeSign() {
        if (!currentInput.toString().isEmpty() && !currentInput.toString().equals("0")) {
            double number = Double.parseDouble(currentInput.toString());
            number *= -1;
            currentInput.setLength(0);
            currentInput.append(number);
        }
    }
    public void clearLast() {
        if (!currentInput.toString().isEmpty()) {
            currentInput.setLength(currentInput.length() - 1);
        } else if (!lastOperation.isEmpty()) {
            lastOperation = "";
            currentInput.append(Double.toString(lastNumber));
        }
    }
    public void clearAll() {
        currentInput.setLength(0);
        lastOperation = "";
        lastNumber = 0;
        result = 0;
        clearDisplay = false;
    }
    public void updateDisplay() {
        if (clearDisplay) {
            displayLabel.setText(currentInput.toString());
            clearDisplay = false;
        } else {
            displayLabel.setText(currentInput.toString());
        }
    }
    public void displayError() {
        currentInput.setLength(0);
        currentInput.append("ERR");
        lastOperation = "";
        lastNumber = 0;
        result = 0;
        clearDisplay = true;
    }
}