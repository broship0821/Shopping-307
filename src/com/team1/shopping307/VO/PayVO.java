package com.team1.shopping307.VO;

import java.text.ParseException;

public class PayVO {
   long payId;             // 구분번호   YYYYMMDDNNNNN  (= 구매번호 = 결재번호)

   String sellerName;      // 판매자 이름
   String sellerPhone;     // 판매자 전화번호
   String sellerZip;       // 판매자 우편번호(우편번호 검색 기능은 생략)
   String sellerAddress;   // 판매자 주소
          
   long buyerId;           // 구매자 아이디
   String buyerName;       // 구매자 이름
   String buyerPhone;      // 구매자 전화번호
   String buyerZip;        // 구매자 우편번호
   String buyerAddress;    // 구매자 주소

   String itemsInfo;       // 상품 정보(수량, 품목 리스트)
   int amount;             // 결제금액
   String cashOrCard;      // 'C':카드, 'S':현금, 'B':무통장입금
   String cardNo;          // 카드번호

   String status;          // 상태('입금완료', '결제승인', '출고', '교환', '환불', '구매완료')
   
   // 운송장번호 (생략)
   // 발송일(결제일로 함)
   
   public long getPayId() {
      return payId;
   }

   public void setPayId(long payId) {
      this.payId = payId;
   }

   public String getSellerName() {
      return sellerName;
   }

   public void setSellerName(String sellerName) {
      this.sellerName = sellerName;
   }

   public String getSellerPhone() {
      return sellerPhone;
   }

   public void setSellerPhone(String sellerPhone) {
      this.sellerPhone = sellerPhone;
   }

   public String getSellerZip() {
      return sellerZip;
   }

   public void setSellerZip(String sellerZip) {
      this.sellerZip = sellerZip;
   }

   public String getSellerAddress() {
      return sellerAddress;
   }

   public void setSellerAddress(String sellerAddress) {
      this.sellerAddress = sellerAddress;
   }

   public long getBuyerId() {
      return buyerId;
   }

   public void setBuyerId(long buyerId) {
      this.buyerId = buyerId;
   }

   public String getBuyerName() {
      return buyerName;
   }

   public void setBuyerName(String buyerName) {
      this.buyerName = buyerName;
   }

   public String getBuyerPhone() {
      return buyerPhone;
   }

   public void setBuyerPhone(String buyerPhone) {
      this.buyerPhone = buyerPhone;
   }

   public String getBuyerZip() {
      return buyerZip;
   }

   public void setBuyerZip(String buyerZip) {
      this.buyerZip = buyerZip;
   }

   public String getBuyerAddress() {
      return buyerAddress;
   }

   public void setBuyerAddress(String buyerAddress) {
      this.buyerAddress = buyerAddress;
   }

   public String getItemsInfo() {
      return itemsInfo;
   }

   public void setItemsInfo(String itemsInfo) {
      this.itemsInfo = itemsInfo;
   }

   public int getAmount() {
      return amount;
   }

   public void setAmount(int amount) {
      this.amount = amount;
   }

   public String getCashOrCard() {
      return cashOrCard;
   }

   public void setCashOrCard(String cashOrCard) {
      this.cashOrCard = cashOrCard;
   }

   public String getCardNo() {
      return cardNo;
   }

   public void setCardNo(String cardNo) {
      this.cardNo = cardNo;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public PayVO() {
   }

   public PayVO(String payId, String sellerName, String sellerPhone, String sellerZip,
         String sellerAddress, String buyerId, String buyerName, String buyerPhone,
         String buyerZip, String buyerAddress, String itemsInfo, String amount,
         String cashOrCard, String cardNo, String status
         ) throws ParseException {
      this(Long.valueOf(payId), sellerName, sellerPhone, sellerZip,
            sellerAddress, Long.valueOf(buyerId), buyerName, buyerPhone,
            buyerZip, buyerAddress, itemsInfo, Integer.valueOf(amount),
            cashOrCard, cardNo, status);
   }

   public PayVO(long payId, String sellerName, String sellerPhone, String sellerZip,
         String sellerAddress, long buyerId, String buyerName, String buyerPhone,
         String buyerZip, String buyerAddress, String itemsInfo, int amount,
         String cashOrCard, String cardNo, String status) {
      this.payId         = payId;
      this.sellerName    = sellerName;
      this.sellerPhone   = sellerPhone;
      this.sellerZip     = sellerZip;
      this.sellerAddress = sellerAddress;
      this.buyerId       = buyerId;
      this.buyerName     = buyerName;
      this.buyerPhone    = buyerPhone;
      this.buyerZip      = buyerZip;
      this.buyerAddress  = buyerAddress;
      this.itemsInfo     = itemsInfo;
      this.amount        = amount;
      this.cashOrCard    = cashOrCard;
      this.cardNo        = cardNo;
      this.status        = status;
   }

   @Override
   public String toString() {
      return "payId: " + payId
            + ", sellerName: " + sellerName
            + ", sellerPhone: " + sellerPhone
            + ", sellerZip: " + sellerZip
            + ", sellerAddres: " + sellerAddress
            + ", buyerId: " + buyerId
            + ", buyerName: " + buyerName
            + ", buyerPhone: " + buyerPhone
            + ", buyerZip: " + buyerZip
            + ", buyerAddress: " + buyerAddress
            + ", itemsInfo: " + itemsInfo
            + ", amount: " + amount
            + ", cashOrCard: " + cashOrCard
            + ", cardNo: " + cardNo
            + ", status: " + status;
   }

}
