package com.frmoda.demo.service;

import com.frmoda.demo.helper.excelHelper;
import com.frmoda.demo.model.EnrichDto;
import com.frmoda.demo.model.ResponseDto;
import com.frmoda.demo.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class taskService {

    @Autowired
    ExternalService externalService;




    public List<EnrichDto> joinTwoDataSet()
    {
       ResponseDto responseDto =  externalService.getDataRemoteService();
        excelHelper excelHelper =new excelHelper();
        List<Stock> stocks =excelHelper.excelToStock();
        List<EnrichDto> enrichDtoList = new ArrayList<>();
        EnrichDto enrichDto=new EnrichDto();
        List<Stock> lststock1 = new ArrayList<>();
        responseDto.getSkus().forEach(sku ->{

            stocks.forEach(stock -> {
                if(sku.equals(stock.getProductNum())){
                    lststock1.add(stock);

                }
            });

            enrichDto.setSku(sku);
            enrichDto.setStocks(new ArrayList<>(lststock1));
            lststock1.clear();
           enrichDtoList.add(new EnrichDto(enrichDto));

        });
        return enrichDtoList;
    }

    public List<EnrichDto> getMostSelledSku()
    {
        List<EnrichDto> enrichDtoList = joinTwoDataSet();
        List<EnrichDto> mostSelledEnrichDtoList = new ArrayList<>();
        enrichDtoList.forEach(enrichDto -> {
            double sum =  enrichDto.getStocks().stream().collect(Collectors.summingDouble(o -> o.getStock()));
            if(sum==0.0) { mostSelledEnrichDtoList.add(enrichDto); }
        });
        return mostSelledEnrichDtoList;
    }
    public List<Stock> getSkusWithoutColor()
    {
        List<EnrichDto> enrichDtoList = joinTwoDataSet();
        List<Stock> listStock = new ArrayList<>();
        enrichDtoList.forEach(enrichDto -> {
           //listStock.addAll(enrichDto.getStocks());
            enrichDto.getStocks().forEach(stock -> {
                stock.setColor("");
                listStock.add(stock);
            });
        });

        return listStock;
    }

}
