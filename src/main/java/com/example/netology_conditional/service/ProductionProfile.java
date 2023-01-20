package com.example.netology_conditional.service;

public class ProductionProfile implements SystemProfile{

    @Override
    public String getProfile() {
        return "Current profile is Prod";
    }
}
