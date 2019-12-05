package com.geninvo.common;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utility {
	public static String getValidCategories() {
		return Stream.of(Categories.values()).map(category -> category.getCategory())
				.collect(Collectors.joining(", ", "[", "]"));
	}
}
