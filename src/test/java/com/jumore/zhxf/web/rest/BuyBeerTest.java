package com.jumore.zhxf.web.rest;

/**
 * 
 * @author Administrator
 *
 */
public class BuyBeerTest {
	/** 单价 **/
	public final static int MONEY_PRICE = 2;
	/** 瓶子价 **/
	public final static int BOTTLE_PRICE = 2;
	/** 瓶盖价 **/
	public final static int CAP_PRICE = 4;

	public static void main(String[] args) {
		BuyBeerTest test = new BuyBeerTest();
		int money = 10;
		System.out.println(String.format("花了%s元钱, 渴了啤酒:%s瓶", money, test.buyBeer(money, 0, 0, 0)));
	}

	public int buyBeer(int money, int beer, int bottle, int cap) {
		if (money >= 2) {
			int p = money / MONEY_PRICE;
			int dib = money % MONEY_PRICE;
			System.out.println("喝了[" + p + "]瓶");
			return p + buyBeer(dib, p + beer, bottle, cap);
		} else {
			if (beer > 0) {
				bottle = bottle + beer;
				cap = cap + beer;
				System.out.println(String.format("换了[%s]瓶酒", beer));
				System.out.println(String.format("余空瓶%s,盖%s", bottle, cap));
				return buyBeer(money, 0, bottle, cap);
			} else {
				if (bottle >= BOTTLE_PRICE || cap >= CAP_PRICE) {
					beer = bottle / BOTTLE_PRICE + cap / CAP_PRICE;
					System.out.println(String.format("%s空瓶%s盖子换了[%s]瓶酒", bottle, cap, beer));
					bottle = bottle % BOTTLE_PRICE;
					cap = cap % CAP_PRICE;
					System.out.println(String.format("余空瓶%s,盖%s", bottle, cap));
					return beer + buyBeer(money, beer, bottle, cap);
				} else {
					System.out.println(String.format("剩余零钱:%s,剩余空瓶:%s,余瓶盖:%s", money, bottle, cap));
				}
			}
		}
		return beer;
	}
}
