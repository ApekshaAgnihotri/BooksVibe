package com.booksVibe.util.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import com.booksVibe.dao.DTO.PdfDataCarrier;
import com.booksVibe.util.exception.UtilException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfUtility.
 */
public class PdfUtility {

    private static final int SIZE=7;
    private static final double CHUNK_PARAM=-2;
    /**
     * Generate.
     * 
     * @param pdfList
     *            the pdf list
     * @return true, if successful
     * @throws UtilException
     */
    public InputStream generate(List<PdfDataCarrier> pdfList)
            throws UtilException {

        try {
            Document document = new Document();
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, b);
            document.open();

            PdfPTable table = new PdfPTable(SIZE);
            table.addCell("S.No");
            table.addCell("Title");
            table.addCell("Author");
            table.addCell("Category");
            table.addCell("Delivered");
            table.addCell("Returned");
            table.addCell("Cancelled");
            int i = 0;
            for (PdfDataCarrier pd : pdfList) {

                if (pd != null) {
                    table.addCell(Integer.toString(++i));
                    table.addCell(pd.getTitle());
                    table.addCell(pd.getAuthor());
                    table.addCell(pd.getCategory());
                    table.addCell(String.valueOf(pd.getDelivered()));
                    table.addCell(String.valueOf(pd.getReturned()));
                    table.addCell(String.valueOf(pd.getCancelled()));
                }
            }
            Chunk chunk = new Chunk("BooksVibe");
            chunk.setUnderline(+1f,(float)CHUNK_PARAM);

            document.add(chunk);
            document.add(new Paragraph("\n\n"));

            document.add(table);
            document.close();
            return new ByteArrayInputStream(b.toByteArray());
        } catch (Exception e) {
            throw new UtilException(e);
        }
    }

}