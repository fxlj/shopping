package com.ljishopping.search.dao;

import org.apache.solr.client.solrj.SolrQuery;
import com.ljishopping.search.pojo.SearchResult;

public interface SearchDao {
	SearchResult search(SolrQuery query) throws Exception;
}
