package hn.unah.poo.suscripcion.demo1.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    
    private String dni;

    private String nombre;

    private String apellido;

    private LocalDate fechaIngreso;

    private String correo;

    private String telefono;
}
