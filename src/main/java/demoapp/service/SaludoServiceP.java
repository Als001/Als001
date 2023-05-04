package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class SaludoServiceP {
    public String saludaP(String nombre) {
        return "Buenos días " + nombre;
    }
}