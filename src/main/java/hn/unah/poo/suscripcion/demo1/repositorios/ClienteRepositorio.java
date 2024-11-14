package hn.unah.poo.suscripcion.demo1.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.unah.poo.suscripcion.demo1.modelos.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {
}
