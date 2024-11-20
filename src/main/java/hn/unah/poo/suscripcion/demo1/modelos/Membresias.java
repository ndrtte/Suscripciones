package hn.unah.poo.suscripcion.demo1.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "membresias")
public class Membresias {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idmembresia")
    private int idmembresia;

    private double precio;

    private String descripcion;

    private char tipo;

    @ManyToOne()
    @JoinColumn(name="dni", referencedColumnName = "dni")
    @JsonIgnore
    private Cliente cliente;

}
