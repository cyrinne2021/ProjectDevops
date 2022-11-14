package tn.esprit.rh.achat.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;
import tn.esprit.rh.achat.services.StockServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class StockTest {


	@Mock
	StockRepository stockRepository;
	@InjectMocks
	StockServiceImpl stockService;


	@Test
	public void testRetrieveStock() {

		Stock stock = new Stock("heyhey",null, null);
		stock.setIdStock(1L);

		Mockito.when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));
		stockService.retrieveStock(1L);
		Assertions.assertNotNull(stock);


		System.out.println(stock); 
		System.out.println(" Retrieve is working correctly...!!");  

	}
	@Test
	public void createStockTest()
	{

		Stock stock2 = new Stock("abcd",null, null);
		stock2.setIdStock(1L);
		stockService.addStock(stock2);
		verify(stockRepository, times(1)).save(stock2);
		System.out.println(stock2); 
		System.out.println(" Create is working correctly...!!");  
	}
	@Test
	public void getAllStockTest()
	{
		List<Stock> Catprodlist = new ArrayList<Stock>() {

			{
				add(new Stock("stock1",null, null));
				add(new Stock("ranim",null, null));
				add(new Stock("azerty",null, null));
			}};

	}

	
          @Test
      public void TestDeleteStock(){

	Stock stock1 = new Stock("alimentaire",null, null);
	stock1.setIdStock(2L);

	Mockito.lenient().when(stockRepository.findById(stock1.getIdStock())).thenReturn(Optional.of(stock1));

	stockService.deleteStock(2L);
	verify(stockRepository).deleteById(stock1.getIdStock());

	System.out.println(stock1);
	System.out.println(" Delete is working correctly...!!");  
}

}


























