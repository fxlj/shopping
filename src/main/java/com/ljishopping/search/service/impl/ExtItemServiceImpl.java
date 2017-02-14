package com.ljishopping.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljishopping.common.pojo.LJIResult;
import com.ljishopping.common.util.ExceptionUtil;
import com.ljishopping.search.mapper.ExtItemMapper;
import com.ljishopping.search.pojo.ExtItem;
import com.ljishopping.search.service.ExtItemService;

@Service
public class ExtItemServiceImpl implements ExtItemService {

	@Autowired
	private ExtItemMapper solrItemMapper;
	@Autowired
	private SolrServer solrServer;

	@Override
	public LJIResult importAllItems() {
		try {
			List<ExtItem> extItems = solrItemMapper.getExtItems();
			// 把商品信息写入solr
			for (ExtItem extItem : extItems) {
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", extItem.getId());
				document.addField("item_title", extItem.getTitle());
				document.addField("item_sell_point", extItem.getSell_point());
				document.addField("item_price", extItem.getPrice());
				document.addField("item_image", extItem.getImage());
				document.addField("item_category_name", extItem.getCategory_name());
				document.addField("item_desc", extItem.getItem_desc());
				// 写入索引库
				solrServer.add(document);
			}
			// 提交修改
			solrServer.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return LJIResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return LJIResult.ok();
	}

}
