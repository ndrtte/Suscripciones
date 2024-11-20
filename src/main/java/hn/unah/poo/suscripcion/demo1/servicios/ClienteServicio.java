package hn.unah.poo.suscripcion.demo1.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.poo.suscripcion.demo1.ModelMapper.ModelMapperSingleton;
import hn.unah.poo.suscripcion.demo1.dto.ClienteDTO;
import hn.unah.poo.suscripcion.demo1.modelos.Cliente;
import hn.unah.poo.suscripcion.demo1.modelos.Direcciones;
import hn.unah.poo.suscripcion.demo1.repositorios.ClienteRepositorio;
import hn.unah.poo.suscripcion.demo1.dto.DireccionesDTO;

@Service
public class ClienteServicio {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    private ModelMapper modelMapper = ModelMapperSingleton.getInstancia();

    public List <ClienteDTO> obtenerTodoss(){
       List<Cliente> listaClientes = clienteRepositorio.findAll();
       List<ClienteDTO> listaClienteDTO = new ArrayList<>();
       ClienteDTO clienteDTO;
       for(Cliente clienteBD : listaClientes){
            clienteDTO = modelMapper.map(clienteBD, ClienteDTO.class);
            listaClienteDTO.add(clienteDTO);
       }
       return listaClienteDTO;
    }

    public Optional <ClienteDTO> obtenerPorDNI(String dni){
       Optional <Cliente> cliente = clienteRepositorio.findById(dni);
       ClienteDTO clienteDTO = this.modelMapper.map(cliente, ClienteDTO.class);

        if(clienteDTO!=null){
            if(clienteDTO.getDireccion() == null){
                clienteDTO.setDireccion(null);
            }
            else{
                Direcciones direcciones = cliente.get().getDireccion();
                DireccionesDTO direccionesDTO = this.modelMapper.map(direcciones, DireccionesDTO.class);
                clienteDTO.setDireccion(direccionesDTO);
            }
        }
        return Optional.ofNullable(clienteDTO);
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

    public String actualizarCliente (String dni, ClienteDTO clienteDTO){
        if (!this.clienteRepositorio.existsById(clienteDTO.getDni())){
            return "No existe el cliente";
        }
        Cliente clienteActualizar = this.modelMapper.map(clienteDTO,Cliente.class);
        clienteRepositorio.save(clienteActualizar);
        return "EL cliente "+clienteDTO.getDni()+"  ha sido actualizado.";

    }

}
