package com.team1.shopping307.DAO;

public class ProdDAO {
	public static int insert(String product_name, String clothes, String price, int warehousing, int stock,
			String info) {
                int result=0;
                try {
                        int warehousing1 = Integer.valueOf(warehousing);
                        int stock1 = Integer.valueOf(stock);
                        int stock2 = stock1 + warehousing1;
                        result = insert(product_name, clothes, price, warehousing1, stock1, info);
                } catch(Exception e) {
                        e.printStackTrace();
                }
                return result;
                
        }
}
