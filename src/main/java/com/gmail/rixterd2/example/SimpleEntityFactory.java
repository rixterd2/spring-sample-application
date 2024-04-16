package com.gmail.rixterd2.example;

import java.time.OffsetDateTime;

public class SimpleEntityFactory {

    public static SimpleEntity createSimpleEntity() {
        SimpleEntity simpleEntity = new SimpleEntity();
        simpleEntity.setCreatedAt(OffsetDateTime.now());
        return simpleEntity;
    }
}
