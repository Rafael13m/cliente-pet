package br.com.petz.clientepet.cliente.application.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@AllArgsConstructor
public class ClienteController implements ClienteAPI {
	@Autowired
	private final ClienteService clienteService;


	@Override
	public ClienteResponse postCliente(ClienteRequest clienteRequest) {

		log.info("[inicia] ClienteController - postCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteController - postCliente");
		return clienteCriado;
	}


	@Override
	public List<ClienteListResponse> getTodosCliente() {
		log.info("[inicia] ClienteController - getTodosClientes");
		
		log.info("[finaliza] ClienteController - getTodosClientes");
		return null;
	}

}
