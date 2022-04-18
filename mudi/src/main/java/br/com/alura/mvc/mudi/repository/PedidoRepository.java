package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.Status;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	List<Pedido> findByStatus(Status status);

}
