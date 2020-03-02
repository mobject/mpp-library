package mpplibrary;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

@SpringBootApplication
public class LibraryApplication extends Application {
	public static int WINDOW_WIDTH = 800;
	public static int WINDOW_HEIGHT = 600;

	private ConfigurableApplicationContext applicationContext;

	@Override
	public void init() throws Exception {
		applicationContext = new SpringApplicationBuilder(LibraryApplication.class).run();
	}

	@Override
	public void start(Stage stage) {
		applicationContext.publishEvent(new StageReadyEvent(stage));
	}

	@Override
	public void stop() throws Exception {
		applicationContext.close();
		Platform.exit();
	}

	static class StageReadyEvent extends ApplicationEvent {
		public StageReadyEvent(Stage stage) {
			super(stage);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
