package ExcelDriven;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class DataDriven {
	private static final String NumberToTextconvertor = null;
	public static List<String> getData(String testCaseName) throws IOException {
		// First we need to get the file access using FileInput Stream
		FileInputStream fs = new FileInputStream("D:\\Selenium\\DataDriven From Excel\\test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		// get the count of sheets
		int sheetCount = workbook.getNumberOfSheets();
		List<String> li = new ArrayList();
		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Access to specific row from all rows
				Iterator<Row> row = sheet.iterator();
				// Sheet is collection of rows
				Row firstRow = row.next();
				// Get access to all cells of row
				Iterator<Cell> cell = firstRow.cellIterator(); // Row is collection of cells
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {
					Cell value = cell.next();
					System.out.println(value.getStringCellValue());
					if (value.getStringCellValue().equalsIgnoreCase(testCaseName)){
						column = k;

						// Desired output
					}
					k++;
				}
				System.out.println(column);
				int j = 0;
				int column2 = 0;
				while (row.hasNext()) {
					Row r = row.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)){
						Iterator<Cell> cell2 = r.cellIterator();
						while (cell2.hasNext()) {
							Cell value2 = cell2.next();
							if(value2.getCellType()==CellType.STRING) {
								li.add(value2.getStringCellValue());									
							}
							else {	
								
								li.add(NumberToTextConverter.toText(value2.getNumericCellValue()));// to covert the numeric value
								
							}

							
//							System.out.println(li);
//							if (value2.getStringCellValue().equals("khjh")) {
//								
//								column2 = j;
//
//							}
//							j++;

						}

					}

				}
//				System.out.println("Second column value id" + " " + " " +  column2);
//				System.out.println("List is" +  "  " +  li);

			}

		}
		return li;

	}

}
