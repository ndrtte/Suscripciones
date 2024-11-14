package hn.unah.poo.suscripcion.demo1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.poo.suscripcion.demo1.dto.ClienteDTO;
import hn.unah.poo.suscripcion.demo1.modelos.Cliente;
import hn.unah.poo.suscripcion.demo1.servicios.ClienteServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/obtener")
    public List<Cliente> obtenerTodos(){
        return this.clienteServicio.obtenerTodoss();
    }

    @GetMapping("/obtener/dni")
    public ClienteDTO obtenerPorDNI(@RequestParam(name="dni") String dni){
        return this.clienteServicio.obtenerPorDNI(dni);
    }

    @PostMapping("/crear/nuevo")
    public String crearNuevoCliente(@RequestBody ClienteDTO entity) {
        return this.clienteServicio.crearCliente(entity);
    }

    @DeleteMapping("/eliminar/{dni}")
    public String eliminarCliente (@PathVariable(name="dni")String dni){
        return this.clienteServicio.eliminarClientePorId(dni);
    }
    

}
