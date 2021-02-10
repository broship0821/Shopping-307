package com.team1.shopping307.VO;

import java.util.Date;

public class RevuVO {
	private int reviewId; //후기번호
	private int patId; //구매번호
	private String userId; //작성자 아이디
	private String userName; //작성자 이름
	private String product; //구매한 상품 아이디
	private int star; //별(1~5)
	private String title; //후기 제목
	private String content; //후기 내용
	private Date cDate; //후기 작성일
	private Date uDate; //후기 수정일
	
	public RevuVO() {
	}

	public RevuVO(int reviewId, int patId, String userId, String userName, String product, int star, String title,
			String content, Date cDate, Date uDate) {
		this.reviewId = reviewId;
		this.patId = patId;
		this.userId = userId;
		this.userName = userName;
		this.product = product;
		this.star = star;
		this.title = title;
		this.content = content;
		this.cDate = cDate;
		this.uDate = uDate;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getPatId() {
		return patId;
	}

	public void setPatId(int patId) {
		this.patId = patId;
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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
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
	
	
	
}
