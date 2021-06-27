package org.F2Binary;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox mainBox = new VBox(20);
        String family = "Helvetica";
        double size = 50;
        //TextFlow class makes the title look more interesting
        TextFlow textFlow = new TextFlow();
        Text text1 = new Text("Welcome ");
        text1.setFont(Font.font(family, size));
        text1.setFill(Color.RED);
        Text text2 = new Text("to");
        text2.setFill(Color.ORANGE);
        text2.setFont(Font.font(family, FontWeight.BOLD, size));
        Text text3 = new Text(" Sudova");
        text3.setFill(Color.GREEN);
        text3.setFont(Font.font(family, FontPosture.ITALIC, size));
        textFlow.getChildren().addAll(text1, text2, text3);
        textFlow.setTextAlignment(TextAlignment.CENTER);
        //Label for dimensions of grid
        Label sizeLabel = new Label("Dimensions:");
        // we take input in the form 'nxn' meaning we desire a square grid
        TextField sizeTextField = new TextField("enter the size of your grid in the form 'nxn' ");
        //This width allows prefilled textfield contents to be displayed
        sizeTextField.setPrefWidth(250);
        //Here we use an Hbox to have text field label and input on the same line
        HBox sizeHB = new HBox();
        sizeHB.getChildren().addAll(sizeLabel,sizeTextField);
        sizeHB.setSpacing(14);
        sizeHB.setAlignment(Pos.CENTER);
        //We create a button and add event listener
        Button button = new Button("Initiate Board");
        EventHandler<MouseEvent> setBoard = e -> {
            //Transition into game scene
            String textFieldParameters = sizeTextField.getText();
            System.out.printf("Now generating a %s board",textFieldParameters);

            //SudovaModel model = new SudovaModel(textFieldParameters);
            //model.setGameState(1);
            //System.out.println(model.getGameState());

            stage.setScene(new Scene(new Button("hello"),640,480,Color.PINK));
        };
        button.addEventFilter(MouseEvent.MOUSE_CLICKED,setBoard);
        mainBox.getChildren().addAll(textFlow,sizeHB,button);
        mainBox.setAlignment(Pos.CENTER);
        BackgroundFill background_fill = new BackgroundFill(Color.PINK,
                CornerRadii.EMPTY, Insets.EMPTY);
        mainBox.setBackground(new Background(background_fill));
        //This is the menu scene
        final Scene sudovaMenu = new Scene(mainBox, 640, 480);
        stage.setTitle("Sudova");
        stage.setScene(sudovaMenu);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}