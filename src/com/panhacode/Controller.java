package com.panhacode;

import com.panhacode.model.Book;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    Validation validation = new Validation();
    Query query = new Query();
    int pageSize = 2 ;

    public void setPageSize() {
        int newSize = validation.getValidate("Enter the number of rows per page: ", "\\d+", 1, 100, scanner);
        if (newSize > 0) {
            pageSize = newSize;
            System.out.println("Page size set to " + newSize + " rows.");
        } else {
            System.out.println("Invalid page size. Please enter a positive number.");
        }
    }


    public void printAllBook(){
        System.out.println("===============| Display all product |==============");

        int page = 1;
        while (true){
            CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
            CellStyle cellStyle1 = new CellStyle(CellStyle.HorizontalAlign.left);
            Table table = new Table(5, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.ALL);
            // Title Table / header table
            Book[] books = query.getAllBooks();
            System.out.println("====================| Current Page: |" +page);
            table.addCell("ID", cellStyle);
            table.addCell("TITLE", cellStyle);
            table.addCell("AUTHOR NAME", cellStyle);
            table.addCell("PUBLISHED-YEAR", cellStyle);
            table.addCell("STATUS", cellStyle);

            int startRow = (page - 1) * pageSize;
            int endRow = Math.min(startRow + pageSize, books.length);

            for (int i = startRow; i < endRow; i++){
                table.addCell(Integer.toString(books[i].getId()), cellStyle1);
                table.addCell(books[i].getTitle(), cellStyle1);
                table.addCell(books[i].getAuthor().getName(), cellStyle1);
                table.addCell(books[i].getPublishedYear() + "", cellStyle1);
                table.addCell(books[i].getStatus() ? "Available" : "Unavailable" , cellStyle1);
            }

            System.out.println(table.render());
            System.out.println("<-First(1)------------ Previous(2)---------(3)Next----------(4)Last---");
            System.out.println("<------------------------------GoTo(5)-------------------------------->");
            int opt = validation.getValidate("-> Press any key(Integer) to exit : ", "\\d+", 1, 9, scanner);
            switch (opt){
                case 1:
                    page = 1;
                    break;
                case 2:
                    if (page > 1) {
                        page--;
                    }
                    break;

                case 3:
                    int nextPage = page + 1;
                    int maxPage = (books.length + pageSize - 1) / pageSize; // Calculate the maximum page
                    if (nextPage <= maxPage) {
                        page = nextPage;
                    } else {
                        System.out.println("No more pages available.");
                    }
                    break;
                case 4:
                    // Set the page to the last page
                    page = (books.length + pageSize - 1) / pageSize;
                    break;
                case 5:

                    int pageNumber = validation.getValidate("Enter the page number: ", "\\d+", 1, 100, scanner);
                    if (pageNumber >= 1) {
                        page = pageNumber;
                    } else {
                        System.out.println("Invalid page number. Please enter a positive number.");
                    }

                    break;
                default:
                    System.out.println("Back to the main menu...");
            }
            if (opt > 5 || opt < 1){
                break;
            }
        }
    }

    public void displayBookWithCustomPageSize() {

        setPageSize(); // Call the method to set the page size
        printAllBook(); // Display stock data using the set page size
    }

    public void  writeBook(){
        System.out.println("==================| Write product to stock |=======================");
        query.writeBook();
    }
}
