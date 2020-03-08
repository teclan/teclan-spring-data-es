package com.teclan.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.teclan.model.Item;

@Repository
public interface  ItemRepository extends ElasticsearchCrudRepository<Item,Long>{

}
