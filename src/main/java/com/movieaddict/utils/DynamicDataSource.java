package com.movieaddict.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * #Author :Sino
 * #Date   :2022/5/14 21:42
 * #Describe:
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDbType();
    }
}
