package com.bin.david.form.data.table;


import com.bin.david.form.data.Cell;
import com.bin.david.form.data.CellRange;
import com.bin.david.form.data.Column;
import com.bin.david.form.data.ColumnInfo;
import com.bin.david.form.data.TableInfo;
import com.bin.david.form.data.format.sequence.ISequenceFormat;
import com.bin.david.form.data.format.sequence.LetterSequenceFormat;
import com.bin.david.form.data.format.sequence.NumberSequenceFormat;
import com.bin.david.form.data.format.title.ITitleDrawFormat;
import com.bin.david.form.data.format.title.TitleDrawFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huang on 2017/10/30.
 */

public class TableData<T> {

    private String tableName;
    private List<Column> columns;
    private List<T> t;
    private List<Column> childColumns;
    private TableInfo tableInfo = new TableInfo();
    private List<ColumnInfo> columnInfos;
    private List<ColumnInfo> childColumnInfos;
    private Column sortColumn;
    private boolean showCount; //显示统计
    private ITitleDrawFormat titleDrawFormat;
    private ISequenceFormat XSequenceFormat;
    private ISequenceFormat YSequenceFormat;
    private int lineSize;
    private List<CellRange> cellRangeAddresses;
    //用户设置的 不能清除
    private List<CellRange> userSetRangeAddress;
    /**
     *
     * @param tableName 表名
     * @param t 数据
     * @param columns 列列表
     */
    public TableData(String tableName,List<T> t,List<Column> columns) {
        this(tableName,t,columns,null);

    }

    /**
     *
     * @param tableName 表名
     * @param t 数据
     * @param columns 列列表
     */
    public TableData(String tableName,List<T> t, Column... columns) {
        this(tableName,t,Arrays.asList(columns));
    }
    /**
     *
     * @param tableName 表名
     * @param t 数据
     * @param columns 列列表
     * @param titleDrawFormat 列标题绘制格式化
     */
    public TableData(String tableName,List<T> t,List<Column> columns,ITitleDrawFormat titleDrawFormat) {
        this.tableName = tableName;
        this.columns = columns;
        this.t = t;
        lineSize = t.size();
        tableInfo.setLineSize(lineSize);
        childColumns = new ArrayList<>();
        columnInfos = new ArrayList<>();
        childColumnInfos = new ArrayList<>();
        cellRangeAddresses = new ArrayList<>();
        this.titleDrawFormat = titleDrawFormat == null?new TitleDrawFormat() :titleDrawFormat;
    }


    /**
     * 获取表名
     * @return 表名
     */
    public String getTableName() {
        return tableName;
    }
    /**
     * 设置表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 获取所有列
     * @return 所有列
     */
    public List<Column> getColumns() {
        return columns;
    }
    /**
     * 设置新列列表
     */
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
    /**
     * 获取解析数据
     * @return  解析数据
     */
    public List<T> getT() {
        return t;
    }
    /**
     * 设置解析数据
     */
    public void setT(List<T> t) {
        this.t = t;
        lineSize = t.size();
        tableInfo.setLineSize(lineSize);
    }


    /**
     * 获取所有需要显示列数据的列
     * isParent true的列不包含
     * @return 所有需要显示列数据的列
     */
    public List<Column> getChildColumns() {
        return childColumns;
    }
    /**
     * 获取表格信息
     * @return 表格信息tableInfo
     */
    public TableInfo getTableInfo() {
        return tableInfo;
    }
    /**
     * 设置表格信息
     * 一般情况下不会使用到这个方法
     */
    public void setTableInfo(TableInfo tableInfo) {
        this.tableInfo = tableInfo;
    }
    /**
     * 获取列信息列表
     * @return 列信息列表
     */
    public List<ColumnInfo> getColumnInfos() {
        return columnInfos;
    }
    /**
     * 获取isParent false列(子列)信息列表
     *  @return 子列信息列表
     */
    public List<ColumnInfo> getChildColumnInfos() {
        return childColumnInfos;
    }
    /**
     * 设置子列信息列表
     */
    public void setChildColumnInfos(List<ColumnInfo> childColumnInfos) {
        this.childColumnInfos = childColumnInfos;
    }
    /**
     * 设置列信息列表
     */
    public void setColumnInfos(List<ColumnInfo> columnInfos) {
        this.columnInfos = columnInfos;
    }
    /**
     * 设置子列
     */
    public void setChildColumns(List<Column> childColumns) {
        this.childColumns = childColumns;
    }

    /**
     * 获取需要根据排序的列
     * @return 排序的列
     */
    public Column getSortColumn() {
        return sortColumn;
    }
    /**
     * 设置需要根据排序的列
     */
    public void setSortColumn(Column sortColumn) {
        this.sortColumn = sortColumn;
    }

    /**
     * 判断是否需要显示统计行
     * @return 是否需要显示统计行
     */
    public boolean isShowCount() {
        return showCount;
    }

    public void setLineSize(int lineSize) {
        this.lineSize = lineSize;
    }

