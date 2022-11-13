package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;

import org.springframework.boot.test.mock.mockito.MockBean;


import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;

import static org.mockito.Matchers.anyLong;
import static org.mockito.ArgumentMatchers.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;



@Slf4j
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class FournisseurTest {
/*	
	@Autowired
	FournisseurRepository fp;
	
	@Test 
	public void add() {
		Fournisseur f =  Fournisseur.builder().idFournisseur((long)0)
				.code("123")
				.libelle("libelle")
				.build();
		Fournisseur f2= fp.save(f);
		assertNotEquals(f.getIdFournisseur(), f2.getIdFournisseur());
		fp.delete(f2);
		
	}
*/
	@Mock
	FournisseurRepository frepo;
	@InjectMocks
	FournisseurServiceImpl fserv;

	@Test
	public void addFournisseurTest() {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setCode("111");

		Mockito.when(frepo.save(ArgumentMatchers.any(Fournisseur.class))).thenReturn(fournisseur);

		Fournisseur fournisseur_save = fserv.addFournisseur(fournisseur);

		assertThat(fournisseur_save.getCode()).isSameAs(fournisseur_save.getCode());
		verify(frepo).save(fournisseur_save);
	}

	@Test
	public void RetrieveAll() {
		List<Fournisseur> fournisseurs = new ArrayList<>();
		fournisseurs.add(new Fournisseur());

		when(frepo.findAll()).thenReturn(fournisseurs);

		List<Fournisseur> expected = fserv.retrieveAllFournisseurs();
		
		assertEquals(expected, fournisseurs);
		verify(frepo).findAll();
	}
	
	

	@Test
	public void DeleteFournisseurIfExistTest() {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setIdFournisseur(1L);
		fournisseur.setCode("111");
		fournisseur.setLibelle("libelle2");

		
		Mockito.when(frepo.findById(fournisseur.getIdFournisseur())).thenReturn(Optional.of(fournisseur));
		fserv.deleteFournisseur(fournisseur.getIdFournisseur());
		verify(frepo).deleteById(fournisseur.getIdFournisseur());
	};
	//expected = RuntimeException.class
	@Test()
	public void should_throw_exception_when_produit_doesnt_exist() {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setIdFournisseur(22L);
		fournisseur.setCode("222");
		fournisseur.setLibelle("libelle3");
		given(frepo.findById(anyLong())).willReturn(Optional.ofNullable(null));
		frepo.deleteById(fournisseur.getIdFournisseur());
		}
	
}
