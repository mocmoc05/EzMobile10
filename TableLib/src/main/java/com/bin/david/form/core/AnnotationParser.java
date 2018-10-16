package com.bin.david.form.core;


import com.bin.david.form.annotation.*;
import com.bin.david.form.data.Column;
import com.bin.david.form.data.table.PageTableData;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2017/11/4.
 * 注解解析
 */

public class AnnotationParser<T>  {


    public PageTableData<T> parse(List<T> dataList){
        if(dataList!= null && dataList.size() >0) {
            T firstData = dataList.get(0);
            if(firstData != null) {
                Class clazz = firstData.getClass();
                Annotation tableAnnotation = clazz.getAnnotation(com.bin.david.form.annotation.SmartTable.class);
                if(tableAnnotation != null){
                    com.bin.david.form.annotation.SmartTable table = (com.bin.david.form.annotation.SmartTable) tableAnnotation;
                    List<Column> columns = new ArrayList<>();
                    PageTableData<T> tableData = new PageTableData<>(table.name(),dataList,columns);
                    tableData.setCurrentPage(table.currentPage());
                    tableData.setPageSize(table.pageSize());
                    tableData.setShowCount(table.count());
                    FieldGenericHandler genericHandler = new FieldGenericHandler();
                    Map<String,Column> parentMap = new HashMap<>();
                    getColumnAnnotation(clazz, null,columns, genericHandler, parentMap);
                    Collections.sort(columns);
                    return tableData;
                }

            }
        }
        return null;
    }

    private void getColumnAnnotation(Class clazz, String parentFieldName, List<Column> columns, FieldGenericHandler genericHandler, Map<String, Column> parentMap) {
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            Class<?> fieldClass = field.getType();
            Annotation fieldAnnotation = field.getAnnotation(SmartColumn.class);
           if(fieldAnnotation != null){
               SmartColumn smartColumn = (SmartColumn) fieldAnnotation;
               ColumnType type = smartColumn.type();
               if(type == ColumnType.Own) {
                   String name = smartColumn.name();
                   int id = smartColumn.id();
                   String parent = smartColumn.parent();
                   boolean isAutoCount = smartColumn.autoCount();
                   if (name.equals("")) {
                       name = field.getName();
                   }
                   String fieldName =parentFieldName != null? (parentFieldName+field.getName()) :field.getName();
                   Column<?> column = genericHandler.getGenericColumn(fieldClass, name, fieldName);
                   column.setId(id);
                   column.setTextAlign(smartColumn.align());
                   column.setAutoMerge(smartColumn.autoMerge());
                   if(smartColumn.maxMergeCount() !=-1) {
                       column.setMaxMergeCount(smartColumn.maxMergeCount());
                   }
                   column.setAutoCount(isAutoCount);
                   column.setFixed(smartColumn.fixed());
                   if (!parent.equals("")) {
                       Column parentColumn = parentMap.get(parent);
                       if (parentColumn == null) {
                           List<Column> childColumns = new ArrayList<>();
                           childColumns.add(column);
                           parentColumn = new Column(parent, childColumns);
                           parentColumn.setId(id);
                           columns.add(parentColumn);
                           parentMap.put(parent, parentColumn);
                       }
                       parentColumn.addChildren(column);
                       if (id < parentColumn.getId()) {
                           parentColumn.setId(id);
                       }
                   }else{
                       columns.add(column);
                   }
               }else if(type == ColumnType.Child){
                   String fieldName = (parentFieldName != null ?parentFieldName:"")
                           +field.getName()+".";
                   getColumnAnnotation(fieldClass,fieldName,columns,genericHandler,parentMap);
               }
           }

        }
    }
}
