package com.example.cryptobank.controller;

import com.example.cryptobank.domain.Asset;
import com.example.cryptobank.service.AssetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AssetController {

    private AssetService assetService;

    private final Logger logger = LoggerFactory.getLogger(AssetController.class);

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
        logger.info("New AssetController");
    }

    @GetMapping("/assets")
    public ArrayList<Asset> showAssets() {
        ArrayList<Asset> allAssets = assetService.getAssets();
        logger.info("Show assets aangeroepen");
        return allAssets;
    }

    @GetMapping("/assets/{abbreviation}")
    public Asset showSpecificAsset(@PathVariable("abbreviation") String abbreviation) {
        Asset assetToShow = assetService.getByAbbreviation(abbreviation);
        logger.info("Show assets aangeroepen");
        return assetToShow;
    }

} // end of class AssetController
