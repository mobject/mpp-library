package mpplibrary;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mpplibrary.controller.SystemController;
import mpplibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<LibraryApplication.StageReadyEvent> {

	private ApplicationContext applicationContext;

	@Autowired
	private SystemController systemController;


	public StageInitializer(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public void onApplicationEvent(LibraryApplication.StageReadyEvent stageReadyEvent) {
		Stage primaryStage = (Stage) stageReadyEvent.getSource();
		GridPane root;
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gui/login.fxml"));
			fxmlLoader.setController(systemController);
			root = fxmlLoader.load();
			primaryStage.setTitle("Library");
			primaryStage.setScene(new Scene(root, LibraryApplication.WINDOW_WIDTH, LibraryApplication.WINDOW_HEIGHT));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
