package com.geninvo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geninvo.common.Categories;
import com.geninvo.common.InvalidShopCategoryException;
import com.geninvo.common.Utility;
import com.geninvo.model.ShopBean;
import com.geninvo.repository.ShopRepository;
import com.geninvo.service.ShopService;

/**
 * @author Satnam Singh - Its a implementation class of Shop Services
 *
 */
@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopRepository shopRepository;

	@Override
	public ShopBean saveOrUpdateShop(ShopBean shopBean) {

		if (!isValidShopCategory(shopBean.getShopCategory())) {
			throw new InvalidShopCategoryException(
					"Enter a Invalid Category. Valid Categories are : " + Utility.getValidCategories());
		}

		if (!Optional.ofNullable(shopBean.getId()).isPresent()) {
			shopBean.setCreatedDate(LocalDateTime.now());
		}
		shopBean.setUpdatedDate(LocalDateTime.now());
		return shopRepository.save(shopBean);
	}

	private boolean isValidShopCategory(String shopCategory) {
		return Stream.of(Categories.values()).anyMatch(value -> value.getCategory().equalsIgnoreCase(shopCategory));
	}

	@Override
	public List<ShopBean> getAllShops(String searchText) {
		List<ShopBean> lstShopBeans = new ArrayList<>();

		if (Optional.ofNullable(searchText).isPresent() && !searchText.trim().isEmpty()) {
			shopRepository.findByShopNameContainingOrShopAddressContaining(searchText, searchText)
					.forEach(lstShopBeans::add);
		} else {
			shopRepository.findAll().forEach(lstShopBeans::add);
		}

		return lstShopBeans;
	}
}
