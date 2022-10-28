package com.totemcrew.courseservice.items.mapping;

import com.totemcrew.courseservice.items.domain.model.entity.Item;
import com.totemcrew.courseservice.items.resource.CreateItemResource;
import com.totemcrew.courseservice.items.resource.ItemResource;
import com.totemcrew.courseservice.items.resource.UpdateItemResource;
import com.totemcrew.courseservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ItemMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ItemResource toResource(Item model) {
        return mapper.map(model, ItemResource.class);
    }

    public Page<ItemResource> modelListToPage(List<Item> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ItemResource.class), pageable, modelList.size());
    }

    public List<ItemResource> modelListToResource(List<Item> modelList) {
        return mapper.mapList(modelList, ItemResource.class);
    }

    public Item toModel(CreateItemResource resource) {
        return mapper.map(resource, Item.class);
    }

    public Item toModel(UpdateItemResource resource) {
        return mapper.map(resource, Item.class);
    }
}
