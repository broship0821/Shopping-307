package com.team1.shopping307.VO;

import java.text.ParseException;
import java.util.Date;

import com.team1.shopping307.Libs.Libs;

public class ProdVO {
   String productId; // 상품 ID
   String productName; // 상품 이름
   String category; // 아우터, 상의, 하의 분류품
   String isNew; // 'Y':신상, 'N':이월
   String standard; // 규격
   long price; // 가격
   long stock; // 재고수량
   String bigo; // 설명
   Date startDate; // 판매시작일, null 또는 이 날짜 이후 조회됨

   String image1; // 대표이미지
   String image2; // 상세이미지 1
   String image3; // 상세이미지 2

   public String getProductId() {
      return productId;
   }

   public void setProductId(String productId) {
      this.productId = productId;
   }

   public String getProductName() {
      return productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
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

   public long getPrice() {
      return price;
   }

   public void setPrice(long price) {
      this.price = price;
   }

   public long getStock() {
      return stock;
   }

   public void setStock(long stock) {
      this.stock = stock;
   }

   public String getBigo() {
      return bigo;
   }

   public void setBigo(String bigo) {
      this.bigo = bigo;
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

   public ProdVO() {
   }

   
   public ProdVO(String productId, String productName, String category,
         String isNew, String standard, String price, String stock, String bigo, 
         String startDate, String image1, String image2, String image3) throws ParseException {
      this(productId, productName, category, isNew, standard,
            Libs.strToInt(price, 0), Libs.strToInt(stock, 0),  bigo, 
            Libs.strToDate(startDate), image1, image2, image3);
   }

   public ProdVO(String productId, String productName, String category,
         String isNew, String standard, long price, long stock, String bigo, 
         Date startDate, String image1, String image2, String image3) {
      this.productId   = productId;
      this.productName = productName;
      this.category    = category;
      this.isNew       = isNew;
      this.standard    = standard;
      this.price       = price;
      this.stock       = stock;
      this.bigo        = bigo;
      this.startDate   = startDate;
      this.image1      = image1;
      this.image2      = image2;
      this.image3      = image3;
   }

   @Override
   public String toString() {
      return "productId=" + productId  
         + ", productName=" + productName
         + ", category=" + category   
         + ", isNew=" + isNew      
         + ", standard=" + standard   
         + ", price=" + price      
         + ", stock=" + stock      
         + ", bigo=" + bigo       
         + ", startDate=" + Libs.dateToStr(startDate)  
         + ", image1=" + image1     
         + ", image2=" + image2     
         + ", image3=" + image3;           
   }

}
