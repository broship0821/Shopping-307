package com.team1.shopping307.VO;

public class BagVO {
	private int bagNo;
	private String prodName;//상품이름
	private int prodPrice;//가격
	private int prodCnt; //개수
	private String prodSize;//S,M,L,XL
	
	public BagVO() {
	}

	public int getBagNo() {
		return bagNo;
	}

	public void setBagNo(int bagNo) {
		this.bagNo = bagNo;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdCnt() {
		return prodCnt;
	}

	public void setProdCnt(int prodCnt) {
		this.prodCnt = prodCnt;
	}

	public String getProdSize() {
		return prodSize;
	}

	public void setProdSize(String prodSize) {
		this.prodSize = prodSize;
	}

}
