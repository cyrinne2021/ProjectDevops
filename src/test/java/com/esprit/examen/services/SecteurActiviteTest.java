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
@RunWith(MockitoJUnitRunner.class)
public class SecteurActiviteTest {
	
	@Mock
	private SecteurActiviteRepository or;
	
	private SecteurActivite o1 = new SecteurActivite("hhh",null,"nizar");
	private SecteurActivite o2 = new SecteurActivite("hhh",null,"mahmoudi");
	  
	@InjectMocks
	    SecteurActiviteServiceImpl os;
	
    
    @Test
	public void addSecteurActiviteTest() {
    	when(or.save(o1)).thenReturn(o1);
    	assertNotNull(o1);
		assertEquals(o1, os.addSecteurActivite(o1)); 
		System.out.println("add works !");
	}
	
   @Test 
    public void retrieveAllSecteurActivitesTest() {
    	when(or.findAll()).thenReturn(Stream
    			.of(o1,o2)
    			.collect(Collectors.toList()));
    	assertEquals(2,os.retrieveAllSecteurActivites().size());
    	System.out.println("Retrieve operators works !");
    }
    
   
    
    @Test
    public void DeleteSecteurActiviteTest() {
    	or.save(o1);
    	os.deleteSecteurActivite(o1.getIdSecteurActivite());
    	verify(or, times(1)).deleteById(o1.getIdSecteurActivite());
    	System.out.println("Delete works !");
    	
    }

    
    @Test 
    public void UpdateSecteurActiviteTest() {
    	when(or.save(o1)).thenReturn(o1);
    	assertNotNull(o1);
    	assertEquals(o1, os.updateSecteurActivite(o1));
    	System.out.println("Update works !");
    }
    
    @Test
    public void retrieveSecteurActiviteTest() {
    	when(or.findById(o1.getIdSecteurActivite())).thenReturn(Optional.of(o1));
    	assertEquals(o1, os.retrieveSecteurActivite(o1.getIdSecteurActivite()));
    	System.out.println("Retrieve operator works !");
    }
    
    
}





















