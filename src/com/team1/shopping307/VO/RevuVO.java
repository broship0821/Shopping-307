package com.team1.shopping307.VO;

import java.util.Date;

public class RevuVO {
	private int reviewId; //후기번호
	private long payId; //구매번호
	private String userId; //작성자 아이디
	private String userName; //작성자 이름
	private String productID; //구매한 상품 아이디
	private String productName; //구매한 상품 명
	private int star; //별(1~5)
	private String title; //후기 제목
	private String content; //후기 내용
	private Date cDate; //후기 작성일
	private Date uDate; //후기 수정일
	
	public RevuVO() {
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public long getPayId() {
		return payId;
	}

	public void setPayId(long payId) {
		this.payId = payId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public Date getuDate() {
		return uDate;
	}

	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}

	@Override
	public String toString() {
		return "RevuVO [reviewId=" + reviewId + ", payId=" + payId + ", userId=" + userId + ", userName=" + userName
				+ ", productID=" + productID + ", productName=" + productName + ", star=" + star + ", title=" + title
				+ ", content=" + content + ", cDate=" + cDate + ", uDate=" + uDate + "]";
	}

	
}
