package entity;

/**
 * 
 * @描述 衣服实体类
 * @作者 lubiao
 * @时间 2017年8月7日-下午6:34:16
 *
 */
public class Clothes {

	private int id;
	private String clothesType;
	private float price;
	private float vipPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClothesType() {
		return clothesType;
	}

	public void setClothesType(String clothesType) {
		this.clothesType = clothesType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(float vipPrice) {
		this.vipPrice = vipPrice;
	}

	public Clothes(String clothesType, float price, float vipPrice) {
		super();
		this.clothesType = clothesType;
		this.price = price;
		this.vipPrice = vipPrice;
	}

	public Clothes() {
		super();
	}

}
