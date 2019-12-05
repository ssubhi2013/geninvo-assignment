package com.geninvo.service;

import java.util.List;

import com.geninvo.model.ShopBean;

public interface ShopService {
	ShopBean saveOrUpdateShop(ShopBean shopBean);

	List<ShopBean> getAllShops(String searchText);
}
