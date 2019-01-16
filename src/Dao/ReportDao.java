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
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import database.DBConnection;
import static java.awt.Frame.NORMAL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
    public List<List<String>> ListofsalesDetailsList = new ArrayList<List<String>>();
      public List<List<String>> ListofoutstandingsList = new ArrayList<List<String>>();
        public List<List<String>> ListofcollectionDetailsList = new ArrayList<List<String>>();

    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    public boolean CreateReport(int reportType, Date fromDate, Date toDate) {
        boolean res =false;
        if (reportType == 0) {
             res = InventoryReportGenerate();
        }

        if (reportType == 1) {
             res = ProfitPdfMonthly(fromDate, toDate);

        }
        if (reportType == 2) {
             res  =ProfitPdfYear(fromDate, toDate);
        }
        
        if(reportType==3){
           res = ProfitPdfGeneric(fromDate, toDate);
        }
        
         if(reportType==4){
           res = SalesReportGeneration(fromDate, toDate);
        }

           if(reportType==5){
           res = OutStandingReportGeneration(fromDate, toDate);
        }
            if(reportType==6){
           res = Collectionreport(fromDate, toDate);
        }
           

        return res;
    }

    public boolean InventoryReportGenerate() {
        String a = "TEST 78";

        DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        InventoryDetailsDao Inventory = new InventoryDetailsDao();
        List Details = Inventory.ViewInventoryDetails();
        try {

            OutputStream file = new FileOutputStream(new File("D:\\InventoryReport" + timeStamp + ".pdf"));
            Document document = new Document(PageSize.A4.rotate());

            PdfWriter.getInstance(document, file);
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            String reportDate = df.format(date);
Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            document.open();
            Paragraph p = new Paragraph("UNIQUE TRADING");
            Paragraph p1 = new Paragraph("No:36,1/1A,Rathnapura Road, Horana");
            Paragraph p3 = new Paragraph("Tele:0711198540");
            Paragraph p4 = new Paragraph("Inventory Report",boldFont);
            Paragraph p2 = new Paragraph("" + reportDate);
            p.setAlignment(Element.ALIGN_CENTER);
            p3.setAlignment(Element.ALIGN_CENTER);
            p4.setAlignment(Element.ALIGN_CENTER);
            p1.setAlignment(Element.ALIGN_CENTER);
            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(p1);
            document.add(p3);
            document.add(p4);
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
            Paragraph p7 = new Paragraph("Authorized Signature");
            Paragraph p8 = new Paragraph("Date");
            Paragraph p5 = new Paragraph("........................");
            Paragraph p6 = new Paragraph("........................");

            p7.setAlignment(Element.ALIGN_RIGHT);
            p8.setAlignment(Element.ALIGN_RIGHT);
            p5.setAlignment(Element.ALIGN_RIGHT);
            p6.setAlignment(Element.ALIGN_RIGHT);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(p5);
            document.add(p7);
            document.add(Chunk.NEWLINE);
            document.add(p6);
            document.add(p8);
            document.close();
            file.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean SupplierDetailPdf() {
        DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        SupplierDetailsDao supplier = new SupplierDetailsDao();
        List Details = supplier.ViewSupplierDetails();
        Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            String reportDate = df.format(date);
        try {

            OutputStream file = new FileOutputStream(new File("D:\\SuppliDetilsReport" + timeStamp + ".pdf"));
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, file);

            document.open();
            Paragraph p = new Paragraph("UNIQUE TRADING");
            Paragraph p1 = new Paragraph("No:36,1/1A,Rathnapura Road, Horana");
            Paragraph p3 = new Paragraph("Tele:0711198540");
            Paragraph p4 = new Paragraph("Inventory Report");
            Paragraph p2 = new Paragraph("" + reportDate);
            p.setAlignment(Element.ALIGN_CENTER);
            p3.setAlignment(Element.ALIGN_CENTER);
            p4.setAlignment(Element.ALIGN_CENTER);
            p1.setAlignment(Element.ALIGN_CENTER);
            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(p1);
            document.add(p3);
            document.add(p4);
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
             Paragraph p7 = new Paragraph("Authorized Signature");
            Paragraph p8 = new Paragraph("Date");
            Paragraph p5 = new Paragraph("........................");
            Paragraph p6 = new Paragraph("........................");

            p3.setAlignment(Element.ALIGN_RIGHT);
            p4.setAlignment(Element.ALIGN_RIGHT);
            p5.setAlignment(Element.ALIGN_RIGHT);
            p6.setAlignment(Element.ALIGN_RIGHT);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(p5);
            document.add(p7);
            document.add(Chunk.NEWLINE);
            document.add(p6);
            document.add(p8);
            document.close();

            document.close();
            file.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
return true;
    }

    public boolean ProfitPdfGeneric(Date fromDate, Date toDate) {
        DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SupplierDetailsDao supplier = new SupplierDetailsDao();

        String FromDate = outputFormatter.format(fromDate);
        String ToDate = outputFormatter.format(toDate);

        List Details = ProfitDetails(FromDate, ToDate);
Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            String reportDate = df.format(date);
        try {

            OutputStream file = new FileOutputStream(new File("D:\\ProfitGenericReport" + timeStamp + ".pdf"));
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, file);
Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            document.open();
             Paragraph p = new Paragraph("UNIQUE TRADING");
            Paragraph p1 = new Paragraph("No:36,1/1A,Rathnapura Road, Horana");
            Paragraph p3 = new Paragraph("Tele:0711198540");
            Paragraph p4 = new Paragraph("Inventory Report", boldFont);
            Paragraph p2 = new Paragraph("" + FromDate+"to"+ToDate);
            p.setAlignment(Element.ALIGN_CENTER);
            p3.setAlignment(Element.ALIGN_CENTER);
            p4.setAlignment(Element.ALIGN_CENTER);
            p1.setAlignment(Element.ALIGN_CENTER);
            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(p1);
            document.add(p3);
            document.add(p4);
            document.add(p2);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(5);
            table.addCell("Payment Received");
            table.addCell("Payment Paid");
            table.addCell("Payment Received Returned");
            table.addCell("Payment Paid Returned");
            table.addCell("Total Profit");

            for (int i = 0; i < Details.size(); i++) {
                if (Details.get(i) != null) {
                    table.addCell(Details.get(i).toString());
                } else {
                    table.addCell("0");
                }
            }
            Double PaymentReceived = Details.get(0) == null ? 0.00 : Double.parseDouble(Details.get(0).toString());
            Double PaymentPaid = Details.get(1) == null ? 0.00 : Double.parseDouble(Details.get(1).toString());
            Double PaymentReturned = Details.get(2) == null ? 0.00 : Double.parseDouble(Details.get(2).toString());
            Double PaidReturned = Details.get(3) == null ? 0.00 : Double.parseDouble(Details.get(3).toString());

//                 -Double.parseDouble(PaymentReturned.toString())+Double.parseDouble(PaidReturned.toString());
            Double profit = PaymentReceived - PaymentPaid - PaymentReturned + PaidReturned;
            table.addCell(profit.toString());
            document.add(table);
            Paragraph p7 = new Paragraph("Authorized Signature");
            Paragraph p8 = new Paragraph("Date");
            Paragraph p5 = new Paragraph("........................");
            Paragraph p6 = new Paragraph("........................");

            p7.setAlignment(Element.ALIGN_RIGHT);
            p8.setAlignment(Element.ALIGN_RIGHT);
            p5.setAlignment(Element.ALIGN_RIGHT);
            p6.setAlignment(Element.ALIGN_RIGHT);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(p5);
            document.add(p7);
            document.add(Chunk.NEWLINE);
            document.add(p6);
            document.add(p8);
            document.close();
            file.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ProfitPdfYear(Date fromDate, Date toDate) {
        DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        SupplierDetailsDao supplier = new SupplierDetailsDao();

        Calendar cal = Calendar.getInstance();
        cal.setTime(fromDate);
        String year = Integer.toString(cal.get(Calendar.YEAR));

        List Details = ProfitDetailsYear(year);

        try {

            OutputStream file = new FileOutputStream(new File("D:\\ProfitReportYear" + timeStamp + ".pdf"));
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, file);
Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            document.open();
           Paragraph p = new Paragraph("UNIQUE TRADING");
            Paragraph p1 = new Paragraph("No:36,1/1A,Rathnapura Road, Horana");
            Paragraph p3 = new Paragraph("Tele:0711198540");
            Paragraph p4 = new Paragraph("Yearly Profit Report",boldFont);
            Paragraph p2 = new Paragraph("" + year);
            p.setAlignment(Element.ALIGN_CENTER);
            p3.setAlignment(Element.ALIGN_CENTER);
            p4.setAlignment(Element.ALIGN_CENTER);
            p1.setAlignment(Element.ALIGN_CENTER);
            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(p1);
            document.add(p3);
            document.add(p4);
            document.add(p2);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(5);
            table.addCell("Payment Received");
            table.addCell("Payment Paid");
            table.addCell("Payment Received Returned");
            table.addCell("Payment Paid Returned");
            table.addCell("Total Profit");

            for (int i = 0; i < Details.size(); i++) {
                if (Details.get(i) != null) {
                    table.addCell(Details.get(i).toString());
                } else {
                    table.addCell("0");
                }
            }
            Double PaymentReceived = Details.get(0) == null ? 0.00 : Double.parseDouble(Details.get(0).toString());
            Double PaymentPaid = Details.get(1) == null ? 0.00 : Double.parseDouble(Details.get(1).toString());
            Double PaymentReturned = Details.get(2) == null ? 0.00 : Double.parseDouble(Details.get(2).toString());
            Double PaidReturned = Details.get(3) == null ? 0.00 : Double.parseDouble(Details.get(3).toString());

//                 -Double.parseDouble(PaymentReturned.toString())+Double.parseDouble(PaidReturned.toString());
            Double profit = PaymentReceived - PaymentPaid - PaymentReturned + PaidReturned;
            table.addCell(profit.toString());
            document.add(table);
            Paragraph p7 = new Paragraph("Authorized Signature");
            Paragraph p8 = new Paragraph("Date");
            Paragraph p5 = new Paragraph("........................");
            Paragraph p6 = new Paragraph("........................");

            p7.setAlignment(Element.ALIGN_RIGHT);
            p8.setAlignment(Element.ALIGN_RIGHT);
            p5.setAlignment(Element.ALIGN_RIGHT);
            p6.setAlignment(Element.ALIGN_RIGHT);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(p5);
            document.add(p7);
            document.add(Chunk.NEWLINE);
            document.add(p6);
            document.add(p8);
            document.close();
            file.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean ProfitPdfMonthly(Date fromDate, Date toDate) {
        DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
       String date = outputFormatter.format(fromDate);
       //Date date = new Date();


       Date fdate = null;
       String monthName =null;
        String month =null;
        try {
             fdate = outputFormatter.parse(date);
             LocalDate localDate = fdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
              month = Integer.toString(localDate.getMonthValue());
             DateFormat sdf = new SimpleDateFormat("MMMM");
              monthName = sdf.format(fdate);
        } catch (ParseException ex) {
            Logger.getLogger(ReportDao.class.getName()).log(Level.SEVERE, null, ex);
        }
//       
        List Details = ProfitDetailsMonth(month);

        try {

            OutputStream file = new FileOutputStream(new File("D:\\ProfitReportMonthly" + timeStamp + ".pdf"));
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, file);
Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            document.open();
           Paragraph p = new Paragraph("UNIQUE TRADING");
            Paragraph p1 = new Paragraph("No:36,1/1A,Rathnapura Road, Horana");
            Paragraph p3 = new Paragraph("Tele:0711198540");
            Paragraph p4 = new Paragraph("Monthly Profit Report",boldFont);
            Paragraph p2 = new Paragraph("" + monthName);
            p.setAlignment(Element.ALIGN_CENTER);
            p3.setAlignment(Element.ALIGN_CENTER);
            p4.setAlignment(Element.ALIGN_CENTER);
            p1.setAlignment(Element.ALIGN_CENTER);
            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(p1);
            document.add(p3);
            document.add(p4);
            document.add(p2);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(5);
            table.addCell("Payment Received");
            table.addCell("Payment Paid");
            table.addCell("Payment Received Returned");
            table.addCell("Payment Paid Returned");
            table.addCell("Total Profit");

            for (int i = 0; i < Details.size(); i++) {
                if (Details.get(i) != null) {
                    table.addCell(Details.get(i).toString());
                } else {
                    table.addCell("0");
                }
            }
            Double PaymentReceived = Details.get(0) == null ? 0.00 : Double.parseDouble(Details.get(0).toString());
            Double PaymentPaid = Details.get(1) == null ? 0.00 : Double.parseDouble(Details.get(1).toString());
            Double PaymentReturned = Details.get(2) == null ? 0.00 : Double.parseDouble(Details.get(2).toString());
            Double PaidReturned = Details.get(3) == null ? 0.00 : Double.parseDouble(Details.get(3).toString());

//                 -Double.parseDouble(PaymentReturned.toString())+Double.parseDouble(PaidReturned.toString());
            Double profit = PaymentReceived - PaymentPaid - PaymentReturned + PaidReturned;
            table.addCell(profit.toString());
            document.add(table);
            Paragraph p7 = new Paragraph("Authorized Signature");
            Paragraph p8 = new Paragraph("Date");
            Paragraph p5 = new Paragraph("........................");
            Paragraph p6 = new Paragraph("........................");

            p7.setAlignment(Element.ALIGN_RIGHT);
            p8.setAlignment(Element.ALIGN_RIGHT);
            p5.setAlignment(Element.ALIGN_RIGHT);
            p6.setAlignment(Element.ALIGN_RIGHT);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(p5);
            document.add(p7);
            document.add(Chunk.NEWLINE);
            document.add(p6);
            document.add(p8);
            document.close();
            file.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SalesReportGeneration(Date fromDate, Date toDate) {
       
        DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
        

        String FromDate = outputFormatter.format(fromDate);
        String ToDate = outputFormatter.format(toDate);
List Details = SalesDetails(ToDate,FromDate);
        try {

            OutputStream file = new FileOutputStream(new File("D:\\SalesReport" + timeStamp + ".pdf"));
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, file);
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            String reportDate = df.format(date);
Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            document.open();
            Paragraph p = new Paragraph("UNIQUE TRADING");
            Paragraph p1 = new Paragraph("No:36,1/1A,Rathnapura Road, Horana");
            Paragraph p3 = new Paragraph("Tele:0711198540");
            Paragraph p4 = new Paragraph("Sales Report", boldFont);
            Paragraph p2 = new Paragraph("" + FromDate+"to"+ToDate);
            p.setAlignment(Element.ALIGN_CENTER);
            p3.setAlignment(Element.ALIGN_CENTER);
            p4.setAlignment(Element.ALIGN_CENTER);
            p1.setAlignment(Element.ALIGN_CENTER);
            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(p1);
            document.add(p3);
            document.add(p4);
            document.add(p2);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(4);
            table.addCell("Order Id");
            table.addCell("Customer Name");
            table.addCell("Item Name");
            table.addCell("Receivable Amount");
           
            for (int i = 0; i < Details.size(); i++) {
                List<String> inventoryDetails = new ArrayList<String>();
                inventoryDetails = (List<String>) Details.get(i);
                for (int j = 0; j < inventoryDetails.size(); j++) {
                    table.addCell(inventoryDetails.get(j));
                }
            }

            document.add(table);
            Paragraph p7 = new Paragraph("Authorized Signature");
            Paragraph p8 = new Paragraph("Date");
            Paragraph p5 = new Paragraph("........................");
            Paragraph p6 = new Paragraph("........................");

            p7.setAlignment(Element.ALIGN_RIGHT);
            p8.setAlignment(Element.ALIGN_RIGHT);
            p5.setAlignment(Element.ALIGN_RIGHT);
            p6.setAlignment(Element.ALIGN_RIGHT);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(p5);
            document.add(p7);
            document.add(Chunk.NEWLINE);
            document.add(p6);
            document.add(p8);
            document.close();
            file.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean OutStandingReportGeneration(Date fromDate, Date toDate) {
       
       DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
        

        String FromDate = outputFormatter.format(fromDate);
        String ToDate = outputFormatter.format(toDate);
List Details = OutstandingDetails(ToDate, FromDate);

        try {

            OutputStream file = new FileOutputStream(new File("D:\\OutstandingReport" + timeStamp + ".pdf"));
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, file);
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            String reportDate = df.format(date);
Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            document.open();
            Paragraph p = new Paragraph("UNIQUE TRADING");
            Paragraph p1 = new Paragraph("No:36,1/1A,Rathnapura Road, Horana");
            Paragraph p3 = new Paragraph("Tele:0711198540");
            Paragraph p4 = new Paragraph("Outstanding Report", boldFont);
          Paragraph p2 = new Paragraph("" + FromDate+"to"+ToDate);
            p.setAlignment(Element.ALIGN_CENTER);
            p3.setAlignment(Element.ALIGN_CENTER);
            p4.setAlignment(Element.ALIGN_CENTER);
            p1.setAlignment(Element.ALIGN_CENTER);
            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(p1);
            document.add(p3);
            document.add(p4);
            document.add(p2);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(5);
            table.addCell("Order Id");
            table.addCell("Customer Name");
            table.addCell("Item Name");
            table.addCell("Receivable Amount");
table.addCell("Due date");
           
            for (int i = 0; i < Details.size(); i++) {
                List<String> inventoryDetails = new ArrayList<String>();
                inventoryDetails = (List<String>) Details.get(i);
                for (int j = 0; j < inventoryDetails.size(); j++) {
                    table.addCell(inventoryDetails.get(j));
                }
            }

            document.add(table);
            Paragraph p7 = new Paragraph("Authorized Signature");
            Paragraph p8 = new Paragraph("Date");
            Paragraph p5 = new Paragraph("........................");
            Paragraph p6 = new Paragraph("........................");

            p7.setAlignment(Element.ALIGN_RIGHT);
            p8.setAlignment(Element.ALIGN_RIGHT);
            p5.setAlignment(Element.ALIGN_RIGHT);
            p6.setAlignment(Element.ALIGN_RIGHT);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(p5);
            document.add(p7);
            document.add(Chunk.NEWLINE);
            document.add(p6);
            document.add(p8);
            document.close();
            file.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean Collectionreport(Date fromDate,Date toDate) {
       
       DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
  
        String FromDate = outputFormatter.format(fromDate);
        String ToDate = outputFormatter.format(toDate);
List Details = CollectionReportDetails(ToDate, FromDate);

        try {

            OutputStream file = new FileOutputStream(new File("D:\\CollectionReport" + timeStamp + ".pdf"));
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, file);
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            String reportDate = df.format(date);
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            document.open();
            Paragraph p = new Paragraph("UNIQUE TRADING");
            Paragraph p1 = new Paragraph("No:36,1/1A,Rathnapura Road, Horana");
            Paragraph p3 = new Paragraph("Tele:0711198540");
            Paragraph p4 = new Paragraph("Collection Report", boldFont);
            Paragraph p2 = new Paragraph("" + FromDate+"-"+ToDate);
            p.setAlignment(Element.ALIGN_CENTER);
            p3.setAlignment(Element.ALIGN_CENTER);
            p4.setAlignment(Element.ALIGN_CENTER);
            p1.setAlignment(Element.ALIGN_CENTER);
            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(p1);
            document.add(p3);
            document.add(p4);
            document.add(p2);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(4);
            table.addCell("Order Id");
            table.addCell("Customer Name");
            table.addCell("Received Amount");
table.addCell("Received Id");
           
            for (int i = 0; i < Details.size(); i++) {
                List<String> inventoryDetails = new ArrayList<String>();
                inventoryDetails = (List<String>) Details.get(i);
                for (int j = 0; j < inventoryDetails.size(); j++) {
                    table.addCell(inventoryDetails.get(j));
                }
            }

            document.add(table);
            Paragraph p7 = new Paragraph("Authorized Signature");
            Paragraph p8 = new Paragraph("Date");
            Paragraph p5 = new Paragraph("........................");
            Paragraph p6 = new Paragraph("........................");

            p7.setAlignment(Element.ALIGN_RIGHT);
            p8.setAlignment(Element.ALIGN_RIGHT);
            p5.setAlignment(Element.ALIGN_RIGHT);
            p6.setAlignment(Element.ALIGN_RIGHT);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(p5);
            document.add(p7);
            document.add(Chunk.NEWLINE);
            document.add(p6);
            document.add(p8);
            document.close();
            file.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public List ProfitDetailsYear(String year) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        List<String> PaymentDetails = new ArrayList<String>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            String sql = "select SUM(rd.Received_amount) as Receivedamount, SUM(pd.Net_amount) as PaidAmount\n"
                    + "from Purchase_details o, Payment_receivable rb, Payment_Received rd, Payable pb, Supplier_payments pd, Payment_received_return Prr, supplier_payment_return Srr, Supply_details sup\n"
                    + "where o.Purchase_id=rb.Purchase_id and rb.Payment_received_id =rd.Payment_received_id and YEAR(rd.Received_date) = ?\n"
                    + "and sup.Supply_id = pb.Supply_details_id and pb.Paid_id = pd.Paid_id and YEAR(pd.Paid_date) = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, year);
            preparedStatement.setString(2, year);

            rst = preparedStatement.executeQuery();

            while (rst.next()) {

                for (int i = 1; i < 3; i++) {

                    PaymentDetails.add(rst.getString(i));

                }

            }

            String sql1 = "select SUM(prr.Amount) as Paymentreceivedreturn\n"
                    + "from Purchase_details o, Payment_receivable rb, Payment_Received rd, Payable pb, Supplier_payments pd, Payment_received_return Prr, supplier_payment_return Srr, Supply_details sup\n"
                    + "where Prr.Payment_rececived_Id IS NOT NULL and YEAR(prr.Returned_date)=? ";

            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1, year);

            rst = preparedStatement.executeQuery();

            while (rst.next()) {

                for (int i = 1; i < 2; i++) {

                    PaymentDetails.add(rst.getString(i));

                }

            }

            String sql2 = "select SUM(Srr.Returned_amount) as Paymentpaidreturn\n"
                    + "from Purchase_details o, Payment_receivable rb, Payment_Received rd, Payable pb, Supplier_payments pd, Payment_received_return Prr, supplier_payment_return Srr, Supply_details sup\n"
                    + "where Srr.Paid_id IS NOT NULL and YEAR(Srr.Paid_id )=?";

            PreparedStatement preparedStatement2 = connection.prepareStatement(sql1);
            preparedStatement2.setString(1, year);

            rst = preparedStatement.executeQuery();

            while (rst.next()) {

                for (int i = 1; i < 2; i++) {

                    PaymentDetails.add(rst.getString(i));

                }

            }
            return PaymentDetails;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return PaymentDetails;
    }
    
    public List ProfitDetailsMonth(String month) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        List<String> PaymentDetails = new ArrayList<String>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            String sql = "select SUM(rd.Received_amount) as Receivedamount, SUM(pd.Net_amount) as PaidAmount\n"
                    + "from Purchase_details o, Payment_receivable rb, Payment_Received rd, Payable pb, Supplier_payments pd, Payment_received_return Prr, supplier_payment_return Srr, Supply_details sup\n"
                    + "where o.Purchase_id=rb.Purchase_id and rb.Payment_received_id =rd.Payment_received_id and MONTH(rd.Received_date) = ?\n"
                    + "and sup.Supply_id = pb.Supply_details_id and pb.Paid_id = pd.Paid_id and MONTH(pd.Paid_date) = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, month);
            preparedStatement.setString(2, month);

            rst = preparedStatement.executeQuery();

            while (rst.next()) {

                for (int i = 1; i < 3; i++) {

                    PaymentDetails.add(rst.getString(i));

                }
            }

            String sql1 = "select SUM(prr.Amount) as Paymentreceivedreturn\n"
                    + "from Purchase_details o, Payment_receivable rb, Payment_Received rd, Payable pb, Supplier_payments pd, Payment_received_return Prr, supplier_payment_return Srr, Supply_details sup\n"
                    + "where Prr.Payment_rececived_Id IS NOT NULL and MONTH(prr.Returned_date)=? ";

            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1, month);

            rst = preparedStatement.executeQuery();

            while (rst.next()) {

                for (int i = 1; i < 2; i++) {

                    PaymentDetails.add(rst.getString(i));

                }

            }

            String sql2 = "select SUM(Srr.Returned_amount) as Paymentpaidreturn\n"
                    + "from Purchase_details o, Payment_receivable rb, Payment_Received rd, Payable pb, Supplier_payments pd, Payment_received_return Prr, supplier_payment_return Srr, Supply_details sup\n"
                    + "where Srr.Paid_id IS NOT NULL and YEAR(Srr.Paid_id )=?";

            PreparedStatement preparedStatement2 = connection.prepareStatement(sql1);
            preparedStatement2.setString(1, month);

            rst = preparedStatement.executeQuery();

            while (rst.next()) {

                for (int i = 1; i < 2; i++) {

                    PaymentDetails.add(rst.getString(i));

                }

            }
            return PaymentDetails;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return PaymentDetails;
    }
    
    public List ProfitDetails(String fromDate, String toDate) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;
        List<String> PaymentDetails = new ArrayList<String>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            String sql = "select SUM(rd.Received_amount) as Receivedamount, SUM(pd.Net_amount) as PaidAmount\n"
                    + "from Purchase_details o, Payment_receivable rb, Payment_Received rd, Payable pb, Supplier_payments pd, Payment_received_return Prr, supplier_payment_return Srr, Supply_details sup\n"
                    + "where o.Purchase_id=rb.Purchase_id and rb.Payment_received_id =rd.Payment_received_id and rd.Received_date >= ? and rd.Received_date <= ?\n"
                    + "and sup.Supply_id = pb.Supply_details_id and pb.Paid_id = pd.Paid_id and pd.Paid_date>= ? and pd.Paid_date <= ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fromDate);
            preparedStatement.setString(2, toDate);
            preparedStatement.setString(3, fromDate);
            preparedStatement.setString(4, toDate);

            rst = preparedStatement.executeQuery();

            while (rst.next()) {

                for (int i = 1; i < 3; i++) {

                    PaymentDetails.add(rst.getString(i));

                }

            }

            String sql1 = "select SUM(prr.Amount) as Paymentreceivedreturn\n"
                    + "from Purchase_details o, Payment_receivable rb, Payment_Received rd, Payable pb, Supplier_payments pd, Payment_received_return Prr, supplier_payment_return Srr, Supply_details sup\n"
                    + "where Prr.Payment_rececived_Id IS NOT NULL and prr.Returned_date >=? and  prr.Returned_date <= ? ";

            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1, fromDate);
            preparedStatement1.setString(2, toDate);

            rst = preparedStatement.executeQuery();

            while (rst.next()) {

                for (int i = 1; i < 2; i++) {

                    PaymentDetails.add(rst.getString(i));

                }

            }

            String sql2 = "select SUM(Srr.Returned_amount) as Paymentpaidreturn\n"
                    + "from Purchase_details o, Payment_receivable rb, Payment_Received rd, Payable pb, Supplier_payments pd, Payment_received_return Prr, supplier_payment_return Srr, Supply_details sup\n"
                    + "where Srr.Paid_id IS NOT NULL and Srr.Paid_id >=? and   Srr.Paid_id <= ? ";

            PreparedStatement preparedStatement2 = connection.prepareStatement(sql1);
            preparedStatement2.setString(1, fromDate);
            preparedStatement2.setString(2, toDate);

            rst = preparedStatement.executeQuery();

            while (rst.next()) {

                for (int i = 1; i < 2; i++) {

                    PaymentDetails.add(rst.getString(i));

                }

            }
            return PaymentDetails;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return PaymentDetails;
    }
    
   public List SalesDetails(String toDate, String fromDate){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
           
            String sql = "select o.Purchase_id, cust.Customer_name, i.item_name, pr.Receivable_amount\n" +
"from Purchase_details o, Customer cust, Items i, Payment_receivable pr\n" +
"where o.Purchase_id = pr.Purchase_id and o.Item_id =i.Item_id and o.Customer_id = cust.Customer_id and o.Orderd_date <? and o.Orderd_date >?";          
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
            preparedStatement1.setString(1, toDate);
            preparedStatement1.setString(2, fromDate);

            rst = preparedStatement1.executeQuery();
           
            while(rst.next())
            {  
                  List<String> salesDetails = new ArrayList<String>();
                
                    for (int i = 1; i < 5; i++){
                            salesDetails.add(rst.getString(i));
                            
                          
                    }

                ListofsalesDetailsList.add(salesDetails);
               
               
            }
            return ListofsalesDetailsList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofsalesDetailsList;

   }
public List OutstandingDetails(String toDate, String fromDate){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
           
            String sql = "select o.Purchase_id, cust.Customer_name, i.item_name, pr.Receivable_amount, pr.Due_date\n" +
"from Purchase_details o, Customer cust, Items i, Payment_receivable pr\n" +
"where o.Purchase_id = pr.Purchase_id and o.Item_id =i.Item_id and o.Customer_id = cust.Customer_id and pr.Isoutstanding =1 and o.Orderd_date <? and o.Orderd_date >?";          
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
            preparedStatement1.setString(1, toDate);
            preparedStatement1.setString(2, fromDate);

            rst = preparedStatement1.executeQuery();
           
            while(rst.next())
            {  
                  List<String> outstandingDetails = new ArrayList<String>();
                
                    for (int i = 1; i < 6; i++){
                            outstandingDetails.add(rst.getString(i));
                            
                          
                    }

                ListofoutstandingsList.add(outstandingDetails);
               
               
            }
            return ListofoutstandingsList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofoutstandingsList;
    } 
public List CollectionReportDetails(String toDate, String fromDate){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
           
            String sql = "select o.Purchase_id, cust.Customer_name, rd.Received_amount, rd.Payment_received_id\n" +
"from Purchase_details o, Customer cust, Items i, Payment_receivable pr,Payment_Received rd \n" +
"where o.Purchase_id = pr.Purchase_id and o.Customer_id = cust.Customer_id and pr.Payment_received_id=rd.Payment_received_id and o.Orderd_date <? and o.Orderd_date >?";          
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
            preparedStatement1.setString(1, toDate);
            preparedStatement1.setString(2, fromDate);

            rst = preparedStatement1.executeQuery();
           
            while(rst.next())
            {  
                  List<String> collectionDetails = new ArrayList<String>();
                
                    for (int i = 1; i < 5; i++){
                            collectionDetails.add(rst.getString(i));
                            
                          
                    }

                ListofcollectionDetailsList.add(collectionDetails);
               
               
            }
            return ListofcollectionDetailsList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofcollectionDetailsList;
    } 
}
