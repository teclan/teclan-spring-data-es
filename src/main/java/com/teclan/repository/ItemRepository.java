package com.teclan.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.teclan.model.Item;

public interface  ItemRepository extends ElasticsearchRepository<Item,Long>{

}
