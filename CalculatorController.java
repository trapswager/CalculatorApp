import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField display;

    private Calculator calculator = new Calculator();
    private StringBuilder input = new StringBuilder();

    @FXML
    private void handleNumber(ActionEvent event) {
        Button button = (Button) event.getSource();
        input.append(button.getText());
        display.setText(input.toString());
    }

    @FXML
    private void handleOperator(ActionEvent event) {
        calculator.setOperand1(Double.parseDouble(input.toString()));
        input.setLength(0);
        Button button = (Button) event.getSource();
        calculator.setOperator(button.getText().charAt(0));
    }

    @FXML
    private void handleEquals(ActionEvent event) {
        calculator.setOperand2(Double.parseDouble(input.toString()));
        calculator.calculate();
        if (calculator.isError()) {
            display.setText("Error: Division by Zero");
        } else {
            display.setText(String.valueOf(calculator.getResult()));
        }
        input.setLength(0);
    }

    @FXML
    private void handleClear(ActionEvent event) {
        calculator.reset();
        input.setLength(0);
        display.clear();
    }
}
