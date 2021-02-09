package com.team1.shopping307.VO;

import java.text.ParseException;
import java.util.Date;

import com.team1.shopping307.Libs.Libs;

public class ProdVO {
   String productId; // 상품 ID
   String isNew; // 'Y':신상, 'N':이월
   String standard; // 규격
   Date startDate; // 판매시작일, null 또는 이 날짜 이후 조회됨
   String image1; // 대표이미지
   String image2; // 상세이미지 1
   String image3; // 상세이미지 2
   String productName; // 상품 이름
   String info;
   long stock; // 재고수량
   String category; // 아우터, 상의, 하의 분류품
   long price; // 가격
   long hit; // 조회수

   public String getProductId() {
      return productId;
   }

   public void setProductId(String productId) {
      this.productId = productId;
   }

   public String getIsNew() {
      return isNew;
   }

   public void setIsNew(String isNew) {
      this.isNew = isNew;
   }

   public String getStandard() {
      return standard;
   }

   public void setStandard(String standard) {
      this.standard = standard;
   }

   public Date getStartDate() {
      return startDate;
   }

   public void setStartDate(Date startDate) {
      this.startDate = startDate;
   }

   public String getImage1() {
      return image1;
   }

   public void setImage1(String image1) {
      this.image1 = image1;
   }

   public String getImage2() {
      return image2;
   }

   public void setImage2(String image2) {
      this.image2 = image2;
   }

   public String getImage3() {
      return image3;
   }

   public void setImage3(String image3) {
      this.image3 = image3;
   }

   public String getProductName() {
      return productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public String getInfo() {
      return info;
   }

   public void setInfo(String info) {
      this.info = info;
   }

   public long getStock() {
      return stock;
   }

   public void setStock(long stock) {
      this.stock = stock;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public long getPrice() {
      return price;
   }

   public void setPrice(long price) {
      this.price = price;
   }

   public long getHit() {
      return hit;
   }

   public void setHit(long hit) {
      this.hit = hit;
   }

   public ProdVO() {
   }

   public ProdVO(String productId, String isNew, String standard, String startDate, String image1, String image2,
         String image3, String productName, String info, long stock, String category, long price, long hit) throws ParseException {
      this(productId, isNew, standard, Libs.strToDate(startDate), 
            image1, image2, image3, productName, info, stock, category, price, hit);
   }

   public ProdVO(String productId, String isNew, String standard, Date startDate, String image1, String image2,
         String image3, String productName, String info, long stock, String category, long price, long hit) {
      this.productId = productId;
      this.isNew = isNew;
      this.standard = standard;
      this.startDate = startDate;
      this.image1 = image1;
      this.image2 = image2;
      this.image3 = image3;
      this.productName = productName;
      this.info = info;
      this.stock = stock;
      this.category = category;
      this.price = price;
      this.hit = hit;
   }

   @Override
   public String toString() {
      return "";
   }

}
