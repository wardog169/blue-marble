package hellofx;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.Date;

import javax.imageio.ImageIO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagePicker {

	@FXML
	private ImageView imgMarble;

	@FXML
	private DatePicker dtSelector;
	
    @FXML
    private Button btnUpdate;
    
    public ImagePicker() {
    }

    @FXML
	void updateImage(ActionEvent event) {
    	btnUpdate.setDefaultButton(true);
		
		try {
			BlueMarble blueMarble = new BlueMarble();
//			InputStream isImage = (BlueMarble.getMostRecentImage());
//			Image image = new Image(isImage);
//			imgMarble.setImage(image);

			LocalDate localDate = dtSelector.getValue();
			blueMarble.setDate(localDate.toString());
			InputStream isImage = blueMarble.getImage();
			Image image = new Image(isImage);
			imgMarble.setImage(image);
		} 
		catch (RuntimeException rtE) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Exception");
			alert.setContentText(rtE.getLocalizedMessage());
			alert.showAndWait();
		}

	}

}
