
package Start;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author MaYaNk
 */
public class start_App extends Application {
    
    public static void main(String[] args) {
		
		launch(args);
	}

    
    @Override
	public void start(Stage stage) throws Exception {
		
		Parent root= FXMLLoader.load(getClass().getResource("/StartScreen/startSlice.fxml"));
                //BorderPane root=new BorderPane();
		Scene scene=new Scene(root,750,500);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Sliced");
		Image image=new Image("/Images/icon3.png");
		stage.getIcons().add(image);
		stage.show();
		
		
	}
    
}
