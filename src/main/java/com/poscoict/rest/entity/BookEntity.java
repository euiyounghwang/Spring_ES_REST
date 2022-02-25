package com.poscoict.rest.entity;

import org.hibernate.annotations.CreationTimestamp;  
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;  
import java.util.Date;  
import java.util.UUID;  
  
@Entity
@Getter
@Setter
@ToString
@Table(name="book")  
public class BookEntity {  
  
  @Id  
  @Type(type = "uuid-char")  
  @GeneratedValue  
  private UUID id;  
  
  @Column(nullable = false)  
  private String name;  
  
  @Column(nullable = false)  
  private String category;  
  
  @Column(nullable = false)  
  private long sellCount;  
  
  @Column(nullable = false, updatable = false)  
  @Temporal(TemporalType.TIMESTAMP)  
  @CreationTimestamp  
  private Date createAt;

}

