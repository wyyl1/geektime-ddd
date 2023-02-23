package com.test.common.factory.container;

import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;

@AllArgsConstructor
public class MapperContainer<MapperType> {

    private final MapperType mapper;

    private final SqlSession session;

    public MapperType mapper() {
        return mapper;
    }

    public void commit() {
        session.commit();
    }
}
