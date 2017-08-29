package com.beingmate.monitorcenter.rule;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.MultipleKeysDatabaseShardingAlgorithm;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/28 0028.
 */
public class MyDatabaseRule implements MultipleKeysDatabaseShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection<String> collection, Collection<ShardingValue<?>> collection1) {
        List<String> result = new ArrayList<>();
        for(ShardingValue shardingValue:collection1){
          String cu =  shardingValue.getColumnName();
          if("creation_date".equals(cu)){
              if(shardingValue.getValue()!=null&&shardingValue.getValue() instanceof Date){
                  String data = "";
                  try {
                      String dd = DateUtil.date2Unix(DateUtil.formatDateTime((Date)shardingValue.getValue()),DateUtil.DATETIME_PATTERN);
                      if(Integer.valueOf(dd).intValue()<1503934364){
                           data = "dbtbl_0";
                      }else {
                           data = "dbtbl_1";
                      }
                  } catch (ParseException e) {
                      e.printStackTrace();
                  }
                  result.add(data);
              }
          }
//            if("id".equals(cu)){
//                if(shardingValue.getValue()!=null&&shardingValue.getValue() instanceof Integer){
//                    String data = "dbtbl_"+ (Integer)shardingValue.getValue()%2;
//                    result.add(data);
//                }
//            }

        }
        return result;
    }
}
