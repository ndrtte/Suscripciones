package hn.unah.poo.suscripcion.demo1.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="direcciones")
@Getter
@Setter
public class Direcciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iddireccion")
    private int idDireccion;

    private String departamento;

    private String ciudad;
    
    private String colonia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dni",referencedColumnName = "dni")
    private Cliente cliente;
}
