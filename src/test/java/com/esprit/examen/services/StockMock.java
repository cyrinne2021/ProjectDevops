package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockMock {

	@Mock
	StockRepository sr;
	@InjectMocks
	StockServiceImpl si;

	Stock s = Stock.builder().libelleStock("libelle").qte(30).qteMin(10).build();
	List<Stock> list = new ArrayList<Stock>() {
		{
			add(Stock.builder().libelleStock("libelle").qte(30).qteMin(10).build());
			add(Stock.builder().libelleStock("libelle").qte(30).qteMin(10).build());
		}
	};
	@Test
	public void addStock() {
		Stock s2 = Stock.builder().libelleStock("libelle").qte(35).qteMin(10).build();
		Mockito.when(sr.save(Mockito.any())).thenReturn(s);
		Stock stock=si.addStock(s2);
		assertNotNull(stock);
	}
}
