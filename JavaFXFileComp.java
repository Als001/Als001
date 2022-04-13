/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cap17;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import java.io.*;

/**
 *
 * @author MASELUAL
 */
public class JavaFXFileComp extends Application {
    /* Ejercicio 16.1

    Compara archivos basada en JavaFX

*/

TextField tfFirst;
TextField tfSecond;

Button btnComp;

Label labFirst, labSecond;
Label labResult;

public static void main(String[] args) {
launch(args);
}

public void start(Stage myStage)  {
CheckBox jcbLoc;

myStage.setTitle("Compare files");
// FlowPane nodo raiz
FlowPane rootNode = new FlowPane(10,10);
rootNode.setAlignment(Pos.CENTER);

// Crear una escena en en nodo raiz
Scene myScene = new Scene(rootNode,180,180);

// Establecer la escena en el  escenario
myStage.setScene(myScene);
// Constructor de SwingFC
tfFirst = new TextField();
tfSecond = new TextField();
tfFirst.setPrefColumnCount(12);
tfSecond.setPrefColumnCount(12);
btnComp = new Button("Compare");
labFirst = new Label("Enter file1 name:");
labSecond = new Label("Enter file2 name:");
labResult  = new Label("");
jcbLoc = new CheckBox("Show position of difference)");

// Usar expresiones lambda para ejecutar los eventos de acción de los campos de texto
tfFirst.setOnAction((ae)-> btnComp.fire());
tfSecond.setOnAction((ae)-> btnComp.fire());

// Procesar el evento de acción del botón Compare
btnComp.setOnAction((ae)->  {


int i=0, j=0, count=0;


    if(tfFirst.getText().equals("")) { labResult.setText("Nombre Primer fichero vacio.");
          return;}
    
    if(tfSecond.getText().equals("")) { labResult.setText("Nombre Segundo fichero vacio.");
          return;}

    // Comparar archivos
     
System.out.println(tfFirst.getText());
     try (FileInputStream f1 = new FileInputStream(tfFirst.getText());
          FileInputStream f2 = new FileInputStream(tfSecond.getText())) 

    {
          
          
// Codigo compara ficheros , puede ser otro INICIO
         do {
             
             i = f1.read();
             j = f2.read();
             count++;
             if (i!=j) break;
              
            } while(i != -1 && j != -1);
          
          if (i!=j) 
            if (jcbLoc.isSelected())
                    labResult.setText("Files differ at location: " + count);
            else    labResult.setText("Files are diferent");

          else labResult.setText("Files are the same");
 } catch(IOException ie) {labResult.setText("File Error");
 }
});

rootNode.getChildren().addAll(labFirst,tfFirst,labSecond,tfSecond,btnComp,labResult,jcbLoc);
myStage.show();
}
}








