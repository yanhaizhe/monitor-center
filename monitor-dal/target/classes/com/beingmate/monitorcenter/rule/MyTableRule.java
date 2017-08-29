package com.beingmate.monitorcenter.rule;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.MultipleKeysTableShardingAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/8/28 0028.
 */
public class MyTableRule implements MultipleKeysTableShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection<String> collection, Collection<ShardingValue<?>> collection1) {
        List<String> result = new ArrayList<>();
        for(ShardingValue shardingValue:collection1){
            String cu =  shardingValue.getColumnName();
            if("id".equals(cu)){
                if(shardingValue.getValue()!=null&&shardingValue.getValue() instanceof Integer){
                    String data = "config_"+ (Integer)shardingValue.getValue()%2;
                    result.add(data);
                }
            }
        }
        return result;
    }
}
