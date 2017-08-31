package com.comodin.basic.util.excel;

import org.apache.poi.ss.usermodel.Cell;

/**
 * ${DESCRIPTION}
 *
 * @author huangcanjia
 * @create 2017-08-15 19:07
 */
public class CellBean {

    public CellBean(String propertyName, String propertyValue, Cell cell) {
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
        this.cell = cell;
    }

    private String propertyName;
    private String propertyValue;
    private Cell cell;

    public String getPropertyName() {
        return (propertyName == null) ? null : propertyName.trim();
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = (propertyName == null) ? null : propertyName.trim();
    }

    public String getPropertyValue() {
        return (propertyValue == null) ? null : propertyValue.trim();
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = (propertyValue == null) ? null : propertyValue.trim();
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
