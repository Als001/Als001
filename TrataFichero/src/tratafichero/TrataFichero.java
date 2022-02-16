/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tratafichero;


/**
 *
 * @author MASELUAL
 */
// Copia fichero de texto
// versión con try recursos. Closeable



import java.io.*;
import java.util.ArrayList;

import GlobalPropert.GlobalPropert.Proper;

class TratarFichero {



public static void main(String args[])  throws IOException{


   int lineas = 0; int filas = 0; int lin2 = 0;
   int  b = 0; int ba = 0; String [] vi, vj; 
   int e = 0;
   int cols= 0; int col2 = 0;
   int c2;
   int t = 0; int ta= 0;
   String i = ""; String j = "";
   String cadena = ""; String cadena2="";
   char s='a';


// confirmar que se especifica un nombre de archivo

   if(args.length != 2) {

  //System.out.println("Usage : CopyFile from to");
  //return;

  }

// Abre archivo, lee hasta final y cierra el archivo


ArrayList<String[]> Aux = new ArrayList<>();
ArrayList<String[]> Aux2 = new ArrayList<>();
String [][] dat,dat2;
dat = new String[100][8];
dat2 = new String[1] [8];

Proper fic1  = Proper.FICHERO1;
Proper fic2  = Proper.FICHERO2;
Proper fic3  = Proper.OUT;




try 
    (BufferedReader f1 = new BufferedReader(new FileReader(fic1.getProperti()));
     BufferedReader f2 = new BufferedReader(new FileReader(fic2.getProperti()));
     BufferedWriter fout = new BufferedWriter(new FileWriter(fic3.getProperti())))

{
 
 i=j= "empieza";
 b=lineas=lin2=filas=e=col2=cols=t=ta=ba=0;

   i = f1.readLine();
   j = f2.readLine();
        cadena2 = j;
        cadena  = i;
   // b-> contador f1
   // t-> contador f2
 

 do { 
      if (e == 0) {
         System.out.println("Lee ficheros linea f1:" + b +  ".En f2: "+ t);

       
       // Comprueba filas iguales 
        
        
         
       
        if ((cadena2!=null && t!=ta) || (t == 0)){
               
// Solo añade a la lista Aux2 si ha leido en fichero (incremento t)
             Aux2.add(cadena2.split(";"));

             // almacena cada array en la lista Aux2
         
             if (col2 == 0) { 
               col2 = Aux2.get(0).length;}
             ta = t;
             for (c2=0;c2<col2;c2++) {
               
              dat2 [lin2][c2] = Aux2.get(t)[c2];
           
             }
           
         }

         
// Solo añade a la lista Aux si ha leido en fichero (incremento b)

        if ((cadena!=null && b!=ba) || (b ==0)) {
             
            
            Aux.add(cadena.split(";")); // almacena cada array en la lista Aux
       
             if (cols == 0) { 
               cols = Aux.get(0).length;}
             ba = b;
 
             for (int c=0;c<cols;c++) {
             
              dat[lineas][c] = Aux.get(b)[c];
              
              if (!(dat[lineas][c].equals( dat2[lin2][c])))
                 {e++;}       
             }
             if(e>0) 
              System.out.println("Encontrado fila distinta: " + b + "-" + t);
        }
          
        
  
       String[] sAu2 = Aux.get(t); 
       

       if (e>0) {

            if (e==0) System.out.println("Ojo e es cero");
            System.out.println("Entra en distinto");
         
//   Son distintos escribo en Salida.txt

            if (i.compareTo(j) < 0) 
                {fout.write("f1 -> Posición:" + b +": "); fout.write(i); fout.newLine();
                 System.out.println(" difiere  f1:" +  i + " en Posición :" +  b + "** en f2 es:" + t);}
            else
                {fout.write("f2 -> Posición:" + t +": "); fout.write(j);  fout.newLine();
                   System.out.println(" difiere  f2:" +  j + " en Posición :" +  t +"** en f1 es:" + b);}
        
         s = 'q';
           }
    
      else
// filas son iguales leo siguientes

        { //System.out.println("Entra en fila i: " + b + " fila j: "+ t);
           i = f1.readLine();
           j = f2.readLine();
           b++; t++;
        }
       }
   //de primer if (e ==0)
   //ha habido diferencia en lecturas , vuelve a leer segun quien es menor
    else{ 
            if (i.compareTo(j) < 0) 
                 {i = f1.readLine(); b++;
                    if (s=='q')
                    System.out.println("Siguiente lectura f1 será:" + b);
                  }
            //  Lee f1 (f2 es mayor)
            else
                 {j = f2.readLine();t++;
                    if (s=='q')
                    System.out.println("Siguiente lectura f2 será:" + t);
            }
            e=0;

    }
 
        
        cadena2 = j;
        cadena  = i;
        if (i!=null && j!=null) 
          {vi = cadena.split(";");
           vj = cadena2.split(";");
           if ((vj.length < 2) || (vi.length < 2)) i = null;}
     
 } while (i != null && j!= null);

  if(s=='q') System.out.println("Files are different.");
  else System.out.println("Files are the same.");

} catch(IOException exc){
 System.out.print("An I/O exception occurred:" + exc);
}

}

}