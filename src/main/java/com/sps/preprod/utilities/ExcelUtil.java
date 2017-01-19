package com.sps.preprod.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static List readxml(File Filepath,String Value,int Sheetcount) throws Exception
    {
    	int numberOfCells=0;
    	List sheetData = new ArrayList();
    	FileInputStream fis = null;
    	int count=0;
    	try {
    		
			fis = new FileInputStream(Filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int lastcol = (int)sheet.getRow(0).getLastCellNum();
			XSSFRow rows=sheet.getRow(0);
			//Iterator<Row> rows = sheet.rowIterator();
		/*	while (rows.hasNext()) {
				HSSFRow row1 = (HSSFRow) rows.next();
				Iterator cells = row1.cellIterator();
				List data = new ArrayList();
				while (cells.hasNext()) {
				HSSFCell cell = (HSSFCell) cells.next();
				data.add(cell);
				
			}
		}*/
			
			/*if (rows.hasNext())
            {
                Row headerRow = (Row) rows.next();
                //get the number of cells in the header row
                numberOfCells = headerRow.getPhysicalNumberOfCells();
                
            }*/
			/*System.out.println(lastrow);*/
			for(int i=0;i<=lastcol-1;i++)
			{
				
				if(rows.getCell(i).toString().equals(Value))
				{
					count=i;
					
					break;
				}
				
				
				
			}
			for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				  rows = sheet.getRow(rowIndex);
				  if (rows != null) {
				    
				    
 				        XSSFCell cell = rows.getCell(count);// count gives here colomn number
				        if (cell != null) {
				        	sheetData.add(cell.getStringCellValue());
				        }
				    }
			
			}
    	}
    	
    	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally{
    		if (fis != null) {
    			fis.close();
    	}
    	
		//return Sheetcount;
    	
    }
		return sheetData;
}
}
