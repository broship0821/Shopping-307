package com.team1.shopping307.VO;

import java.text.ParseException;
import java.util.Date;

import com.team1.shopping307.Libs.Libs;

public class ReleHistVO {
	String releId; // 상품 출고 Id
	String userId; // buyer(구매자)
	String prodId; // 판매 상품 ID.
	String ProdName; // 상품 이름
	String caregory; // 상품 카테고리
	String isNew; // 'Y':신상, 'N':이월
	String standard; // 규격
	long price; // 판매가
	String status; // 상태('입금완료', '결제승인', '출고', '교환', '환불', '구매완료')
	Date cDate; // 판매일

	public ReleHistVO() {
	}

	public String getReleId() {
		return releId;
	}

	public void setReleId(String releId) {
		this.releId = releId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return ProdName;
	}

	public void setProdName(String prodName) {
		ProdName = prodName;
	}

	public String getCaregory() {
		return caregory;
	}

	public void setCaregory(String caregory) {
		this.caregory = caregory;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	@Override
	public String toString() {
		return "ReleHistVO [releId=" + releId + ", userId=" + userId + ", prodId=" + prodId + ", ProdName=" + ProdName
				+ ", caregory=" + caregory + ", isNew=" + isNew + ", standard=" + standard + ", price=" + price
				+ ", status=" + status + ", cDate=" + cDate + "]";
	}

}
