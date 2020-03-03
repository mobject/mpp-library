package mpplibrary;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;
import mpplibrary.util.SpringBeansUtil;

import java.net.URL;

public class MPPFXMLLoader extends FXMLLoader {

    public MPPFXMLLoader(URL resource) {
        super(resource);
    }

    @Override
    public void setControllerFactory(Callback<Class<?>, Object> controllerFactory) {
        super.setControllerFactory(SpringBeansUtil::getBean);
    }
}
