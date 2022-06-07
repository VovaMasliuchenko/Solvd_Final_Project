package com.solvd.mybatis.mapper;

import com.solvd.Entity.Bonuses;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class BonusesMapperTest {
    public static SqlSessionFactory sqlSessionFactory;

    public void beforeTest(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder =
                new SqlSessionFactoryBuilder();
        try{
            sqlSessionFactory = sqlSessionFactoryBuilder.build(
                    Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setAfter() {
        sqlSessionFactory = null;
    }

    public void testGetAll(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BonusesMapper mapper = sqlSession.getMapper(BonusesMapper.class);
            List<Bonuses> bonuses = mapper.getAll();
            for (Bonuses bonus : bonuses) {
                System.out.println(bonus);
            }
        }
    }

    public void testGetById(int id){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BonusesMapper mapper = sqlSession.getMapper(BonusesMapper.class);
            Bonuses bonuses = mapper.getEntityById(id);
            System.out.println(bonuses);
        }
    }

    public void testInsertEntity(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BonusesMapper mapper = sqlSession.getMapper(BonusesMapper.class);
            int i = mapper.addEntity(new Bonuses(7,"summer"));
            if (i == 1) {
                System.out.println ("success");
            }
            sqlSession.commit();
        }
    }

    public void testUpdateEntity(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BonusesMapper mapper = sqlSession.getMapper(BonusesMapper.class);
            int i =  mapper.updateEntity(new Bonuses(7,"winter"));
            if (i == 1) {
                System.out.println ("success");
            }
            sqlSession.commit();
        }
    }

    public void testDeleteEntity(int id){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BonusesMapper mapper = sqlSession.getMapper(BonusesMapper.class);
            Bonuses bonuses = mapper.getEntityById(id);
            int i =  mapper.deleteEntity(bonuses);
            if (i == 1) {
                System.out.println ("success");
            }
            sqlSession.commit();
        }
    }

}
