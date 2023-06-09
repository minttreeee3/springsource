package com.spring.memo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Item;
import com.spring.memo.entity.ItemSellStatus;

@SpringBootTest
public class ItemRepositoryTest {
	
	// ItemRepository 잘 작성되었는지 테스트 : 단위테스트
	@Autowired
	private ItemRepository repository;
	
	
//	@Test
//	public void itemCreateTest() {
//		Item item = new Item();
//		item.setItemNm("순수 프리미엄");
//		item.setPrice(29500);
//		item.setStockNumber(55);
//		item.setItemDetail("깨끗한 나라");
//		item.setItemSellStatus(ItemSellStatus.SELL); //Enum 넣는법
//		item.setRegTime(LocalDateTime.now());
//		item.setUpdateTime(LocalDateTime.now());
//		
//		Item newItem = repository.save(item);
//		
//		// Item.java에서 @build 쓰면 이렇게 할 수 있음 
//		item = Item.builder()
//						.itemNm("프롬비")
//						.price(45000)
//						.stockNumber(70)
//						.itemDetail("휴대용 선풍기")
//						.itemSellStatus(ItemSellStatus.SELL)
//						.regTime(LocalDateTime.now())
//						.updateTime(LocalDateTime.now())
//						.build();
//		
//		newItem = repository.save(item);
//		System.out.println(newItem);
//		
//	}
	
	
	// 조회
//	@Test
//	public void getItem() {
//		Optional<Item> item = repository.findById(1L);		
//		item.ifPresent(ele -> System.out.println(ele));
		
//		//한줄로
//		repository.findById(1L).ifPresent(ele -> System.out.println(ele));
//		
//		// 잘 찾으면 담고, 못찾으면 exception 
//		Item item = repository.findById(2L).orElseThrow(EntityNotFoundException::new);
//		System.out.println(item);
//	}
	
	
	// 전체조회
//	@Test
//	public void getItems() {
//
//		List<Item> list = repository.findAll();
//		
////		for (Item item : list) {
////			System.out.println(item);			
////		}
//		
//		list.forEach(item -> System.out.println(item));		
//	}
	
	
	// 상품명 조회
//	@Test
//	public void getItems() {
//
//		List<Item> list = repository.findByItemNm("반팔티");	
//		list.forEach(item -> System.out.println(item));		
//		
//	}
	
	// 상품명 or 상품상세 조회
//	@Test
//	public void getNameOrDetail() {
//		
//		List<Item> list = repository.findByItemNmOrItemDetail("블루투스 스피커", "카라티");
//		list.forEach(item -> System.out.println(item));		
//		
//	}
	
//	@Test
//	public void getPriceLessThan() {
//		
//		List<Item> list = repository.findByPriceLessThan(30000);
//		list.forEach(item -> System.out.println(item));		
//		
//	}
	
	@Test
	public void getPriceLessThanOrder() {
		
		repository.findByPriceLessThanOrderByPriceDesc(50000)
					.forEach(item -> System.out.println(item));		
		
	}
	
	
	
	
	

}
