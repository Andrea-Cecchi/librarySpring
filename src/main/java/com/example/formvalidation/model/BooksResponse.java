package com.example.formvalidation.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BooksResponse {

    private ArrayList<GoogleBook.Root> items;

    public ArrayList<GoogleBook.Root> getItems() {
        return items;
    }

    public void setItems(ArrayList<GoogleBook.Root> items) {
        this.items = items;
    }
}

