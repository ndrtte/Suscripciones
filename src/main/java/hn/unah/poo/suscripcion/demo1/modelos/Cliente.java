package hn.unah.poo.suscripcion.demo1.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="clientes")
public class Cliente {
    
    private String dni;

    private String nombre;

    private String apellido;

    private String fechaIngreso;

    private String correo;

    private String telefono;

}
