package store;

import org.springframework.stereotype.Component;

@Component
public class StoreDTO {
	public int id;
	public String foodname;
	public String loc;
	public String discount;
	public String price;
	public String badge;
	public String imageurl;
	public String getBeforeprice() {
		return beforeprice;
	}
	public void setBeforeprice(String beforeprice) {
		this.beforeprice = beforeprice;
	}
	public String beforeprice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
}
