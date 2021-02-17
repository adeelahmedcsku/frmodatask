package com.frmoda.demo.api;


import com.frmoda.demo.model.EnrichDto;
import com.frmoda.demo.model.Stock;
import com.frmoda.demo.service.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class stockController {

    @Autowired
    taskService taskService;

    @GetMapping("/joinDataSet")
    public ResponseEntity<List<EnrichDto>> joinDataSet() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.joinTwoDataSet());

    }

    // It is considered that the products whose stock is zero are the products which have been sold completely.
    @GetMapping("/getMostSellSku")
    public ResponseEntity<List<EnrichDto>> getMostSellSku() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getMostSelledSku());

    }

    // It is considered that the products whose stock is zero are the products which have been sold completely.
    @GetMapping("/getStocksWithOutColor")
    public ResponseEntity<List<Stock>> getStocksWithOutColor() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getSkusWithoutColor());

    }
}
