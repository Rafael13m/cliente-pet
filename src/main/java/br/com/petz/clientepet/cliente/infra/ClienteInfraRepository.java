package br.com.petz.clientepet.cliente.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
	private final ClienteSpringDataJPARespository clienteSpringDataJPARespository;

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[inicia] ClienteRepository - salva");
		clienteSpringDataJPARespository.save(cliente);
		log.info("[finaliza] ClienteRepository - salva");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosClientes() {
		log.info("[inicia] ClienteRepository - buscaTodosClientes");
		List<Cliente> todosClientes = clienteSpringDataJPARespository.findAll();
		log.info("[finaliza] ClienteRepository - buscaTodosClientes");	
  	return todosClientes;
	}

	@Override
	public Cliente buscaClienteAtravesId(UUID idCliente) {
		Cliente cliente = clienteSpringDataJPARespository.findByIdCliente(idCliente)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
		return cliente;
	}

	@Override
	public void deletaCliente(Cliente cliente) {
		log.info("[inicia] ClienteRepository - deletaCliente");
		clienteSpringDataJPARespository.delete(cliente);
		log.info("[finaliza] ClienteRepository - deletaCliente");
		
	}
	

}
