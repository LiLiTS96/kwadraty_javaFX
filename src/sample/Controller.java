package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Canvas canvas;
    public RadioButton radioRed;
    public RadioButton radioBlue;
    public RadioButton radioGreen;
    public ToggleGroup group;
    public ComboBox<Integer> comboX;
    public ComboBox<Integer> comboY;

    ObservableList<Integer> list = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboX.setItems(list);
        comboY.setItems(list);

    }

    public void rysujKwadrat(MouseEvent mouseEvent) {

        double x = Math.floor((mouseEvent.getX()/50)+1)*50-50;
        double y = Math.floor((mouseEvent.getY()/50)+1)*50-50;
        GraphicsContext g2D = canvas.getGraphicsContext2D();

        RadioButton selection = (RadioButton) group.getSelectedToggle();
        String id = selection.getId();
        Color color = null;
        switch (id) {
            case "radioRed":
                color =  Color.RED;
                break;
            case "radioBlue":
                color = Color.BLUE;
                break;
            case "radioGreen":
                color = Color.GREEN;
                break;
        }

        //radioRed.setOnAction(event -> g2D.setFill(Color.RED));
        //radioBlue.setOnAction(event -> g2D.setFill(Color.BLUE));
        //radioGreen.setOnAction(event -> g2D.setFill(Color.GREEN));

        g2D.setFill(color);

        g2D.fillRect(x,y,50,50);
    }


    public void rysujKwadratButton(MouseEvent mouseEvent) {
        double x = Double.parseDouble(comboX.getValue()+"") * 50;
        double y = Double.parseDouble(comboY.getValue()+"") * 50;

        RadioButton selection = (RadioButton) group.getSelectedToggle();
        String id = selection.getId();
        Color color = null;
        switch (id) {
            case "radioRed":
                color =  Color.RED;
                break;
            case "radioBlue":
                color = Color.BLUE;
                break;
            case "radioGreen":
                color = Color.GREEN;
                break;
        }

        GraphicsContext g2D = canvas.getGraphicsContext2D();
        g2D.setFill(color);
        g2D.fillRect(x-50, y-50, 50, 50);

    }


}
