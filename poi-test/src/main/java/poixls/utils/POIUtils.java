package poixls.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Iterator;

import org.apache.poi.sl.draw.geom.Path;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class POIUtils 
{

    public static void main(String[] args) {
        java.nio.file.Path path = Paths.get("in\\inputHana.xls");

        try 
        {
        	  XSSFWorkbook workbook = new XSSFWorkbook();
              XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
              Object[][] datatypes = {
                      {"workflow", "dest table", "source table", "formatted table"},
                      {"int", "Primitive", 2},
                      {"float", "Primitive", 4},
                      {"double", "Primitive", 8},
                      {"char", "Primitive", 1},
                      {"String", "Non-Primitive", "No fixed size"}
              };

              int rowNum = 0;
              System.out.println("Creating excel");

              for (Object[] datatype : datatypes) {
                  Row row = sheet.createRow(rowNum++);
                  int colNum = 0;
                  for (Object field : datatype) {
                      Cell cell = row.createCell(colNum++);
                      if (field instanceof String) {
                          cell.setCellValue((String) field);
                      } else if (field instanceof Integer) {
                          cell.setCellValue((Integer) field);
                      }
                  }
              }

              File file = (!Files.exists(path)) ? Files.createFile(path).toFile() : path.toFile();
              FileOutputStream outputStream = new FileOutputStream(file);
              try {

                  workbook.write(outputStream);
                  workbook.close();
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }
            
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }
  
            
       try 
       {
    	   
    	   FileInputStream excelFile = new FileInputStream(path.toFile());
	        
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }

                }
                System.out.println();

            }
            
            excelFile.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
