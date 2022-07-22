package br.com.petz.clientepet.cliente.application.api;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Value;

@Value
public class ClienteResponse {

	private UUID idCliente;
	
	
}
