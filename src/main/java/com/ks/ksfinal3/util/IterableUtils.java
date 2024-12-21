package com.ks.ksfinal3.util;

import com.ks.ksfinal3.model.DatatableColumnData;
import com.ks.ksfinal3.model.DatatableColumnSearch;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterableUtils {

    public static int count(Iterable<?> iterable) {
        if(iterable == null) {
            throw new IllegalArgumentException("Iterator cannot be null");
        }
        final int[] count = {0};
        iterable.forEach(element -> count[0] = count[0] +1);
        return count[0];
    }

    public static Map<String, DatatableColumnData> datatableCollectData(Map<String, Object> allParams) {
        Map<String, DatatableColumnData> columns = new HashMap<>();

        // Iterate through all parameters to extract column data
        for (String key : allParams.keySet()) {
            if (key.startsWith("columns[")) {
                // Extract column index and property name
                String[] parts = key.split("\\[|\\]");
                if (parts.length >= 3) {
                    String columnIndex = parts[1];
                    String propertyName = parts[2];

                    // Initialize the inner ColumnData object if it doesn't exist
                    columns.putIfAbsent(columnIndex, new DatatableColumnData());
                    DatatableColumnData datatableColumnData = columns.get(columnIndex);

                    // Set the appropriate property based on the parameter name
                    switch (propertyName) {
                        case "data":
                            datatableColumnData.setData(allParams.get(key).toString());
                            break;
                        case "name":
                            datatableColumnData.setName(allParams.get(key).toString());
                            break;
                        case "searchable":
                            datatableColumnData.setSearchable(allParams.get(key).toString());
                            break;
                        case "orderable":
                            datatableColumnData.setOrderable(allParams.get(key).toString());
                            break;
                        case "search":
                            if (parts.length == 4 && "value".equals(parts[3])) {
                                DatatableColumnSearch datatableColumnSearch = new DatatableColumnSearch();
                                datatableColumnSearch.setValue(allParams.get(key).toString());
                                datatableColumnData.setSearch(datatableColumnSearch);
                            }
                            break;
                    }
                }
            }
        }
        return columns; // Return or process as needed
    }
}
