package com.spring.memo.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Orders {
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	private LocalDateTime orderDateTime;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	// mappedBy : 양방향 매핑에서 주인이 누구냐? 
	@OneToMany(mappedBy = "orders") // 양방향 참조일때 기준을 잡아줌 
	private List<OrderItem> orderItems;

}
