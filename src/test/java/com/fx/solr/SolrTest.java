package com.fx.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrTest {

	@Test
	public void addDocument() throws SolrServerException, IOException {
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/Core");
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "100544");
		document.addField("item_price", 1234);
		solrServer.add(document);
		solrServer.commit();
	}

	@Test
	public void updateDocument() throws SolrServerException, IOException {
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/Core");
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "100544");
		document.addField("item_title", "testproduct11");
		document.addField("item_price", 123456);
		solrServer.add(document);
		solrServer.commit();
	}

	@Test
	public void deletesDocument() throws SolrServerException, IOException {
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/Core");
		solrServer.deleteById("100544");
		solrServer.commit();
	}

	@Test
	public void queryDocument() throws SolrServerException, IOException {
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/Core");
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
//		query.setStart(20);
		query.setRows(50);
		QueryResponse response = solrServer.query(query);
		SolrDocumentList documentList = response.getResults();
		System.out.println("共有记录:" + documentList.getNumFound());
		for (SolrDocument solrDocument : documentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_sell_point"));
			System.out.println(solrDocument.get("item_price"));
			System.out.println(solrDocument.get("item_image"));
			System.out.println(solrDocument.get("item_category_name"));
			System.out.println(solrDocument.get("item_desc"));
		}
	}
}
