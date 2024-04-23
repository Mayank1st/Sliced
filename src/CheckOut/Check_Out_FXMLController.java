package CheckOut;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Check_Out_FXMLController implements Initializable {

    @FXML
    private FlowPane checkOutFlowPane = new FlowPane();
    private static final int NUM_PARENT_HBOXES = 7; // Change this to the desired number of parent HBoxes
    @FXML
    private HBox headingSeperatorLineHBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Create a GridPane with 2 rows and 5 columns
        GridPane gridPane = createTable(2, 5);

        // Add the GridPane to the FlowPane
        checkOutFlowPane.getChildren().add(gridPane);
    }

    // Helper method to create a GridPane table with the specified number of rows and columns
    private GridPane createTable(int rows, int columns) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Set horizontal gap between cells
        gridPane.setVgap(10); // Set vertical gap between cells

        // Create and add child HBoxes to the GridPane in a 2x5 layout
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                HBox hbox = createParentHBox(); // Use your custom method to create HBox with content
                gridPane.add(hbox, col, row);
            }
        }

        return gridPane;
    }

    // Helper method to create a parent HBox containing all the child HBox elements
    private HBox createParentHBox() {
        HBox parentHBox = new HBox(); // No spacing between HBoxes
        parentHBox.setPrefSize(150, 80); // Set the preferred size of the parent HBox

        // Add a border to the parent HBox with the #f0eceb color
        Rectangle parentBorder = new Rectangle(150, 80);
        parentBorder.setStroke(Color.web("#f0eceb"));
        parentBorder.setFill(Color.TRANSPARENT);
        parentHBox.getChildren().add(parentBorder);

        return parentHBox;
    }
}
