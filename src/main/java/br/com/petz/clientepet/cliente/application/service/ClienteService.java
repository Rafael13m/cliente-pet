package br.com.petz.clientepet.cliente.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;

public interface ClienteService {

	ClienteResponse criaCliente(ClienteRequest clienteRequest);
	List<ClienteListResponse> buscaTodosCLientes();
	ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente);
	void deletaClienteAtravesId(UUID idCliente);
	void patchAlteraCliente(UUID idCliente, @Valid ClienteAlteracaoRequest clienteRequest);
	
	
}
