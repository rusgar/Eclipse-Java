package com.erc.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import com.erc.dao.URLShortener;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class modelPDF {

    private static final float MARGIN = 50;
    private static final float TABLE_WIDTH = 500; // Ancho total de las tablas
    private static final float ROW_HEIGHT = 15;
    private static final float COLUMN_WIDTH_ID = 30;
    private static final float COLUMN_WIDTH_FECHA = 90; // Ancho aumentado para "Fecha Tarea"
    private static final float COLUMN_WIDTH_PUESTO = 80;
    private static final float COLUMN_WIDTH_LOCALIDAD = 90;
    private static final float COLUMN_WIDTH_NOMBRE_USUARIO = 100; // Ancho aumentado para "Nombre Usuario"
    private static final float COLUMN_WIDTH_ENLACE = 150; // Ancho para la tercera tabla
    private static final float COLUMN_WIDTH_DESCRIPCION = 200; // Ancho aumentado para "Descripción"
    private static final float COLUMN_WIDTH_INSTALACION = 30;
    private static final float COLUMN_WIDTH_INCIDENCIA = 30;
    private static final float TITLE_Y_POSITION = 750; // Posición inicial para el título
    private static final float TABLE1_Y_START = 680; // Posición inicial para la primera tabla
    private static final float TABLE2_Y_START = 500; // Posición inicial para la segunda tabla
    private static final float TABLE3_Y_START = 300; // Posición inicial para la tercera tabla

    public void generarPDF(List<SalidaInfo> salidaInfos, LocalDate fechaSeleccionada) {
        String rutaArchivo = "C:\\Users\\Propietario\\Desktop\\Control_OXON_3\\PDF_Salidas\\" + fechaSeleccionada.toString() + ".pdf";
        String directorio = "C:\\Users\\Propietario\\Desktop\\Control_OXON_3\\PDF_Salidas\\";

        if (!Files.exists(Paths.get(directorio))) {
            System.out.println("El directorio no existe: " + directorio);
            return;
        }

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(); // Página en orientación vertical
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Agregar título
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
                contentStream.beginText();
                contentStream.newLineAtOffset(MARGIN, page.getMediaBox().getHeight() - MARGIN - 20); // Ajustar la posición del título
                contentStream.showText("Reporte de Salidas - Fecha: " + fechaSeleccionada.toString());
                contentStream.endText();

                // Dibujar las tablas
                drawTable1(contentStream, TABLE1_Y_START, salidaInfos);
                drawTable2(contentStream, TABLE2_Y_START, salidaInfos);
                drawTable3(contentStream, page, TABLE3_Y_START, salidaInfos);

            }

            // Guardar el documento
            document.save(rutaArchivo);
            System.out.println("PDF creado exitosamente en: " + rutaArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawTable1(PDPageContentStream contentStream, float yStart, List<SalidaInfo> salidaInfos) throws IOException {
        final float yPosition = yStart;
        final float tableHeight = ROW_HEIGHT * (1 + salidaInfos.size()); // Agregar una fila para los encabezados

        // Draw the rows
        contentStream.setLineWidth(1f);
        contentStream.moveTo(MARGIN, yPosition);
        contentStream.lineTo(MARGIN + TABLE_WIDTH, yPosition);
        contentStream.stroke();

        // Draw the columns
        float xPosition = MARGIN;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_ID;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_FECHA;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_PUESTO;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_LOCALIDAD;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_NOMBRE_USUARIO;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();
        

        contentStream.moveTo(MARGIN, yPosition - tableHeight);
        contentStream.lineTo(MARGIN + TABLE_WIDTH, yPosition - tableHeight);
        contentStream.stroke();

        // Draw the header for Table 1
        contentStream.setFont(PDType1Font.COURIER_BOLD, 10);
        float headerYPosition = yStart;
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN, headerYPosition);
        contentStream.showText("ID");
        contentStream.newLineAtOffset(COLUMN_WIDTH_ID, 0);
        contentStream.showText("Fecha Tarea");
        contentStream.newLineAtOffset(COLUMN_WIDTH_FECHA, 0);
        contentStream.showText("Puesto");
        contentStream.newLineAtOffset(COLUMN_WIDTH_PUESTO, 0);
        contentStream.showText("Localidad");
        contentStream.newLineAtOffset(COLUMN_WIDTH_LOCALIDAD, 0);
        contentStream.showText("Nombre Usuario");
        contentStream.newLineAtOffset(COLUMN_WIDTH_NOMBRE_USUARIO, 0);
       
        contentStream.endText();

        // Draw the data rows for Table 1
        contentStream.setFont(PDType1Font.COURIER, 10);
        float rowYPosition = headerYPosition - ROW_HEIGHT;
        for (SalidaInfo salidaInfo : salidaInfos) {
            tablaSalidas salida = salidaInfo.getSalida();
            contentStream.beginText();
            contentStream.newLineAtOffset(MARGIN, rowYPosition);
            contentStream.showText(String.valueOf(salida.getId()));
            contentStream.newLineAtOffset(COLUMN_WIDTH_ID, 0);
            contentStream.showText(salida.getFechaTarea().toString());
            contentStream.newLineAtOffset(COLUMN_WIDTH_FECHA, 0);
            contentStream.showText(salidaInfo.getPuesto());
            contentStream.newLineAtOffset(COLUMN_WIDTH_PUESTO, 0);
            contentStream.showText(salidaInfo.getLocalidad());
            contentStream.newLineAtOffset(COLUMN_WIDTH_LOCALIDAD, 0);
            contentStream.showText(salidaInfo.getNombreUsuario());
            contentStream.newLineAtOffset(COLUMN_WIDTH_NOMBRE_USUARIO, 0);
           
            contentStream.endText();
            rowYPosition -= ROW_HEIGHT;
        }
    }

    private void drawTable2(PDPageContentStream contentStream, float yStart, List<SalidaInfo> salidaInfos) throws IOException {
        final float yPosition = yStart;
        final float tableHeight = ROW_HEIGHT * (1 + salidaInfos.size()); // Agregar una fila para los encabezados

        // Draw the rows
        contentStream.setLineWidth(1f);
        contentStream.moveTo(MARGIN, yPosition);
        contentStream.lineTo(MARGIN + TABLE_WIDTH, yPosition);
        contentStream.stroke();

        // Draw the columns
        float xPosition = MARGIN;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_DESCRIPCION;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_INSTALACION;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_INCIDENCIA;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();

        contentStream.moveTo(MARGIN, yPosition - tableHeight);
        contentStream.lineTo(MARGIN + TABLE_WIDTH, yPosition - tableHeight);
        contentStream.stroke();

        // Draw the header for Table 2
        contentStream.setFont(PDType1Font.COURIER_BOLD, 10);
        float headerYPosition = yStart;
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN, headerYPosition);
        contentStream.showText("Descripción");
        contentStream.newLineAtOffset(COLUMN_WIDTH_DESCRIPCION, 0);
        contentStream.showText("Instalación");
        contentStream.newLineAtOffset(COLUMN_WIDTH_INSTALACION, 0);
        contentStream.showText("Incidencia");
        contentStream.endText();

        // Draw the data rows for Table 2
        contentStream.setFont(PDType1Font.COURIER, 10);
        float rowYPosition = headerYPosition - ROW_HEIGHT;
        for (SalidaInfo salidaInfo : salidaInfos) {
            tablaSalidas salida = salidaInfo.getSalida();
            contentStream.beginText();
            contentStream.newLineAtOffset(MARGIN, rowYPosition);
            contentStream.showText(salida.getDescripcion());
            contentStream.newLineAtOffset(COLUMN_WIDTH_DESCRIPCION, 0);
            contentStream.showText(salida.isInstalaciones() ? "Sí" : "No");
            contentStream.newLineAtOffset(COLUMN_WIDTH_INSTALACION, 0);
            contentStream.showText(salida.isIncidencias() ? "Sí" : "No");
            contentStream.endText();
            rowYPosition -= ROW_HEIGHT;
        }
    }

    private void drawTable3(PDPageContentStream contentStream, PDPage page, float yStart, List<SalidaInfo> salidaInfos) throws IOException {
        final float yPosition = yStart;
        final float tableHeight = ROW_HEIGHT * (1 + salidaInfos.size()); // Agregar una fila para los encabezados

        // Draw the rows
        contentStream.setLineWidth(1f);
        contentStream.moveTo(MARGIN, yPosition);
        contentStream.lineTo(MARGIN + TABLE_WIDTH, yPosition);
        contentStream.stroke();

        // Draw the columns
        float xPosition = MARGIN;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_ENLACE;
        contentStream.moveTo(xPosition, yPosition);
        contentStream.lineTo(xPosition, yPosition - tableHeight);
        contentStream.stroke();

        contentStream.moveTo(MARGIN, yPosition - tableHeight);
        contentStream.lineTo(MARGIN + TABLE_WIDTH, yPosition - tableHeight);
        contentStream.stroke();

        // Draw the header for Table 3
        contentStream.setFont(PDType1Font.COURIER_BOLD, 10);
        float headerYPosition = yStart;
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN, headerYPosition);
        contentStream.showText("Enlace Google Maps");
        contentStream.endText();

        // Create a URLShortener instance
        URLShortener shortener = new URLShortener();
        
        // Draw the data rows for Table 3
        contentStream.setFont(PDType1Font.COURIER, 10);
        float rowYPosition = headerYPosition - ROW_HEIGHT;
        for (SalidaInfo salidaInfo : salidaInfos) {
            // Shorten the URL
            String originalURL = salidaInfo.getEnlaceGoogleMaps();
            String shortUrl = shortener.shortenURL(originalURL);

            // Add the link annotation
            PDAnnotationLink link = new PDAnnotationLink();
            PDRectangle position = new PDRectangle(MARGIN, rowYPosition, COLUMN_WIDTH_ENLACE, ROW_HEIGHT);
            link.setRectangle(position);
            
            PDActionURI action = new PDActionURI(); // Crear acción URI
            action.setURI(originalURL); // Establecer la URL
            link.setAction(action);
            
            // Add the link annotation to the page
            page.getAnnotations().add(link);
            
            // Add text for the link
            contentStream.beginText();
            contentStream.newLineAtOffset(MARGIN, rowYPosition);
            contentStream.showText("COORDENADAS"); // Texto del enlace acortado
            contentStream.endText();
            
            rowYPosition -= ROW_HEIGHT;
        }
    }



}
