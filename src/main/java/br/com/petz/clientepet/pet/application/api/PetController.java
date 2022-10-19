package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.pet.application.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {
	private final PetService petService;

	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetController - postPet");
		log.info("[idCliente]{}", idCliente);
		PetResponse pet = petService.criaPet(idCliente, petRequest);
		log.info("[finaliza] PetController - postPet");
		return pet;
	}

	@Override
	public List<PetsListResponse> listaPet(UUID idCliente) {
		List<PetsListResponse> listaPets = petService.BuscarTodosPets(idCliente);
		return listaPets;
	}

	@Override
	public PetsListResponse buscaPetPorId(UUID idPet, UUID idCliente) {
		PetsListResponse petsListResponse = petService.BuscarPetPorId(idPet, idCliente);
		return petsListResponse;
	}

	@Override
	public void deletaClienteAtravesId(UUID idPet) {
		petService.DeletaPorId(idPet);
		
	}

	@Override
	public void PatchAlteraPet(UUID idPet, UUID idCliente, @Valid PetAlterecaoRequest petRequest) {
		petService.AlteraPet(petRequest, idCliente, idPet);
	}

	

	

}
