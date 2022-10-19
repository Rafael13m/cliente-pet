package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.petz.clientepet.pet.application.api.PetAlterecaoRequest;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.api.PetsListResponse;


public interface PetService {

	PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest);
	List<PetsListResponse> BuscarTodosPets(UUID idCliente);
	PetsListResponse BuscarPetPorId(UUID idPet, UUID idCliente);
	void DeletaPorId(UUID idPet);
	void AlteraPet(@Valid PetAlterecaoRequest petRequest, UUID idCliente, UUID idPet);



}
