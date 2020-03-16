package com.pangan.model;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class PageMethod {
    private List<HashMap<String, Object>> steps;
}
