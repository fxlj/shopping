package com.ljishopping.search.service;

import com.ljishopping.search.pojo.SearchResult;

public interface SearchService {
	SearchResult search(String query, int page, int rows) throws Exception;
}
