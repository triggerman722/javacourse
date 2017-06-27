package com.bytepart.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ConfigService extends Observable {
    public String getConfig(String owner, String repo) {
        List<String> ownerList = new ArrayList<>();
        ownerList.add(owner);
        ownerList.add(repo);
        setChanged();
        notifyObservers(ownerList);

        return ownerList.get(2);
    }


}
