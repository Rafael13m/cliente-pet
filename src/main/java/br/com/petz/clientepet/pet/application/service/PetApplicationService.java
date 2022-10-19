package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetAlterecaoRequest;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.api.PetsListResponse;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
	private final PetRepository petRepository;
	private final ClienteService clienteService;

	@Override
	public PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetApplicationService - criaPet");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.criaPet(new Pet(petRequest, idCliente));
		log.info("[finaliza] PetApplicationService - criaPet");
		return new PetResponse(pet.getIdPet());
	}

	@Override
	public List<PetsListResponse> BuscarTodosPets(UUID idCliente) {
		clienteService.buscaClienteAtravesId(idCliente);
		List<Pet> listaPets = petRepository.BuscaPets();
		return PetsListResponse.converte(listaPets);
	}

	@Override
	public PetsListResponse BuscarPetPorId(UUID idPet, UUID idCliente) {
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.BuscaPetPorId(idPet);
		return new PetsListResponse(pet);
	}

	@Override
	public void DeletaPorId(UUID idPet) {
		Pet pet = petRepository.BuscaPetPorId(idPet);
		petRepository.DeletaPet(pet);
		
	}

	@Override
	public void AlteraPet(@Valid PetAlterecaoRequest petRequest, UUID idCliente, UUID idPet) {
		log.info("[inicia] PetApplicationService - AlteraPet");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.BuscaPetPorId(idPet);
		pet.altera(petRequest);
		petRepository.criaPet(pet);
		log.info("[finaliza] PetApplicationService - AlteraPet");
		
	}
	
}
