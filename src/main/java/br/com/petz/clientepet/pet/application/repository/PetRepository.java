package br.com.petz.clientepet.pet.application.repository;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.petz.clientepet.pet.application.api.PetAlterecaoRequest;
import br.com.petz.clientepet.pet.domain.Pet;

public interface PetRepository {

	Pet criaPet(Pet pet);

	List<Pet> BuscaPets();

	Pet BuscaPetPorId(UUID idPet);

	void DeletaPet(Pet pet);

	void Salva(@Valid PetAlterecaoRequest petRequest);

}
