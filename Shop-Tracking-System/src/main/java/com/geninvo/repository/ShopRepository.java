package com.geninvo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geninvo.model.ShopBean;

/**
 * @author Satnam Singh - Spring Data JPA repository to manage and handle CRUD
 *         operations of ShopBean entity
 *
 */
@Repository
public interface ShopRepository extends CrudRepository<ShopBean, Integer> {
	List<ShopBean> findByShopNameContainingOrShopAddressContaining(String shopName, String shopAddress);
}
