package hn.unah.poo.suscripcion.demo1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.poo.suscripcion.demo1.modelos.Cliente;
import hn.unah.poo.suscripcion.demo1.servicios.ClienteServicio;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/obtener")
    public List<Cliente> obtenerTodos(){
        return clienteServicio.obtenerTodoss();
    }

}
