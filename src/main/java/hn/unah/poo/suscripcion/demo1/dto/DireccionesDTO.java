package hn.unah.poo.suscripcion.demo1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DireccionesDTO {
    private int idDireccion;

    private String departamento;

    private String ciudad;
    
    private String colonia;

    private ClienteDTO clienteDTO;
}
