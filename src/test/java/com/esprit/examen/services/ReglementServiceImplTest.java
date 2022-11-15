package com.esprit.examen.services;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

class ReglementServiceImplTest {

    @Mock
    private ReglementRepository reglementRepository;

    @InjectMocks
     private ReglementServiceImpl reglementService ;

    @Test
    void canAddRegelemnt(){
        //given
        Reglement reglment = new Reglement();
        //when
        reglementService.addReglement(reglment);
        //then
        ArgumentCaptor<Reglement> ReglementArgumentCaptor = ArgumentCaptor.forClass(Reglement.class) ;
        verify(reglementRepository).save(ReglementArgumentCaptor.capture())  ;

        Reglement capturedReglement = ReglementArgumentCaptor.getValue();
        assertThat(capturedReglement).isEqualTo(reglment) ;
    }

    @Test
    public void canRetreiveallReglements(){
        //when
        reglementService.retrieveAllReglements();
        //then
        verify(reglementRepository).findAll();
    }

    @Test

    public void canRetrieveReglement(){
        //when
        reglementService.retrieveReglement(1L) ;
        //then
        verify(reglementRepository).findById(1L) ;

    }

    @Test

    public void canRetrieveReglementbyFacture(){
        //when
        reglementService.retrieveReglementByFacture(1L);
        //then
        verify(reglementRepository).retrieveReglementByFacture(1L);
    }
}
