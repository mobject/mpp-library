package mpplibrary;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mpplibrary.service.UserService;

@Component
public class StageInitializer implements ApplicationListener<LibraryApplication.StageReadyEvent> {

	private ApplicationContext applicationContext;
	@Autowired
	private UserService userService;

	public StageInitializer(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public void onApplicationEvent(LibraryApplication.StageReadyEvent stageReadyEvent) {
		Stage primaryStage = (Stage) stageReadyEvent.getSource();
		Parent root;

		try {
			root = FXMLLoader.load(getClass().getResource("gui/home.fxml"));
			primaryStage.setTitle("Library");
			primaryStage.setScene(new Scene(root, LibraryApplication.WINDOW_WIDTH, LibraryApplication.WINDOW_HEIGHT));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
