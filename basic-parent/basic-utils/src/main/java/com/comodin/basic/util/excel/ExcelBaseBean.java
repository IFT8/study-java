package com.comodin.basic.util.excel;


import java.io.Serializable;

public class ExcelBaseBean implements Serializable {
    //private String excelAddress;
    private Integer excelAddressColumn;
    //private Integer excelAddressRow;


    public Integer getExcelAddressColumn() {
        return excelAddressColumn;
    }

    public ExcelBaseBean setExcelAddressColumn(Integer excelAddressColumn) {
        this.excelAddressColumn = excelAddressColumn;
        return this;
    }
}
