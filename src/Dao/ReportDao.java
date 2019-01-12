/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static java.awt.Frame.NORMAL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ReportDao {
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    public void PdfDaocreate() {
        String a = "TEST 78";
        

        DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        InventoryDetailsDao Inventory = new InventoryDetailsDao();
        List Details = Inventory.ViewInventoryDetails();
        try {

            OutputStream file = new FileOutputStream(new File("D:\\InventoryReport" + timeStamp + ".pdf"));
            Document document = new Document(PageSize.A4.rotate());
           
            PdfWriter.getInstance(document, file);
            
            document.open();
            Paragraph p = new Paragraph("Inventory Management System");
            Paragraph p1 = new Paragraph("Inventory Details Report");
            Paragraph p2 =new Paragraph(""+new Date().toString());
            p.setAlignment(Element.ALIGN_CENTER);
            p1.setAlignment(Element.ALIGN_CENTER);
             p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(p1);
            document.add(p2);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(8);
            table.addCell("Item Name");
            table.addCell("Item Id");
            table.addCell("Supplier Name");
            table.addCell("Category Id");
            table.addCell("Category Name");
            table.addCell("Unit Price");
            table.addCell("Quantity");
            table.addCell("State");

            for (int i = 0; i < Details.size(); i++) {
                List<String> inventoryDetails = new ArrayList<String>();
                inventoryDetails = (List<String>) Details.get(i);
                for (int j = 0; j < inventoryDetails.size(); j++) {
                    table.addCell(inventoryDetails.get(j));
                }
            }

            document.add(table);
            document.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void SupplierDetailPdf(){
        DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        SupplierDetailsDao supplier = new SupplierDetailsDao();
        List Details = supplier.ViewSupplierDetails();
        try {

            OutputStream file = new FileOutputStream(new File("D:\\SuppliDetilsReport" + timeStamp + ".pdf"));
            Document document = new Document(PageSize.A4);
           
            PdfWriter.getInstance(document, file);
            
            document.open();
            Paragraph p = new Paragraph("Inventory Management System");
            Paragraph p1 = new Paragraph("Supply Details Report");
            Paragraph p2 =new Paragraph(""+new Date().toString());
            p.setAlignment(Element.ALIGN_CENTER);
            p1.setAlignment(Element.ALIGN_CENTER);
             p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(p1);
            document.add(p2);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(5);
            table.addCell("Supplier Name");
            table.addCell("Supplier Id");
            table.addCell("E mail");
            table.addCell("Address");
            table.addCell("Tele Phone No");
            
            for (int i = 0; i < Details.size(); i++) {
                List<String> supplyDetails = new ArrayList<String>();
                supplyDetails = (List<String>) Details.get(i);
                for (int j = 0; j < supplyDetails.size(); j++) {
                    table.addCell(supplyDetails.get(j));
                }
            }

            document.add(table);
            document.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
