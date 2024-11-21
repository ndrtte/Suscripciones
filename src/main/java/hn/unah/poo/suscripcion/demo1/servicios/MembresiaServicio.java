package hn.unah.poo.suscripcion.demo1.servicios;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.poo.suscripcion.demo1.ModelMapper.ModelMapperSingleton;
import hn.unah.poo.suscripcion.demo1.dto.MembresiasDTO;
import hn.unah.poo.suscripcion.demo1.modelos.Membresias;
import hn.unah.poo.suscripcion.demo1.repositorios.ClienteRepositorio;
import hn.unah.poo.suscripcion.demo1.repositorios.MembresiaRepositorio;

@Service
public class MembresiaServicio {
    
    @Autowired
    private MembresiaRepositorio membresiaRepositorio;

    private ModelMapper  modelMapper = ModelMapperSingleton.getInstancia();

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public String crearMembresia(MembresiasDTO nvoMembresia) { 
        if(clienteRepositorio.existsById(nvoMembresia.getCliente().getDni())){
            Membresias membresias = new Membresias();
            membresias = modelMapper.map(nvoMembresia,Membresias.class );
            membresiaRepositorio.save(membresias);
            return "La membresia ha sido creada para el cliente " + nvoMembresia.getCliente().getDni();
        }
        return "El cliente no existe";
    }


}
