package com.qfjy.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
// java bean包名  ：pojo   bean   entity  domain
public class Users {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private String uname;
   private int age;
   private Date currtDate;
}
