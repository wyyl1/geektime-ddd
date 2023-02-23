package com.test.common.factory;


import com.test.common.factory.container.MapperContainer;

public class MapperFactory {

    private static MapperFactoryImpl mapperFactory = MapperFactoryImpl.of();

    public final static <T> T of(Class<T> daoClass) {
        return mapperFactory.mapper(daoClass);
    }

    public final static <T> MapperContainer<T> ofContainer(Class<T> daoClass) {
        return mapperFactory.getMapperContainer(daoClass);
    }

    public final static MapperFactoryImpl mapperFactory() {
        return mapperFactory;
    }
}
