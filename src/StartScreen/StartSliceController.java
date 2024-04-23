package StartScreen;

import java.io.IOException;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartSliceController {

    @FXML
    private Text slicedText;
    @FXML
    private Button goToLoginPageButton;

    public void initialize() {
        // Create a glow effect
        Glow glow = new Glow(0.0); // Initial glow level (no glow)
        slicedText.setEffect(glow);

        // Create a scale transition with a glow effect
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), slicedText);
        scaleTransition.setToX(1.5); // Scale factor
        scaleTransition.setToY(1.5); // Scale factor
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE); // Repeat indefinitely
        scaleTransition.setAutoReverse(true); // Reverse animation on each cycle

        // Adjust the glow level during the animation
        scaleTransition.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            double progress = newValue.toMillis() / scaleTransition.getTotalDuration().toMillis();
            glow.setLevel(progress); // Adjust glow level based on animation progress
        });

        scaleTransition.play();
        goToLoginPageButton.setCursor(Cursor.HAND);
    }

  @FXML
private void goToLoginPageButtonAction(ActionEvent event) {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("/application/adminLogin.fxml"));
        
        // Create the slide-out animation for the current content
        TranslateTransition slideOutTransition = new TranslateTransition(Duration.seconds(0.5), slicedText);
        slideOutTransition.setToX(-goToLoginPageButton.getScene().getWidth());

        slideOutTransition.setOnFinished(transitionEvent -> {
            root.setTranslateX(goToLoginPageButton.getScene().getWidth()); // Set the new content off the screen
            goToLoginPageButton.getScene().setRoot(root); // Replace the content with the new scene
            TranslateTransition slideInTransition = new TranslateTransition(Duration.seconds(0.5), root);
            slideInTransition.setToX(0); // Slide the new content in
            slideInTransition.play();
        });

        // Start the slide-out animation
        slideOutTransition.play();
    } catch (IOException e) {
        e.printStackTrace();
        System.exit(0);
    }
}

}



