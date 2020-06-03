package com.example.sample.repository;

import com.example.sample.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    /*
    @Transactional
    @Modifying //Updateに必要
    @Query("update Items i set "             //"Items AS i set"でも"Item set"でもOK
            + " i.id = :id, "
            + " i.name = :name, "
            + " i.price = :price, "
            + " i.memo = :memo, "
            + " i.flag = :flag, "
            + " i.created = :created "
            + " where i.id = :id ")         //JPQLを記述
    public Integer updateById(              //戻り値は更新件数の数字、Integer
                                            @Param("id") Long id,
                                            @Param("name") String name,
                                            @Param("price") Integer price,
                                            @Param("memo") String memo,
                                            @Param("flag") Boolean flag,
                                            @Param("created") LocalDateTime created);
    */

}