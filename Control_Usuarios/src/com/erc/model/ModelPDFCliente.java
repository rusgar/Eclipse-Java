package com.erc.model;

import com.erc.bdhelpers.BDDAO;
import com.erc.dao.SalidaInfoDAO;
import com.erc.model.SalidaInfo;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModelPDFCliente {
    private static final float MARGIN = 50;
    private static final float HEADER_Y_START = 700;  // Ajusta el punto de inicio si es necesario
    private static final float ROW_HEIGHT = 20;  // Altura de cada fila
    private static final float COLUMN_WIDTH_ENLACE = 100;
    private static final float COLUMN_WIDTH_TAREA = 70;
    private static final float COLUMN_WIDTH_TRABAJADOR = 70;
    private static final float COLUMN_WIDTH_FECHA = 80; // Ancho para la columna de fecha
    private static final float COLUMN_WIDTH_DESCRIPCION = 220; // Ajustado para que todo quepa
    private static final PDType1Font FONT = PDType1Font.COURIER;
    private static final float FONT_SIZE = 10f;
    private static final float LEADING = 14f; // Espaciado entre líneas

    public void generateClientPDF(int idCliente, Connection connection, BDDAO bdDAO) {
        SalidaInfoDAO salidaInfoDAO = new SalidaInfoDAO(connection, bdDAO);
        List<SalidaInfo> salidaInfos;

        try {
            salidaInfos = salidaInfoDAO.obtenerSalidasPorCliente(idCliente);
        } catch (SQLException e) {
            System.err.println("Error al obtener las salidas del cliente: " + e.getMessage());
            return;
        }

        if (salidaInfos.isEmpty()) {
            System.out.println("No hay datos para el cliente con ID: " + idCliente);
            return;
        }

        String rutaArchivo = "C:\\Users\\Propietario\\Desktop\\Control_OXON_3\\PDF_Salidas\\" + idCliente + "_Cliente.pdf";
        String directorio = "C:\\Users\\Propietario\\Desktop\\Control_OXON_3\\PDF_Salidas\\";

        try {
            if (!Files.exists(Paths.get(directorio))) {
                Files.createDirectories(Paths.get(directorio));
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

                // Dibuja el encabezado de la tabla
                drawTableHeader(contentStream, HEADER_Y_START);

                // Dibuja los datos de las salidas del cliente
                drawClientData(contentStream, HEADER_Y_START, salidaInfos, bdDAO, connection);
            }

            document.save(rutaArchivo);
            System.out.println("PDF creado exitosamente en: " + rutaArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drawTableHeader(PDPageContentStream contentStream, float yPosition) throws IOException {
        contentStream.setFont(PDType1Font.COURIER_BOLD, FONT_SIZE);

        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + 10, yPosition + 5);
        contentStream.showText("ENLACE");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + 10, yPosition + 5);
        contentStream.showText("TAREA");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + 10, yPosition + 5);
        contentStream.showText("TRABAJADOR");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + COLUMN_WIDTH_TRABAJADOR + 10, yPosition + 5);
        contentStream.showText("FECHA");
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + COLUMN_WIDTH_TRABAJADOR + COLUMN_WIDTH_FECHA + 10, yPosition + 5);
        contentStream.showText("Descripción");
        contentStream.endText();
    }

    private static void drawClientData(PDPageContentStream contentStream, float yStart, List<SalidaInfo> salidaInfos, BDDAO bdDAO, Connection connection) throws IOException {
        float currentYPosition = yStart - ROW_HEIGHT - 10; // Espacio inicial

        contentStream.setFont(FONT, FONT_SIZE);

        // Define el formato de la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (SalidaInfo salidaInfo : salidaInfos) {
            String descripcion = salidaInfo.getSalida().getDescripcion();
            String fecha = salidaInfo.getSalida().getFechaTarea().format(formatter); // Convertir LocalDate a String

            float descriptionHeight = calculateTextHeight(COLUMN_WIDTH_DESCRIPCION, descripcion);
            float rowHeight = Math.max(ROW_HEIGHT, descriptionHeight);

            currentYPosition -= rowHeight; // Mover la posición Y hacia abajo

            // Dibujar los datos en la fila
            drawRowData(contentStream, currentYPosition, salidaInfo, bdDAO, connection);

            // Dibujar el texto de la descripción, ajustado a múltiples líneas si es necesario
            drawWrappedText(contentStream, MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + COLUMN_WIDTH_TRABAJADOR + COLUMN_WIDTH_FECHA + 10, currentYPosition + 5, COLUMN_WIDTH_DESCRIPCION, descripcion);
            currentYPosition -= 10;        
        }
    }




    private static void drawRowData(PDPageContentStream contentStream, float yPosition, SalidaInfo salidaInfo, BDDAO bdDAO, Connection connection) throws IOException {
        // Define el formato de la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Obtener la fecha como String
        String fecha = salidaInfo.getSalida().getFechaTarea().format(formatter);

        // Obtener el ID del trabajador
        int idTrabajador = salidaInfo.getSalida().getIdTrabajador();

        // Obtener el nombre del trabajador desde la base de datos
        String nombreTrabajador;
        try {
            // Obtén la información del trabajador desde la base de datos usando el BDDAO
            tablaTrabajadores trabajador = bdDAO.obtenerTrabajadorPorId(connection, idTrabajador);
            nombreTrabajador = trabajador.getNombre(); // Ajusta según el nombre del método
        } catch (SQLException e) {
            nombreTrabajador = "Desconocido"; // Maneja el caso en que no se puede obtener el nombre del trabajador
            System.err.println("Error al obtener el trabajador: " + e.getMessage());
        }

        // Dibujar el texto para la Fecha
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + COLUMN_WIDTH_TRABAJADOR + 10, yPosition + 5);
        contentStream.showText(fecha);
        contentStream.endText();

        // Dibujar el texto para el Enlace de Google Maps
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + 10, yPosition + 5);
        contentStream.showText("COORDENADAS");
        contentStream.endText();

        // Dibujar el texto de la Tarea
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + 10, yPosition + 5);
        contentStream.showText(salidaInfo.getSalida().getTarea());
        contentStream.endText();

        // Dibujar el nombre del Trabajador
        contentStream.beginText();
        contentStream.newLineAtOffset(MARGIN + COLUMN_WIDTH_ENLACE + COLUMN_WIDTH_TAREA + 10, yPosition + 5);
        contentStream.showText(nombreTrabajador);
        contentStream.endText();
    }

    private static void drawWrappedText(PDPageContentStream contentStream, float x, float y, float width, String text) throws IOException {
        contentStream.setFont(FONT, FONT_SIZE);
        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);

        String[] lines = splitTextToFitWidth(text, width);
        for (String line : lines) {
            contentStream.showText(line);
            contentStream.newLineAtOffset(0, -LEADING);
        }
        contentStream.endText();
    }

    private static String[] splitTextToFitWidth(String text, float width) throws IOException {
        List<String> lines = new ArrayList<>();
        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            String testLine = currentLine.toString() + (currentLine.length() > 0 ? " " : "") + word;
            float testWidth = FONT.getStringWidth(testLine) / 1000 * FONT_SIZE;

            if (testWidth > width) {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            } else {
                currentLine.append((currentLine.length() > 0 ? " " : "")).append(word);
            }
        }
        lines.add(currentLine.toString());

        return lines.toArray(new String[0]);
    }

    private static float calculateTextHeight(float columnWidth, String text) throws IOException {
        return splitTextToFitWidth(text, columnWidth).length * LEADING;
    }
}
