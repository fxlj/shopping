package com.ljishopping.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljishopping.search.dao.SearchDao;
import com.ljishopping.search.pojo.SearchResult;
import com.ljishopping.search.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;

	@Override
	public SearchResult search(String q, int page, int rows) throws Exception {
		SolrQuery query = new SolrQuery();
		query.setQuery(q);
		query.setStart((page - 1) * rows);
		query.setRows(rows);
		// 默认搜索域
		query.set("df", "item_keywords");
		// 开启高亮显示
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em stytle=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		SearchResult search = searchDao.search(query);
		long total = search.getTotal();
		long pageNum = (total + rows - 1) / rows;
		search.setPageNum(pageNum);
		search.setPageNo(page);
		return search;
	}

}
