package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class excelcode {
	public String[][] testdata(String filename, String SheetName) throws IOException {
		String[][] data = null;
		try {
			FileInputStream fl = new FileInputStream(filename);
			XSSFWorkbook wb = new XSSFWorkbook(fl);
			XSSFSheet sht = wb.getSheet(SheetName);
			XSSFRow row = sht.getRow(0);
			DataFormatter dat = new DataFormatter();
			int rowNum = sht.getPhysicalNumberOfRows();
			//System.out.println("Rows = "+rowNum);
			int colNum = row.getLastCellNum();
			//System.out.println("columns = " + colNum);
			data=new String[rowNum-1][colNum];
			XSSFCell cl;
			for (int i = 0; i < rowNum; i++) {
				for (int j = 0; j < colNum; j++) {

					row = sht.getRow(i + 1);
					cl = row.getCell(j);
					data[i][j] = dat.formatCellValue(cl);
					//System.out.println(data[i][j]);
				}
			}
		} catch (Exception e) {
			// System.out.println("Error is "+e);
		}
		return data;
	}
	public static void main(String[] args) throws IOException {
		excelcode re = new excelcode();
		String[][] ans = re.testdata(
				"D:/Hitendra/codesAutomation/usecase1/src/test/resources/datasheet.xlsx",
				"billing");
	}
}
