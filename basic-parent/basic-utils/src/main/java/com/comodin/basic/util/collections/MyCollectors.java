package com.comodin.basic.util.collections;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;

public final class MyCollectors {

    public static <T, K, V> Collector<T, ?, Map<K, V>> toMap(Function<T, K> f1, Function<T, V> f2) {
        return new ForceToMapCollector<T, K, V>(f1, f2);
    }


    public static <E> List<Collection<E>> getBatchCollectionDataList(Collection<E> collectionData, Integer eachBatchNumber) {
        List<Collection<E>> result = new ArrayList<>();

        eachBatchNumber = Objects.isNull(eachBatchNumber) ? 100 : eachBatchNumber;  //批量每次最多条数，默认：100
        int sourListSize = collectionData.size();
        int subCount = (sourListSize % eachBatchNumber == 0) ? sourListSize / eachBatchNumber : sourListSize / eachBatchNumber + 1;
        int startIndex = 0;
        int stopIndex = 0;
        List<E> collectionDataList = new ArrayList<>(collectionData);
        for (int i = 0; i < subCount; i++) {
            stopIndex = ((i == subCount - 1) && (sourListSize % eachBatchNumber != 0)) ? stopIndex + sourListSize % eachBatchNumber : stopIndex + eachBatchNumber;
            List<E> es = collectionDataList.subList(startIndex, stopIndex);
            result.add(es);
            startIndex = stopIndex;
        }
        return result;
    }
}