package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.petz.clientepet.pet.domain.Pet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import lombok.Value;

@Value
public class PetsListResponse {

	private UUID idPet;
	private String nomePet;
	private TipoPet tipo;
	private String raca;
	private String pelagemCor;
	private LocalDate dataNascimento;

	public static List<PetsListResponse> converte(List<Pet> listaPets) {
		return listaPets.stream()
				.map(PetsListResponse::new)
				.collect(Collectors.toList());
	}

	public PetsListResponse(Pet pet) {
		
		this.idPet = pet.getIdPet();
		this.nomePet = pet.getNomePet();
		this.tipo = pet.getTipo();
		this.raca = pet.getRaca();
		this.pelagemCor = pet.getPelagemCor();
		this.dataNascimento = pet.getDataNascimento();
	}

}
