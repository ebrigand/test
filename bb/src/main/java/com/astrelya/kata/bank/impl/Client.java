package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IClient;
import com.astrelya.kata.bank.Product;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Client implements IClient {

    private String email;

    private CompteAVue compteAVue;
    private LDD ldd;
    private Map<String, Product> products = new HashMap<>();
    private Pret pret;

    public Client(String email){
        String regexPattern = "^(.+)@(\\S+)$";
        boolean validEmail = Pattern.compile(regexPattern).matcher(email).matches();
        if(!validEmail){
            throw new IllegalArgumentException(email + " is not a valid email");
        }
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Collection<Object> getProductList() {
        return List.of();
    }

    @Override
    public BigDecimal getMonthlyBalance() {
        BigDecimal result = products.values().stream().map(Product::getMonthlyValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return result;
    }

    @Override
    public void addProduct(String productType, Double amount) {
        if("LivretA".equals(productType)){
            if(products.containsKey("LivretA")){
                throw new IllegalArgumentException(email + " cannot have two LivretA");
            }
            products.put("LivretA", new LivretA(amount));
        } else if("LDD".equals(productType)){
            if(products.containsKey("LDD")){
                throw new IllegalArgumentException(email + " cannot have two LDD");
            }
            products.put("LDD", new LDD(amount));
        } else if("CompteAVue".equals(productType)){
            if(products.containsKey("CompteAVue")){
                throw new IllegalArgumentException(email + " cannot have two CompteAVue");
            }
            products.put("CompteAVue", new CompteAVue(amount));
        } else if("Pret".equals(productType)){
            if(products.containsKey("Pret")){
                throw new IllegalArgumentException(email + " cannot have two CompteAVue");
            }
            products.put("Pret", new Pret(amount));
        }
    }
}
