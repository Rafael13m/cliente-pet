package br.com.petz.clientepet.pet.application.infra;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.handler.APIException;
import br.com.petz.clientepet.pet.application.api.PetAlterecaoRequest;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
	private final PetSpringDataJPARespository petSpringDataJPARespository;

	@Override
	public Pet criaPet(Pet pet) {
		log.info("[inicia] PetInfraRepository - criaPet");
		petSpringDataJPARespository.save(pet);
		log.info("[finaliza] PetInfraRepository - criaPet");
		return pet;
	}

	@Override
	public List<Pet> BuscaPets() {
		List<Pet> lista = petSpringDataJPARespository.findAll();
		return lista;
	}

	@Override
	public Pet BuscaPetPorId(UUID idPet) {
		Pet pet = petSpringDataJPARespository
				.findById(idPet)
				.orElseThrow((() -> APIException.build(HttpStatus.NOT_FOUND, "Pet não encontrado!")));
		return pet;
	}

	@Override
	public void DeletaPet(Pet pet) {
		petSpringDataJPARespository.delete(pet);
	}

	@Override
	public void Salva(@Valid PetAlterecaoRequest petRequest) {
	
	}

}
