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

public enum Proper {
   FICHERO1("C:/Java/Prueba11.txt"),
   FICHERO2("C:/Java/Prueba22.txt"),
   OUT("C:/Java/Out.txt");
 
private final  String fic;

Proper(String fic) {
       this.fic = fic;}

public String getProperti() {
           return fic;
 }

}
}
