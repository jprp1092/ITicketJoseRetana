/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iticket.Controller;

import com.iticket.Entity.Artistas;
import com.iticket.Entity.Conciertos;
import com.iticket.Service.IArtistasService;
import com.iticket.Service.IConciertosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author joser
 */
@Controller
public class ConciertosController {

    @Autowired
    private IConciertosService conciertosService;

    @Autowired
    private IArtistasService artistasService;

    @GetMapping("/conciertos")
    public String index(Model model) {
        List<Conciertos> listaConciertos = conciertosService.getAllConciertos();
        model.addAttribute("titulo", "Tabla Conciertos");
        model.addAttribute("conciertos", listaConciertos);
        return "conciertos";//devolvera html verdura
    }

    @GetMapping("/conciertosN")
    public String crearConciertos(Model model) {
        List<Artistas> listaArtistas = artistasService.listArtistas();
        model.addAttribute("conciertos", new Conciertos());
        model.addAttribute("artistas", listaArtistas);
        return "crear";//devolvera html crear
    }

    @PostMapping("/save")//cuando se usa ese url pasa lo de abajo
    public String guardarConciertos(@ModelAttribute Conciertos conciertos) {
        conciertosService.saveConciertos(conciertos);
        return "redirect:/conciertos";
    }

    @GetMapping("/editConciertos/{id}")
    public String editarConciertos(@PathVariable("id") Long idConciertos, Model model) {
        Conciertos conciertos = conciertosService.getConciertosById(idConciertos);
        List<Artistas> listaArtistas = artistasService.listArtistas();
        model.addAttribute("conciertos", conciertos);
        model.addAttribute("artistas", listaArtistas);
        return "crear";
    }

    @GetMapping("/delete/{id}")
    public String eliminarConciertos(@PathVariable("id") Long idConciertos) {
        conciertosService.delete(idConciertos);
        return "redirect:/conciertos";
    }
}
