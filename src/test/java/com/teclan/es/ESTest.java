package com.teclan.es;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.domain.Sort;

import com.teclan.Main;
import com.teclan.model.Item;
import com.teclan.repository.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class ESTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ESTest.class);
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void testCreateIndex() {
		elasticsearchTemplate.createIndex(Item.class);
		// 创建索引后必须创建Mapping，否后续无法搜索
		elasticsearchTemplate.putMapping(Item.class);
	}

	@Test
	public void testDeleteIndex() {
		elasticsearchTemplate.deleteIndex(Item.class);
	}

	@Test
	public void testInsertDocument() {
		Item item = new Item(1L, "小米手机7", " 手机", "小米", 3499.00, "http://image.baidu.com/13123.jpg");
		itemRepository.save(item);
	}
	
	@Test
	public void insertList() {
	    List<Item> list = new ArrayList<>();
	    list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.baidu.com/13123.jpg"));
	    list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.baidu.com/13123.jpg"));
	    // 接收对象集合，实现批量新增
	    itemRepository.saveAll(list);
	}
	
	@Test
	public void update(){
	    Item item = new Item(1L, "苹果XSMax", " 手机",
	            "小米", 3499.00, "http://image.baidu.com/13123.jpg");
	    itemRepository.save(item);
	}
	
	@Test
	public void testQueryAll(){
	    // 查找所有
        //Iterable<Item> list = this.itemRepository.findAll();
        // 对某字段排序查找所有 Sort.by("price").descending() 降序
        // Sort.by("price").ascending():升序
		
//        Iterable<Item> list = this.itemRepository.findAll(Sort.by("price").ascending());
		
		Iterable<Item> list = this.itemRepository.findAll();

        for (Item item:list){
            System.out.println(item);
        }
    }
}