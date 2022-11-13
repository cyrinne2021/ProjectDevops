package com.esprit.examen.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FournisseurMock {
	
	@Mock
	FournisseurRepository fp ; 
	@InjectMocks
	IFournisseurService is;
	
	Fournisseur f = Fournisseur.builder().code("123").libelle("libelle").build();
	
	List<Fournisseur> list = new ArrayList<Fournisseur> () {
		{
			add(Fournisseur.builder().code("123").libelle("libelle").build());
			add(Fournisseur.builder().code("123").libelle("libelle").build());
			
		}
	};
	
	@Test 
	public void addFournisseur() {
		Mockito.when(fp.save(Mockito.anyObject())).thenReturn(f);
	}
}

	
	


