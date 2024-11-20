package hn.unah.poo.suscripcion.demo1.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.poo.suscripcion.demo1.dto.MembresiasDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/membresia")
public class MembresiaController {
    @PostMapping("/crear/nuevo")
    public String crearMembresia(@RequestBody MembresiasDTO membresiasDTO) {  
        return "";
    }
    
}
