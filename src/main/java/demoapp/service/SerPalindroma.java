package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class SerPalindroma {
    public boolean esPal(String nombre) {
         if (nombre.equals("Palindroma")) 
          { return true;} 
         else
          {return false;}
      
    }
}