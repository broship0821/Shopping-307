package com.team1.shopping307.VO;

import java.text.ParseException;
import java.util.Date;

import com.team1.shopping307.Libs.Libs;

public class ReleHistVO {
   String releId;          // 상품 출고 Id     
   String userId;          // buyer(구매자)
   String prodId;          // 판매 상품 ID.
   long price;             // 판매가
   Date cDate;             // 판매일
   
   public ReleHistVO() {
   }

   public ReleHistVO(String releId, String userId, 
         String prodId, long price, Date cDate) {
       this.releId = releId;     
       this.userId = userId;
       this.prodId = prodId;
       this.price  = price;
       this.cDate  = cDate;
   }

   @Override
   public String toString() {
      return "releId: " + releId       
         + ", userId: " + userId 
         + ", prodId: " + prodId 
         + ", price : " + price 
         + ", cDate : " + Libs.dateTimeToStr(cDate); 
      
   }

}
