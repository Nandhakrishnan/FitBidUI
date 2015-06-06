package com.flipbidui.actions;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipbidui.network.HTTPCallActions;
import com.flipbidui.references.ConfigReferences;
import com.flipbidui.structures.Product;
import com.flipbidui.utilities.MultipartUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Created by sankeerth.reddy on 06/06/15.
 */
public class ActionImpl {
    public ActionImpl(){};
    String url = ConfigReferences.serviceURL;
    HTTPCallActions httpCallActions = new HTTPCallActions();

    public ArrayList<Product> getAllProducts() throws IOException {
        String getAllProductsURL = url + "getAllProducts";
        String getResponse = httpCallActions.makeGetCall(getAllProductsURL).getRawResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(getResponse, new TypeReference<List<Product>>(){});
    }

    public Product getProduct(int productID) {
        Product product = new Product();
        String getPRoductURL = url + "product/" + productID;
        String getResponse = httpCallActions.makeGetCall(getPRoductURL).getRawResponse();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            product = objectMapper.readValue(getResponse, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product;
    }

    public void updateProduct(Product product){
        product = new Product();
        String postProductURL = url + "product/" + product.productId;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            httpCallActions.makePostCall(postProductURL, objectMapper.writeValueAsString(product));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Product getMaxBid(int productID) {
        Product product = new Product();
        String getPRoductURL = url + "getMaxBid/" + productID;
        String getResponse = httpCallActions.makeGetCall(getPRoductURL).getRawResponse();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            product = objectMapper.readValue(getResponse, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product;
    }

    public void insertProduct(Product product, File filePath) throws IOException {
        String charset = "UTF-8";
        String getPRoductURL = url + "upload";
        ObjectMapper objectMapper = new ObjectMapper();
        String parameters = objectMapper.writeValueAsString(product);

        MultipartUtility multipart = new MultipartUtility(getPRoductURL, charset);
        multipart.addFilePart("file", filePath);
        multipart.addFormField("details", parameters);
        multipart.finish();
        System.out.println("SERVER REPLIED:");
    }

}
