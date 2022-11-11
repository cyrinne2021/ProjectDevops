package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
@RunWith(MockitoJUnitRunner.Silent.class)
public class ProduitTest {

	@Mock
	ProduitRepository produitrepo;
	@InjectMocks
	ProduitServiceImpl produitserv;

	@Test
	public void addProduitTest() {
		Produit produit = new Produit();
		produit.setCodeProduit("120"); 

		Mockito.when(produitrepo.save(ArgumentMatchers.any(Produit.class))).thenReturn(produit);

		Produit produit_save = produitserv.addProduit(produit);

		assertThat(produit_save.getCodeProduit()).isSameAs(produit_save.getCodeProduit());
		verify(produitrepo).save(produit_save);
	}

	@Test
	public void RetrieveAll() {
		List<Produit> produits = new ArrayList<>();
		produits.add(new Produit());

		when(produitrepo.findAll()).thenReturn(produits);

		List<Produit> expected = produitserv.retrieveAllProduits();
		
		assertEquals(expected, produits);
		verify(produitrepo).findAll();
	}
	
	

	@Test
	public void DeleteProduitIfExistTest() {
		Produit produit = new Produit();
		produit.setIdProduit(1L);
		produit.setCodeProduit("120");
		produit.setLibelleProduit("libelle2");
		produit.setPrix(16);

		
		Mockito.when(produitrepo.findById(produit.getIdProduit())).thenReturn(Optional.of(produit));
		produitserv.deleteProduit(produit.getIdProduit());
		verify(produitrepo).deleteById(produit.getIdProduit());
	};
	//expected = RuntimeException.class
	@Test()
	public void delete_produit_doesnt_exist() {
		Produit produit = new Produit();
		produit.setIdProduit(22L);
		produit.setCodeProduit("222");
		produit.setLibelleProduit("libelle3");
		produit.setPrix(20);
		given(produitrepo.findById(anyLong())).willReturn(Optional.ofNullable(null));
		produitrepo.deleteById(produit.getIdProduit());
		}
	
	
/*
	@Test
	public void whenGivenId_shouldUpdateProduit_ifFound() {
	Produit produit = new Produit();
	produit.setIdProduit(1L);
	produit.setCodeProduit("111");
	
	Produit newProduit = new Produit();
	produit.setCodeProduit("222");
	
	given(produitrepo.findById(produit.getIdProduit())).willReturn(Optional.of(produit));
	produitserv.updateProduit(newProduit);
	//produitserv.updateProduit(produit.getIdProduit(), newProduit);
	verify(produitrepo).save(newProduit);
	verify(produitrepo).findById(produit.getIdProduit());
	}
	
	
	@Test(expected = RuntimeException.class)
	public void should_throw_exception_when_produit_doesnt_exist() {
	Produit produit = new Produit();
	produit.setIdProduit(1L);
	produit.setCodeProduit("111");
	Produit newProduit = new Produit();
	newProduit.setIdProduit(2L);
	produit.setCodeProduit("222");
	given(produitrepo.findById(anyLong())).willReturn(Optional.ofNullable(null));
	produitserv.updateProduit(newProduit);
	//produitserv.updateProduit(produit.getIdProduit(), newProduit);
	}
	
	
*/	
	



/*
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProduitTest {
	
	@Autowired
	private ProduitServiceImpl service;
	
	@MockBean
	private ProduitRepository repository;

	
	@Test
	public void addProduitTest() throws ParseException, java.text.ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dc = dateFormat.parse("2022-11-15");
		Date dm = dateFormat.parse("2022-11-16");
		Mockito.when(repository.findAll()).thenReturn(Stream.of(new Produit("123","libelle",15,dc,dm), new Produit("456","libelle1",15,dc,dm)).collect(Collectors.toList()));
	    assertEquals(2, service.retrieveAllProduits().size());
	}

*/

}
