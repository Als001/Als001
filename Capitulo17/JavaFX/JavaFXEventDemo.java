package JavaFX;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class JavaFXEventDemo extends Application {

	Label response;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage myStage) throws Exception {
		// TODO Auto-generated method stub
		myStage.setTitle("Use JavaFX Button and Eventes.");
		// FlowPane para el nodo raiz con distancias verticales y horizontales de 10.
		FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);
		
		Scene myScene = new Scene(rootNode,300,100);
		
		myStage.setScene(myScene);
		
		// Crear una eqtiqueta
		response = new Label("Push a Button");
		Button btnUp = new Button("Up");
		Button btnDown = new Button("Down");
				
		// procesar los eventos de acción del botón UP.
		
		btnUp.setOnAction(new EventHandler <ActionEvent>() {
			 public void handle(ActionEvent ae) {
				 response.setText("You pressed Up.");
			 }
		});
		
		// botón Down
		btnDown.setOnAction(new EventHandler <ActionEvent>() {
			 public void handle(ActionEvent ae) {
				 response.setText("You pressed Down.");
			 }
		});
		
		// Añadir etiqueta y botones a la escena gráfica
		rootNode.getChildren().addAll(btnUp,btnDown,response);
		myStage.show();
		
			
		}
		

}
