package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import com.esprit.examen.services.SecteurActiviteServiceImpl;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

import javax.persistence.OneToMany;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class SecteurActiviteTest {


	@Mock
	SecteurActiviteRepository secteurRepository;
	@InjectMocks
	SecteurActiviteServiceImpl secteurService;


	@Test
	public void testRetrieveSecteurActivite() {

		SecteurActivite secteur = new SecteurActivite(null, "heyhey" ,"hey");
		secteur.setIdSecteurActivite(1L);

		Mockito.when(secteurRepository.findById(1L)).thenReturn(Optional.of(secteur));
		secteurService.retrieveSecteurActivite(1L);
		Assertions.assertNotNull(secteur);


		System.out.println(secteur); 
		System.out.println(" Retrieve is working correctly...!!");  

	}
	@Test
	public void createSecteurActiviteTest()
	{

		SecteurActivite secteur2 = new SecteurActivite(null, "abcd" ,"azaz");
		secteur2.setIdSecteurActivite(1L);
		secteurService.addSecteurActivite(secteur2);
		verify(secteurRepository, times(1)).save(secteur2);
		System.out.println(secteur2); 
		System.out.println(" Create is working correctly...!!");  
	}
	@Test
	public void getAllSecteurActiviteTest()
	{
		List<SecteurActivite> Catprodlist = new ArrayList<SecteurActivite>() {

			{
				add(new SecteurActivite(null, "azertt" ,"dede"));
				add(new SecteurActivite(null, "eeee" ,"ddd"));
				add(new SecteurActivite(null, "aeedbcd" ,"ggg"));
			}};

	}

	
          @Test
      public void TestDeleteSecteurActivite(){

	SecteurActivite secteur1 = new SecteurActivite(null, "nizar" ,"azaz");
	secteur1.setIdSecteurActivite(2L);

	Mockito.lenient().when(SecteurActiviteRepository.findById(secteur1.getIdSecteurActivite())).thenReturn(Optional.of(secteur1));

	SecteurActiviteService.deleteSecteurActivite(2L);
	verify(SecteurActiviteRepository).deleteById(secteur1.getIdSecteurActivite());

	System.out.println(secteur1);
	System.out.println(" Delete is working correctly...!!");  
}

}


























