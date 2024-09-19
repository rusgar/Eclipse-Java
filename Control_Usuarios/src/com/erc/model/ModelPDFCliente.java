package com.erc.model;

import com.erc.bdhelpers.BDDAO;
import com.erc.model.SalidaInfo;
import com.erc.dao.SalidaInfoDAO;
import com.erc.model.modelPDFDiario;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ModelPDFCliente {
    private static final float MARGIN = 50;
    private static final float TABLE1_Y_START = 700;  // Ajusta el punto de inicio si es necesario
    private static final float ROW_HEIGHT = 20;  // Altura de cada fila
    // Definir los anchos de las columnas
    private static final float COLUMN_WIDTH_ENLACE = 100;
    private static final float COLUMN_WIDTH_TAREA = 100;
    private static final float COLUMN_WIDTH_TRABAJADOR = 100;
    private static final float COLUMN_WIDTH_DESCRIPCION = 150;

    public void generateClientPDF(int idCliente, Connection connection, BDDAO bdDAO) {
        SalidaInfoDAO salidaInfoDAO = getSalidaInfoDAO(connection, bdDAO);
        List<SalidaInfo> salidaInfos;

        try {
            // Obtener las salidas del cliente
            salidaInfos = salidaInfoDAO.obtenerSalidasPorCliente(idCliente);
        } catch (SQLException e) {
            System.err.println("Error al obtener las salidas del cliente: " + e.getMessage());
            return;
        }

        if (salidaInfos.isEmpty()) {
            System.out.println("No hay datos para el cliente con ID: " + idCliente);
            return;
        }

        // Crear el PDF
        String rutaArchivo = "C:\\Users\\Propietario\\Desktop\\Control_OXON_3\\PDF_Salidas\\" + idCliente + "_Cliente.pdf";
        String directorio = "C:\\Users\\Propietario\\Desktop\\Control_OXON_3\\PDF_Salidas\\";

        try {
            if (!Files.exists(Paths.get(directorio))) {
                Files.createDirectories(Paths.get(directorio));  // Crear el directorio si no existe
            }
        } catch (IOException e) {
            System.err.println("Error al crear el directorio: " + e.getMessage());
            return;
        }

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
                contentStream.beginText();
                contentStream.newLineAtOffset(MARGIN, page.getMediaBox().getHeight() - MARGIN - 20);
                contentStream.showText("Reporte del Cliente ID: " + idCliente);
                contentStream.endText();

                // Dibuja la tabla de salidas del cliente
                drawClientTable(contentStream, page, TABLE1_Y_START, salidaInfos);
            }

            document.save(rutaArchivo);
            System.out.println("PDF creado exitosamente en: " + rutaArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la instancia de SalidaInfoDAO
    private static SalidaInfoDAO getSalidaInfoDAO(Connection conexion, BDDAO bdDao) {
        return new SalidaInfoDAO(conexion, bdDao);
    }

    // Método para dibujar la tabla de las salidas del cliente
    private static void drawClientTable(PDPageContentStream contentStream, PDPage page, float yStart, List<SalidaInfo> salidaInfos) throws IOException {
        final float tableWidth = COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + COLUMN_WIDTH_TRABAJADOR + COLUMN_WIDTH_DESCRIPCION;
        final float rowHeight = ROW_HEIGHT;
        final float tableHeight = rowHeight * (1 + salidaInfos.size()); // Incluye una fila para los encabezados

        // Dibujar el borde de la tabla
        contentStream.setLineWidth(1f);
        contentStream.moveTo(MARGIN, yStart);
        contentStream.lineTo(MARGIN + tableWidth, yStart);
        contentStream.stroke();

        // Dibujar las columnas
        float xPosition = MARGIN;
        contentStream.moveTo(xPosition, yStart);
        contentStream.lineTo(xPosition, yStart - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_ENLACE;
        contentStream.moveTo(xPosition, yStart);
        contentStream.lineTo(xPosition, yStart - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_TAREA;
        contentStream.moveTo(xPosition, yStart);
        contentStream.lineTo(xPosition, yStart - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_TRABAJADOR;
        contentStream.moveTo(xPosition, yStart);
        contentStream.lineTo(xPosition, yStart - tableHeight);
        contentStream.stroke();
        xPosition += COLUMN_WIDTH_DESCRIPCION;
        contentStream.moveTo(xPosition, yStart);
        contentStream.lineTo(xPosition, yStart - tableHeight);
        contentStream.stroke();

        contentStream.moveTo(MARGIN, yStart - tableHeight);
        contentStream.lineTo(MARGIN + tableWidth, yStart - tableHeight);
        contentStream.stroke();

        // Dibujar los encabezados de la tabla
        contentStream.setFont(PDType1Font.COURIER_BOLD, 10);
        float headerYPosition = yStart + 5;  // Ajuste para la posición del encabezado

        // Encabezado: Enlace Google Maps
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + 10, headerYPosition);
        contentStream.showText("Enlace Google Maps");
        contentStream.endText();

        // Encabezado: Tarea
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + 10, headerYPosition);
        contentStream.showText("Tarea");
        contentStream.endText();

        // Encabezado: Trabajador
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + 10, headerYPosition);
        contentStream.showText("Trabajador");
        contentStream.endText();

        // Encabezado: Descripción
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + COLUMN_WIDTH_TRABAJADOR + 10, headerYPosition);
        contentStream.showText("Descripción");
        contentStream.endText();

        // Dibujar las filas con los datos
        contentStream.setFont(PDType1Font.COURIER, 10);
        float rowYPosition = yStart - rowHeight;  // Posición de inicio para las filas de datos

        for (SalidaInfo salidaInfo : salidaInfos) {
            // Añadir el enlace de Google Maps
            String googleMapsURL = salidaInfo.getEnlaceGoogleMaps();

            PDAnnotationLink link = new PDAnnotationLink();
            PDRectangle position = new PDRectangle(MARGIN, rowYPosition, COLUMN_WIDTH_ENLACE, rowHeight);
            link.setRectangle(position);

            PDActionURI action = new PDActionURI();
            action.setURI(googleMapsURL);
            link.setAction(action);
            page.getAnnotations().add(link);

            // Dibujar el texto para el Enlace de Google Maps
            contentStream.beginText();
            contentStream.newLineAtOffset(MARGIN + 10, rowYPosition + 5);
            contentStream.showText("COORDENADAS");
            contentStream.endText();

            // Dibujar el texto de la Tarea
            contentStream.beginText();
            contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + 10, rowYPosition + 5);
            contentStream.showText(salidaInfo.getSalida().getTarea());
            contentStream.endText();

            // Dibujar el nombre del Trabajador
            contentStream.beginText();
            contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + 10, rowYPosition + 5);
            contentStream.showText(salidaInfo.getNombreUsuario());
            contentStream.endText();

            // Dibujar la Descripción
            contentStream.beginText();
            contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + COLUMN_WIDTH_TRABAJADOR + 10, rowYPosition + 5);
            contentStream.showText(salidaInfo.getSalida().getDescripcion());
            contentStream.endText();

            rowYPosition -= rowHeight;  // Moverse a la siguiente fila
        }
    }




    // Método para dibujar los encabezados de la tabla
    private static void drawTableHeader(PDPageContentStream contentStream, float yPosition) throws IOException {
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + 10, yPosition + 5);
        contentStream.showText("Enlace Google Maps");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + 10, yPosition + 5);
        contentStream.showText("Tarea");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + 10, yPosition + 5);
        contentStream.showText("Trabajador");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + COLUMN_WIDTH_TRABAJADOR + 10, yPosition + 5);
        contentStream.showText("Descripción");
        contentStream.endText();
    }
}
