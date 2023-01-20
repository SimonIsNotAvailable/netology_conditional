package com.example.netology_conditional.service;

public class DevProfile implements SystemProfile{

    @Override
    public String getProfile() {
        return "Current profile is Dev";
    }
}
