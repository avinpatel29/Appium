package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelDP {

	public String path;
	public FileInputStream fis=null;
	public FileOutputStream fos = null;
	public HSSFWorkbook workbook=null;
	public HSSFSheet sheet=null;
	public HSSFRow row=null;
	public HSSFCell cell= null;
	public static HSSFSheet ExcelWSheet;
	public static HSSFCell Cell;
	
	public ExcelDP(String path) {
		this.path=path;
		try {
			fis=new FileInputStream(path);
			workbook=new HSSFWorkbook(fis);
			sheet= workbook.getSheetAt(0);
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/** Method to find out whether sheet exists.
	 * 
	 * @param sheetName - Sheet name to be checked
	 * @return	true, if sheet exists.
	 * 			false, if sheet doesn't exists.
	 */
	public boolean isSheetExists(String sheetName) {
		int index=workbook.getSheetIndex(sheetName);
		if(index==-1) {
			index=workbook.getSheetIndex(sheetName.toUpperCase());
			if(index==-1)
				return false;
			else
				return true;
		}else
			return true;
	}
	
	
	/** Method to return row count in a sheet.
	 * 
	 * @param sheetName - Sheet name in the workbook
	 * 
	 * @return 	returns 0, if not sheetName Not found
	 * 			returns row count, if sheetName found
	 */
	public int getRowCount(String sheetName) {
		int index=workbook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else {
			sheet=workbook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;
		}
	}
	
	
	/** Method to count number of columns in a sheet.
	 * 
	 * @param sheetName - Sheet name in the workbook
	 * @return -1, if sheet doesn't exists.
	 * 			column count, if sheet exists
	 */
	public int getColumnCount(String sheetName) {
		if(!isSheetExists(sheetName))
			return -1;
		
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(0);
		
		if(row==null)
			return -1;
		
		return row.getLastCellNum();
	}

	
	/** Method to return the data from a cell  
	 * 
	 * @param sheetName - Sheet name
	 * @param colName	- Column name
	 * @param rowNum	- Row number
	 * @return	data from the cell 
	 */
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if(rowNum<=0)
				return "";
			int index=workbook.getSheetIndex(sheetName);
			int col_num=-1;
			
			if(index==-1)
				return "";
			
			sheet= workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++) {
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_num=i;
			}
			if(col_num==-1)
				return "";
			
			sheet= workbook.getSheetAt(index);
			row=sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			
			cell=row.getCell(col_num);
			if(cell==null)
				return "";
			cell.setCellType(cell.CELL_TYPE_STRING);
			if(cell.getCellType()==cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC || cell.getCellType()==cell.CELL_TYPE_FORMULA) 
			{
				String celltext=String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					double d=cell.getNumericCellValue();
					Calendar cal=Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					celltext=(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					celltext=cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.MONTH)+1+"/"+celltext;
				}
				return celltext;
			}else if(cell.getCellType()==cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
			
		}catch(Exception e) {
			e.printStackTrace();
			return "row"+rowNum+" or column"+colName+"does not exist in excel";
		}
	}
	
	/** Method to 
	 * 
	 * @param sheetName
	 * @param colName
	 * @param rowValue
	 * @param column
	 * @return
	 */
	public String getColumnDataOfRow(String sheetName, String colName, String rowValue, String column) {
		int rowNum=getCellRowNum(sheetName,colName,rowValue);
		return getCellData(sheetName,column,rowNum);
	}
	
	
	/** Method to return row
	 * 
	 * @param sheetName
	 * @param colName
	 * @param cellValue
	 * @return
	 */
	public int getCellRowNum(String sheetName, String colName, String cellValue) {
		for (int i = 1; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;
	}
	
	public String getCellDataUsingColNum(String sheetName, int colNum, int rowNum) {
		try {
			if(rowNum <=0)
				return "";
			int index=workbook.getSheetIndex(sheetName);
			
			if(index==-1)
				return "";
			
			sheet=workbook.getSheetAt(index);
			row=sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell=row.getCell(colNum);
			if(cell==null)
				return "";
			
			if(cell.getCellType()==cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC || cell.getCellType()==cell.CELL_TYPE_FORMULA) {
				String celltext=String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					double d=cell.getNumericCellValue();
					Calendar cal=Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					celltext=(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					celltext=cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.MONTH)+1+"/"+celltext;
				}
				return celltext;
			}else if(cell.getCellType()==cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
				
			}catch(Exception e) {
				e.printStackTrace();
				return "row"+rowNum+" or column"+colNum+"does not exist in excel";
			}
	}
	
	public String[] getSelectedColumnValues(String sheetName,String colName, int colStartRow, int colEndRow) {
		String[] colValues=new String[(colEndRow-colStartRow)+1];
		int index=workbook.getSheetIndex(sheetName);
		sheet=workbook.getSheetAt(index);
		
		row=sheet.getRow(0);
		for(int i=colStartRow;i<=colEndRow;i++) {
			colValues[i-colStartRow]=getCellData(sheetName,colName,i);
		}
		return colValues;
	}
	
	public static String[][] getSelectedRows(String filename, String sheetName, int rowStart, int rowEnd){
		try {
				String[][] tabArray=null;
				String FilePath=System.getProperty("user.dir")+"/src/test/resources/"+filename+".xls";
				FileInputStream fs= new FileInputStream(FilePath);
				Workbook workbook= Workbook.getWorkbook(fs);
				Sheet sheet=workbook.getSheet(sheetName);
				
				int rows=sheet.getRows();
				int cols=sheet.getColumns();
				int rowStart1=rowStart-1;
				int rowEnd1=rowEnd-1;
				tabArray=new String[(rowEnd1-rowStart1)+1][(rowEnd1-rowStart1)];
				
				for(int i=rowStart1;i<=rowEnd1;i++) {
					for(int j=0;j<cols;j++) {
						tabArray[i-rowStart1][j]=sheet.getCell(j,i).getContents();
						}
				}
				
				for(int i=0;i<=tabArray.length;i++) {
					System.out.println("==================");
					for(int j=0;j<=tabArray.length;j++) {
						System.out.println(tabArray[i][j]);
					}
					System.out.println("==================");
				}
				workbook.close();
				return tabArray;
		}catch(Exception e) {
			System.out.println(e+Thread.currentThread().getStackTrace()[1].getClassName()+"dataprovider");
			return null;
		}
	}
	
	public static String[][] getTableArray(String filename, String sheetName) throws Exception
	{
		try 
		{
			String FilePath=System.getProperty("user.dir")+"//src/test/resources/"+filename+".xls";
			FileInputStream fs= new FileInputStream(FilePath);
			Workbook workbook=Workbook.getWorkbook(fs);
			Sheet sheet=workbook.getSheet(sheetName);
			int rows=sheet.getRows();
			int cols=sheet.getColumns();
			String[][] tabArray=new String[rows-1][cols];
			for(int i=1;i<rows;i++)
			{
				for(int j=0;j<cols;j++) {
					tabArray[i-1][j]=sheet.getCell(j,i).getContents();
				}
			}
			workbook.close();
			final Map<String, String> map= new HashMap<String,String>(tabArray.length);
			for(String[] mapping:tabArray) {
				map.put(mapping[0], mapping[0]);
				map.put(mapping[1], mapping[1]);
				map.put(mapping[2], mapping[2]);
			}
			return (tabArray);
		}catch(Exception e) {
			System.out.println(e+Thread.currentThread().getStackTrace()[1].getClassName()+"dataprovider");
			return null;
		}
	}
	
	public static String[][] getExcelData(String fileName, String sheetName)
	{
		String[][] arrayExcelData=null;
		try {
			String FilePath=System.getProperty("user.dir")+"/src/test/resources/"+fileName+".xls";
			FileInputStream fs= new FileInputStream(FilePath);
			Workbook wb=Workbook.getWorkbook(fs);
			Sheet sh=wb.getSheet(sheetName);
			
			int totalNoOfCols=sh.getColumns();
			int totalNoOfRows=sh.getRows();
					
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			for(int i=1;i<totalNoOfRows;i++) {
				for(int j=0;j<totalNoOfCols;j++) {
					arrayExcelData[i-1][j]=sh.getCell(j,i).getContents();
				}
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

	public Object[][] getData(String sheetName){
		int rows=getRowCount(sheetName)-1;
		if(rows<=0) {
			Object[][] testData= new Object[1][0];
			return testData;
		}
		rows=getRowCount(sheetName);
		int cols=getColumnCount(sheetName);
		Object data[][] = new Object[rows-1][cols];
		
		for(int rowNum=2;rowNum<=rows;rowNum++) {
			for(int colNum=0;colNum<cols;colNum++) {
				data[rowNum-2][colNum]=getCellDataUsingColNum(sheetName,colNum,rowNum);
			}
		}
		return data;
	}
	
	
}
