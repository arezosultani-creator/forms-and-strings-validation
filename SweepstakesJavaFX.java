import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SweepstakesJavaFX extends Application {

    private Label error = new Label("");

    @Override
    public void start(Stage stage) {

        TextField fName = new TextField();
        TextField lName = new TextField();
        TextField phone = new TextField();
        TextField email = new TextField();
        TextField luckyNum = new TextField();
        TextField dob = new TextField();

        Button submit = new Button("Submit");

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                error.setText("");

                checkFirst(fName.getText());
                checkLast(lName.getText());
                checkPhone(phone.getText());
                checkEmail(email.getText());
                checkLuckyNum(luckyNum.getText());
                checkDob(dob.getText());
            }
        });

        GridPane grid = new GridPane();
        grid.add(new Label("First Name:"), 0, 0);
        grid.add(fName, 1, 0);

        grid.add(new Label("Last Name:"), 0, 1);
        grid.add(lName, 1, 1);

        grid.add(new Label("Phone:"), 0, 2);
        grid.add(phone, 1, 2);

        grid.add(new Label("Email:"), 0, 3);
        grid.add(email, 1, 3);

        grid.add(new Label("Lucky Number:"), 0, 4);
        grid.add(luckyNum, 1, 4);

        grid.add(new Label("Date of Birth:"), 0, 5);
        grid.add(dob, 1, 5);

        grid.add(submit, 1, 6);
        grid.add(error, 1, 7);

        Scene scene = new Scene(grid, 450, 350);
        stage.setScene(scene);
        stage.setTitle("Sweepstakes Entry");
        stage.show();
    }

    private void addError(String msg) {
        error.setText(error.getText() + msg + "\n");
    }

    private void checkFirst(String s) {
        if (s.isEmpty())
            addError("First name required");
        else if (!s.matches("[A-Za-z]{2,}"))
            addError("First name invalid");
    }

    private void checkLast(String s) {
        if (s.isEmpty())
            addError("Last name required");
        else if (!s.matches("[A-Za-z]{2,}"))
            addError("Last name invalid");
    }

    private void checkPhone(String s) {
        if (s.isEmpty())
            addError("Phone number required");
        else if (!s.matches("\\d{3}-\\d{3}-\\d{4}"))
            addError("Phone number format: ###-###-####");
    }

    private void checkEmail(String s) {
        if (s.isEmpty())
            addError("Email address required");
        else if (!s.matches("[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z0-9]+"))
            addError("Email address invalid");
    }

    private void checkLuckyNum(String s) {
        if (s.isEmpty())
            addError("Lucky number required");
        else {
            try {
                int n = Integer.parseInt(s);
                if (n < 1 || n > 100)
                    addError("Lucky number must be between 1 and 100");
            } catch (NumberFormatException e) {
                addError("Lucky number must be numeric");
            }
        }
    }

    private void checkDob(String s) {
        if (s.isEmpty())
            addError("Date of Birth required");
        else if (!s.matches("(0?[1-9]|1[0-2])/(0?[1-9]|[12][0-9]|3[01])/(19|20)\\d\\d"))
            addError("Date of Birth format: ##/##/#### or #/#/####");
    }

    public static void main(String[] args) {
        launch(args);
    }
}