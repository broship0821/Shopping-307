package com.team1.shopping307.VO;

public class BagVO {
	private int bagNo;
	private String prodName;//상품이름
	private int prodPrice;//가격
	private int prodCnt; //개수
	private String image1;
	private String productID;
	
	
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

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	

}
