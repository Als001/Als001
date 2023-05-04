package demoapp.controller;

import demoapp.service.SerPalindroma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ClavePalindroma {

    @Autowired
    private SerPalindroma service;

    @GetMapping("/esPal")
    // Hay que declarar un parámetro con el tipo usado en el modelo del formulario (UserData)
    public String saludoForm(UserDataP userDataP) {
        return "clavePalindroma";
    }

    @PostMapping("/esPal")
    public String checkPersonInfo(@ModelAttribute @Valid UserDataP userDataP, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "clavePalindroma";
        }else  {
            model.addAttribute("nombre", userDataP.getNombre());
            model.addAttribute("esPal", service.esPal(userDataP.getNombre()));
            return "esPalindroma";
        }   
        
 }
}
