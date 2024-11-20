package hn.unah.poo.suscripcion.demo1.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.unah.poo.suscripcion.demo1.modelos.Membresias;

@Repository
public interface MembresiaRepositorio extends JpaRepository<Membresias, Integer>{   
}
