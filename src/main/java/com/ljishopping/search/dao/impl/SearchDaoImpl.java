package com.ljishopping.search.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ljishopping.search.dao.SearchDao;
import com.ljishopping.search.pojo.ExtItem;
import com.ljishopping.search.pojo.SearchResult;

@Repository
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private SolrServer solrServer;

	@Override
	public SearchResult search(SolrQuery query) throws Exception {
		//return object
		SearchResult result = new SearchResult();
		//execute query
		QueryResponse response = solrServer.query(query);
		//get results
		SolrDocumentList documentList = response.getResults();
		//get query numbers
		long numFound = documentList.getNumFound();
		result.setTotal(numFound);
		List<ExtItem> extItems = new ArrayList<>();
		for (SolrDocument solrDocument : documentList) {
			solrDocument.get("id");               
			solrDocument.get("item_title");       
			solrDocument.get("item_sell_point");  
			solrDocument.get("item_price");       
			solrDocument.get("item_image");       
			solrDocument.get("item_category_name");
			solrDocument.get("item_desc");        
			ExtItem extItem =new ExtItem();
			extItem.setId((long)solrDocument.get("id"));
			extItem.setTitle((String)solrDocument.get("item_title"));
			extItem.setSell_point((String)solrDocument.get("item_sell_point")); 
			extItem.setPrice((long)solrDocument.get("item_price"));
			extItem.setImage((String)solrDocument.get("item_image"));
			extItem.setCategory_name((String)solrDocument.get("item_category_name"));
			extItem.setItem_desc((String)solrDocument.get("item_desc"));
			extItems.add(extItem);
		}
		result.setDatas(extItems);
		return null;
	}

}
