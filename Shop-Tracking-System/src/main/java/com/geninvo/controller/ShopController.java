package com.geninvo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geninvo.common.InvalidShopCategoryException;
import com.geninvo.dto.ResponseDto;
import com.geninvo.model.ShopBean;
import com.geninvo.service.ShopService;

/**
 * @author Satnam Singh - This Controller is responsible for shop information
 *         management
 *
 */
@RestController
@RequestMapping("/shop")
@CrossOrigin(origins = "*")
public class ShopController {

	@Autowired
	private ShopService shopService;

	Logger log = LoggerFactory.getLogger(ShopController.class.getName());

	/**
	 * @param search Its a text for search coming from client side
	 * @return On the basis of search text a list of shop records will be returned.
	 */
	@GetMapping
	public ResponseEntity<ResponseDto<List<ShopBean>>> getAll(
			@RequestParam(name = "search", required = false) String search) {

		ResponseDto<List<ShopBean>> response = new ResponseDto<>();

		try {

			List<ShopBean> dbLstShopBean = shopService.getAllShops(search);

			if (Optional.ofNullable(dbLstShopBean).isPresent()) {
				response.setSuccess(true);
				response.setTotalRecords(dbLstShopBean.size());
				response.setResult(dbLstShopBean);
				response.setMessage("List of shopes");
			}

		} catch (Exception e) {
			response.setMessage(e.getMessage());
			log.error(e.getMessage(), e);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	/**
	 * @param shopBean It contains information of new shop that will be persisted in
	 *                 the database.
	 * @return On successful data store a added record will be return as response.
	 */
	@PostMapping
	public ResponseEntity<ResponseDto<ShopBean>> saveOrUpdateShop(@RequestBody ShopBean shopBean) {

		ResponseDto<ShopBean> response = new ResponseDto<>();

		try {

			ShopBean dbShopBean = shopService.saveOrUpdateShop(shopBean);

			if (Optional.ofNullable(dbShopBean).isPresent()) {
				response.setSuccess(true);
				response.setTotalRecords(1);
				response.setResult(dbShopBean);
				response.setMessage("Shop added successfully...");
			}

		} catch (InvalidShopCategoryException e) {
			response.setMessage(e.getMessage());
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			log.error(e.getMessage(), e);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
