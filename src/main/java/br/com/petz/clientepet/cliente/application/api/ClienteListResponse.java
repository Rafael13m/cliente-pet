package br.com.petz.clientepet.cliente.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.Value;

@Value
public class ClienteListResponse {
	private UUID idCliente;
	private String nomeCompleto;
	private String cpf;
	private String celular;
	private String email;
	
	
	public static List<ClienteListResponse> converte(List<Cliente> clientes) {
		return clientes.stream()
				.map(cliente -> new ClienteListResponse(cliente))
				.collect(Collectors.toList());
	}


	private ClienteListResponse(Cliente cliente) {
		
		
		this.idCliente = cliente.getIdCliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.cpf = cliente.getCpf();
		this.celular = cliente.getCelular();
		this.email = cliente.getEmail();
	}
	
	
}