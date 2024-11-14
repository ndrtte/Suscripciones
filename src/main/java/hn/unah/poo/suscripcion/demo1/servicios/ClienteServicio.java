package hn.unah.poo.suscripcion.demo1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.poo.suscripcion.demo1.modelos.Cliente;
import hn.unah.poo.suscripcion.demo1.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List <Cliente> obtenerTodoss(){
        return clienteRepositorio.findAll();
    }

}
