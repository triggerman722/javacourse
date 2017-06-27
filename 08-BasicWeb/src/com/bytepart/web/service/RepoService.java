package com.bytepart.web.service;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class RepoService implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        List<String> ownerList = (List<String>)arg;
        ownerList.add("200");
        System.out.print("Something happened");
    }
}
