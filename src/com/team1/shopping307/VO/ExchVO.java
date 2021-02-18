package com.team1.shopping307.VO;

import java.text.ParseException;

import com.team1.shopping307.Libs.Libs;

public class ExchVO {
   String exchangeId;       // 교환/환불 ID.
   long payId;              // 구매ID
   String exchangeOrRefund; // ‘E’:교환, ‘R’:환불
   String status;           // 추가 -- 상태('교환신청', '환불신청', '교환완료', '환불완료'))

   public String getExchangeId() {
      return exchangeId;
   }

   public void setExchangeId(String exchangeId) {
      this.exchangeId = exchangeId;
   }

   public long getPayId() {
      return payId;
   }

   public void setPayId(long payId) {
      this.payId = payId;
   }

   public String getExchangeOrRefund() {
      return exchangeOrRefund;
   }

   public void setExchangeOrRefund(String exchangeOrRefund) {
      this.exchangeOrRefund = exchangeOrRefund;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public ExchVO() {
   }

   public ExchVO(String exchangeId, String payId, 
         String exchangeOrRefund, String status) throws ParseException {
      this(exchangeId, Integer.valueOf(payId), exchangeOrRefund, status);
   }

   public ExchVO(String exchangeId, long payId, String exchangeOrRefund, String status) {
      this.exchangeId       = exchangeId;
      this.payId            = payId;
      this.exchangeOrRefund = exchangeOrRefund;
      this.status           = status;
   }

   @Override
   public String toString() {
      return "exchangeId: " + exchangeId
         + ", payId: " + payId
         + ", exchangeOrRefund: " + exchangeOrRefund
         + ", status: " + status;
   }

}
