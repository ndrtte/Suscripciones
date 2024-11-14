package hn.unah.poo.suscripcion.demo1.servicios;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.poo.suscripcion.demo1.ModelMapper.ModelMapperSingleton;
import hn.unah.poo.suscripcion.demo1.dto.ClienteDTO;
import hn.unah.poo.suscripcion.demo1.modelos.Cliente;
import hn.unah.poo.suscripcion.demo1.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    private ModelMapper modelMapper = ModelMapperSingleton.getInstancia();

    public List <Cliente> obtenerTodoss(){
        return clienteRepositorio.findAll();
    }

    public ClienteDTO obtenerPorDNI(String dni){
        Cliente cliente = clienteRepositorio.findById(dni).get();
        ClienteDTO clienteDTO = this.modelMapper.map(cliente, ClienteDTO.class);
        
        return clienteDTO;
    }

    public String crearCliente(ClienteDTO nvoCliente){
        if(this.clienteRepositorio.existsById(nvoCliente.getDni())){
            return "Ya existe el cliente";   
        }
        Cliente clienteBD = new Cliente();
        clienteBD = this.modelMapper.map(nvoCliente, Cliente.class);
        clienteRepositorio.save(clienteBD);
        return "El cliente ha sido creado";
    }

    public String eliminarClientePorId(String id){
        if(!this.clienteRepositorio.existsById(id)){
            return "No existe el cliente";   
        }
        clienteRepositorio.deleteById(id);
        return "El cliente ha sido eliminado exitosamente";
    }

}
