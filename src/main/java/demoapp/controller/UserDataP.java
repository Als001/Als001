package demoapp.controller;

import javax.validation.constraints.Size;

public class UserDataP {
    @Size(min=10, max=10)
    String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
