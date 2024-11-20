package hn.unah.poo.suscripcion.demo1.dto;

import hn.unah.poo.suscripcion.demo1.modelos.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MembresiasDTO {
    private int idmembresia;

    private double precio;

    private String descripcion;

    private char tipo;

    private ClienteDTO cliente;
}
