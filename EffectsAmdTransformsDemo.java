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
import javafx.beans.*;
import javafx.geometry.*;
import javafx.scene.transform.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;

/**
 *
 * @author MASELUAL
 */
public class EffectsAmdTransformsDemo extends Application {

double angle = 0.0;
double scaleFactor = 0.4;
double blurVal = 1.0;

// ini modificación ejercicio 14 Capitulo 17
double bluRVal = 1.0;
BoxBlur rotateBlur = new BoxBlur(5.0,5.0,2);
// fin  modificación ejercicio 14 Capitulo 17

// Crear los efectos y transformaciones iniciales

Reflection reflection = new Reflection();
BoxBlur blur = new BoxBlur(1.0,1.0,1);
Rotate rotate = new Rotate();
Scale scale = new Scale(scaleFactor,scaleFactor);

// Crear botones sobre los que se aplicarán los efectos

Button btnRotate = new Button("Rotate");
Button btnBlur = new Button("Blur off");
Button btnScale = new Button("Scale");
Label labVer = new Label("Desenfoque:");


Label reflect = new Label("Reflection Adds visual Sparkle");

public static void main(String[] args) {
// iniciar la aplicación javafx invocando a launch
launch(args);
}
public void start(Stage myStage) {

myStage.setTitle("Effects and Transforms Demo");
FlowPane rootNode = new FlowPane(20,20);
rootNode.setAlignment(Pos.CENTER);

// Crear escena
Scene myScene = new Scene(rootNode,300,120);

myStage.setScene(myScene);
// Añadir rotación a la lista de transformaciones del botón Rotate
btnRotate.getTransforms().add(rotate);
// Añadir scale a la lista de transformaciones del botón Scale
btnScale.getTransforms().add(scale);

// Definir el efecto reflejo en la etiqueta
reflection.setTopOpacity(0.7);
reflection.setBottomOpacity(0.3);
reflect.setEffect(reflection);

// Procesar los eventeos de acción del botón Rotate
btnRotate.setOnAction(new EventHandler<ActionEvent>() {
  public void handle(ActionEvent ae) {

  // Siempre que se gire el botón gira 30 grados
  // sobre su centro

    angle += 15.0;
    rotate.setAngle(angle);
    rotate.setPivotX(btnRotate.getWidth()/2);
    rotate.setPivotY(btnRotate.getHeight()/2);


// ini modificación ejercicio 14 Capitulo 17
  
   if (bluRVal >= 10.0) {
       bluRVal = 1.0;
       btnRotate.setEffect(null);
       btnRotate.setText("Blur off");
       System.out.println("bluRVal:" + bluRVal);
    } else {
       bluRVal++;
       btnRotate.setEffect(rotateBlur);
       btnRotate.setText("Blur on");
    }
   rotateBlur.setWidth(bluRVal);
   rotateBlur.setHeight(bluRVal);
   String dat = String.valueOf(bluRVal);
   
   labVer.setText("lab:" + bluRVal);
// fin modificación ejercicio 14 Capitulo 17
  }
});

// Procesar los eventos de acción del botón Scale
btnScale.setOnAction(new EventHandler<ActionEvent>() {
  public void handle(ActionEvent ae) {

  // Cada vez que se pulse cambia su escala

    scaleFactor += 0.1;
    if (scaleFactor > 2.0) scaleFactor = 0.4;
    scale.setX(scaleFactor);
    scale.setY(scaleFactor);
  }
}); 

// Procesar los eventos de acción del botón Blur
btnBlur.setOnAction(new EventHandler<ActionEvent>() {
  public void handle(ActionEvent ae) {

  // Cada vez que se pulse cambia su desenfoque

    if (blurVal == 10.0) {
       blurVal = 1.0;
       btnBlur.setEffect(null);
       btnBlur.setText("Blur off");
    } else {
       blurVal++;
       btnBlur.setEffect(blur);
       btnBlur.setText("Blur on");
    }
    blur.setWidth(blurVal);
    blur.setHeight(blurVal);
   }
}); 

// Añadir etiqueta y botones al escenario
rootNode.getChildren().addAll(btnRotate,btnScale,btnBlur,reflect,labVer);
myStage.show();
}

}
