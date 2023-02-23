package com.test.common.factory;

import cn.org.atool.fluent.common.kits.KeyMap;
import cn.org.atool.fluent.mybatis.base.intf.IRelation;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.functions.IExecutor;
import cn.org.atool.fluent.mybatis.spring.IMapperFactory;
import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import com.test.common.factory.container.MapperContainer;
import com.wyyl1.hi.adapter.driving.persistence.orgmng.mapper.OrgMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import static cn.org.atool.fluent.mybatis.utility.RefKit.ENTITY_MAPPING;

@Slf4j
public class MapperFactoryImpl implements IMapperFactory {

    @Getter
    private final SqlSessionFactory sessionFactory;

    private final KeyMap<IEntityMapper> mappers = new KeyMap<>();

    @Getter
    private final List<IExecutor> initializers = new ArrayList<>();

    private static MapperFactoryImpl instance;

    public synchronized static MapperFactoryImpl of() {
        if (instance == null) {
            instance = new MapperFactoryImpl(dataSource()
                    , OrgMapper.class
            );
        }

        return instance;
    }

    private static DataSource dataSource() {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName("com.mysql.cj.jdbc.Driver");
        result.setUrl("jdbc:mysql://localhost:3306/geektime-ddd?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&allowMultiQueries=true");
        result.setUsername("root");
        result.setPassword("root");

//        result.setAutoCommitOnReturn(true);
        result.setDefaultAutoCommit(true);

        return result;
    }

    private MapperFactoryImpl(DataSource dataSource, Class<? extends IEntityMapper>... classes) {
        Configuration configuration = this.initConfiguration(dataSource, classes);
        this.sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        try (SqlSession session = sessionFactory.openSession()) {
            for (Class<? extends IEntityMapper> klass : classes) {
                IEntityMapper mapper = session.getMapper(klass);
                mappers.put(klass, mapper);
            }
        }

        log.info("mapper 初始化");

        if (ENTITY_MAPPING.values().size() > 0) {
            log.info("Spring 已经初始化了");
            return;
        }

        this.init();
        MapperFactory.setInitialized(true);
    }

    private Configuration initConfiguration(DataSource dataSource, Class<? extends IEntityMapper>[] classes) {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment env = new Environment("DEFAULT", transactionFactory, dataSource);
        Configuration configuration = new Configuration(env);
        for (Class<? extends IEntityMapper> mapper : classes) {
            configuration.addMapper(mapper);
        }
        return configuration;
    }

    @Override
    public Collection<IEntityMapper> getMappers() {
        return mappers.values();
    }

    public final <T> T mapper(Class<T> daoClass) {
        SqlSession sqlSession = sessionFactory.openSession();
        return sqlSession.getMapper(daoClass);
    }

    public final <T> MapperContainer<T> getMapperContainer(Class<T> daoClass){
        SqlSession sqlSession = sessionFactory.openSession();
        return new MapperContainer(sqlSession.getMapper(daoClass), sqlSession);
    }

    @Override
    public Collection<IRelation> getRelations() {
        return Collections.emptyList();
    }

    @Override
    public Collection<SqlSessionFactory> getSessionFactories() {
        return Collections.singletonList(sessionFactory);
    }


    public <M extends IEntityMapper> void execute(Class<M> klass, Consumer<M> consumer) {
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            M mapper = sqlSession.getMapper(klass);
            consumer.accept(mapper);
        }
    }
}
