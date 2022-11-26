package com.totemcrew.items.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("itemMappingConfiguration")
public class MappingConfiguration {
  @Bean
  public ItemMapper itemMapper() { return new ItemMapper(); }
}
