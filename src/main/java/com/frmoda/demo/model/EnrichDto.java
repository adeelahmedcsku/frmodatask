package com.frmoda.demo.model;

import java.util.Collection;
import java.util.List;

public class EnrichDto {

    private String sku;
   private List<Stock> stocks;
    public EnrichDto()
    {

    }
   public EnrichDto(EnrichDto enrichDto)
   {
       this.setSku(enrichDto.getSku());
       this.setStocks(enrichDto.getStocks());
   }
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
