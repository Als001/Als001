package GlobalPropert;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MASELUAL
 */

public class GlobalPropert {

// aquí se indica la dirección de los ficheros a usar en la clase Java TratarFichero

public enum Proper {
   FICHERO1("C:/Java/Prueba.txt"),
   FICHERO2("C:/Java/Prueba2.txt"),
   OUT("C:/Java/OutNet.txt");
 
private final  String fic;

Proper(String fic) {
       this.fic = fic;}

public String getProperti() {
           return fic;
 }

}
}
