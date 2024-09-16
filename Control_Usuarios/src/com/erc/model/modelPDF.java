package com.erc.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import com.erc.bdhelpers.SalidaInfo;

public class modelPDF {

    private static final float MARGIN = 50;
    private static final float TABLE_WIDTH = 550;
    private static final float ROW_HEIGHT = 15;
    private static final float Y_START = 750;
    private static final float COLUMN_WIDTH = 100;

    public void generarPDF(List<SalidaInfo> salidaInfos, LocalDate fechaSeleccionada) {
        // Validamos si hay datos para generar el PDF
        if (salidaInfos == null || salidaInfos.isEmpty()) {
            System.out.println("No hay datos para generar el PDF.");
            return;
        }

        // Definimos la ruta donde se generará el PDF
        String directorio = "C:\\Users\\Propietario\\Desktop\\Control_OXON_3\\PDF_Salidas\\";
        String rutaArchivo = directorio + fechaSeleccionada.toString() + ".pdf";

        // Si el directorio no existe, lo creamos
        if (!Files.exists(Paths.get(directorio))) {
            try {
                Files.createDirectories(Paths.get(directorio));
            } catch (IOException e) {
                System.out.println("Error al crear el directorio: " + directorio);
                e.printStackTrace();
                return;
            }
        }

        // Intentamos generar el documento PDF
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            // Creamos el flujo de contenido para escribir en el PDF
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Agregamos el título
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
                contentStream.beginText();
                contentStream.newLineAtOffset(MARGIN, Y_START);
                contentStream.showText("Reporte de Salidas - Fecha: " + fechaSeleccionada.toString());
                contentStream.endText();

                // Agregamos el encabezado de la tabla
                float yPosition = Y_START - ROW_HEIGHT * 2;
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(MARGIN, yPosition);
                contentStream.showText("ID");
                contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                contentStream.showText("Fecha Tarea");
                contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                contentStream.showText("Puesto");
                contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                contentStream.showText("Localidad");
                contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                contentStream.showText("Nombre Usuario");
                contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                contentStream.showText("Enlace Google Maps");
                contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                contentStream.showText("Descripción");
                contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                contentStream.showText("Instalación");
                contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                contentStream.showText("Incidencia");
                contentStream.endText();

                // Posicionamos el inicio de las filas de la tabla
                yPosition -= ROW_HEIGHT;

                // Iteramos por cada salida y añadimos la información al PDF
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                for (SalidaInfo salidaInfo : salidaInfos) {
                    // Controlar cuando el espacio en la página se agota
                    if (yPosition < MARGIN) {
                        // Añadir una nueva página cuando la posición Y se agote
                        PDPage newPage = new PDPage();
                        document.addPage(newPage);
                        contentStream.close(); // Cerramos el stream actual antes de abrir uno nuevo
                        contentStream = new PDPageContentStream(document, newPage);
                        yPosition = Y_START;
                    }

                    // Obtenemos la información de la salida
                    tablaSalidas salida = salidaInfo.getSalida();

                    // Validamos y añadimos la información de cada columna
                    contentStream.beginText();
                    contentStream.newLineAtOffset(MARGIN, yPosition);
                    contentStream.showText(String.valueOf(salida.getId()));
                    contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                    contentStream.showText(salida.getFechaTarea().toString());
                    contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                    contentStream.showText(salidaInfo.getPuesto() != null ? salidaInfo.getPuesto() : "N/A");
                    contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                    contentStream.showText(salidaInfo.getLocalidad() != null ? salidaInfo.getLocalidad() : "N/A");
                    contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                    contentStream.showText(salidaInfo.getNombreUsuario() != null ? salidaInfo.getNombreUsuario() : "N/A");
                    contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                    contentStream.showText(salidaInfo.getEnlaceGoogleMaps() != null ? salidaInfo.getEnlaceGoogleMaps() : "N/A");
                    contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                    contentStream.showText(salida.getDescripcion() != null ? salida.getDescripcion() : "N/A");
                    contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                    contentStream.showText(salida.isInstalaciones() ? "Sí" : "No");
                    contentStream.newLineAtOffset(COLUMN_WIDTH, 0);
                    contentStream.showText(salida.isIncidencias() ? "Sí" : "No");
                    contentStream.endText();

                    // Movemos la posición Y hacia arriba
                    yPosition -= ROW_HEIGHT;
                }
            }

            // Guardamos el documento
            document.save(rutaArchivo);
            System.out.println("PDF creado exitosamente en: " + rutaArchivo);

        } catch (IOException e) {
            System.out.println("Error al crear el PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
