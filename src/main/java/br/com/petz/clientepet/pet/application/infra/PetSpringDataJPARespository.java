package br.com.petz.clientepet.pet.application.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.clientepet.pet.domain.Pet;

public interface PetSpringDataJPARespository extends JpaRepository<Pet, UUID> {

}
