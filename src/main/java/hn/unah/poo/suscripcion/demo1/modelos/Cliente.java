package hn.unah.poo.suscripcion.demo1.modelos;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    
    @Id
    private String dni;

    private String nombre;

    private String apellido;

    @Column(name="fechaingreso")
    private LocalDate fechaIngreso;

    private String correo;

    private String telefono;

    @OneToOne(mappedBy = "cliente")
    private Direcciones direccion;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Membresias> membresias;

}
