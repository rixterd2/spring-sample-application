package com.gmail.rixterd2.example;

import java.util.UUID;

public class SimpleEntityFactory {

    public static SimpleEntity createSimpleEntity() {
        SimpleEntity simpleEntity = new SimpleEntity();
        simpleEntity.setData(UUID.randomUUID().toString());
        return simpleEntity;
    }
}