    /**
     * 设置是否显示统计总数
     * @param showCount 显示统计总数
     */
    public void setShowCount(boolean showCount) {
        this.showCount = showCount;
    }
    /**
     * 获取列标题绘制格式化
     * @return  列标题绘制格式化
     */
    public ITitleDrawFormat getTitleDrawFormat() {
        return titleDrawFormat;
    }
    /**
     * 设置列标题绘制格式化
     * 通过这个方法可以对列名进行格式化
     */
    public void setTitleDrawFormat(ITitleDrawFormat titleDrawFormat) {
        this.titleDrawFormat = titleDrawFormat;
    }
    /**
     * 获取X序号行文字格式化
     * @return  X行文字格式化
     */
    public ISequenceFormat getXSequenceFormat() {
        if(XSequenceFormat == null){
            XSequenceFormat = new LetterSequenceFormat();
        }
        return XSequenceFormat;
    }
    /**
     * 设置X序号行文字格式化
     */
    public void setXSequenceFormat(ISequenceFormat XSequenceFormat) {
        this.XSequenceFormat = XSequenceFormat;
    }
    /**
     * 获取Y序号列文字格式化
     * @return  Y序号列文字格式化
     */
    public ISequenceFormat getYSequenceFormat() {
        if(YSequenceFormat == null){
            YSequenceFormat = new NumberSequenceFormat();
        }
        return YSequenceFormat;
    }
    /**
     * 设置Y序号列文字格式化
     */
    public void setYSequenceFormat(ISequenceFormat YSequenceFormat) {
        this.YSequenceFormat = YSequenceFormat;
    }

    /**
     * 获取包含ID的子列
     * @param id 列ID
     * @return 包含ID的子列
     */
    public Column getColumnByID(int id){
        List<Column> columns = getChildColumns();
        for(Column column :columns){
            if(column.getId() == id){
                return column;
            }
        }
        return null;
    }


    /**
     * 获取包含fieldName的子列
     * @fieldName id 列Name
     * @return 包含ID的子列
     */
    public Column getColumnByFieldName(String fieldName){
        List<Column> columns = getChildColumns();
        for(Column column :columns){
            if(column.getFieldName().equals( fieldName)){
                return column;
            }
        }
        return null;
    }

    /**
     * 获取行数
     * @return 行数
     */
    public int getLineSize() {
        return lineSize;
    }

    private void addCellRange(int firstRow,int lastRow,int firstCol,int lastCol){
        Cell[][] tableCells = tableInfo.getRangeCells();
        Cell realCell = null;
        for(int i = firstRow; i <= lastRow;i++){
            if(i < tableCells.length)
            for(int j = firstCol; j <= lastCol;j++){
               if(j < tableCells[i].length) {
                   if (i == firstRow && j == firstCol) {
                       int rowCount = Math.min(lastRow+1,tableCells.length) - firstRow;
                       int colCount = Math.min(lastCol+1,tableCells[i].length) - firstCol;
                       realCell = new Cell(colCount,rowCount);
                       tableCells[i][j] = realCell;
                       continue;
                   }
                   tableCells[i][j] = new Cell(realCell);
               }
            }
        }
    }

   /* *//**
     * 获取所有合并规则，包括自定义和自动合并规则
     * 请不要使用该方法来添加合并单元格
     * 而是通过设置setUserCellRange来添加
     * @return
     */
    public void addCellRange(CellRange range) {
        addCellRange(range.getFirstRow(),range.getLastRow(),
                range.getFirstCol(),range.getLastCol());
        cellRangeAddresses.add(range);
    }

    /**
     * 清除自动合并的规则
     */
    public void clearCellRangeAddresses(){
        cellRangeAddresses.clear();
        if(userSetRangeAddress !=null) {
            for(CellRange range:userSetRangeAddress) {
                addCellRange(range);
            }

        }
    }
    /**
     * 提供添加自定义合并规则
     * @return
     */
    public void setUserCellRange(List<CellRange> userCellRange) {
        this.userSetRangeAddress = userCellRange;
    }

    /**
     * 获取自定义合并规则
     * @return
     */
    public List<CellRange> getUserCellRange() {
        return userSetRangeAddress;
    }

    public void clear(){
        if(t !=null) {
            t.clear();
            t= null;
        }
        if(childColumns !=null){
            childColumns.clear();
            childColumns = null;
        }
        if(columns !=null){
            columns = null;
        }
        if(childColumnInfos !=null){
            childColumnInfos.clear();
            childColumnInfos = null;
        }
        if(cellRangeAddresses !=null){
            cellRangeAddresses.clear();
            cellRangeAddresses =null;
        }
        if(userSetRangeAddress !=null){
            userSetRangeAddress.clear();
            userSetRangeAddress =null;
        }
        if(tableInfo !=null){
            tableInfo.clear();
            tableInfo = null;
        }
        sortColumn = null;
        titleDrawFormat = null;
        XSequenceFormat=null;
        YSequenceFormat = null;

    }

    public List<CellRange> getCellRangeAddresses() {
        return cellRangeAddresses;
    }
}
