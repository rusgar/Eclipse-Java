package com.erc.model;

import com.erc.bdhelpers.BDDAO;
import com.erc.dao.SalidaInfoDAO;
import com.erc.dao.URLShortener;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class ModelPDFCliente {
    private static final float MARGIN = 50;
    private static final float TABLE1_Y_START = 700;
    private static final float TABLE2_Y_START = 500;
    private static final float TABLE3_Y_START = 300;
	

    public void generateClientPDF(int idCliente, Connection Connection, BDDAO BDDAO) {
        SalidaInfoDAO salidaInfoDAO = getSalidaInfoDAO(Connection, BDDAO); // Obtén tu instancia de SalidaInfoDAO
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

        if (!Files.exists(Paths.get(directorio))) {
            System.out.println("El directorio no existe: " + directorio);
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

                drawTable1(contentStream, TABLE1_Y_START, salidaInfos);
                drawTable2(contentStream, TABLE2_Y_START, salidaInfos);
                drawTable3(contentStream, page, TABLE3_Y_START, salidaInfos);

            }

            document.save(rutaArchivo);
            System.out.println("PDF creado exitosamente en: " + rutaArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la instancia de SalidaInfoDAO
    private static SalidaInfoDAO getSalidaInfoDAO(Connection conexion,BDDAO bdDao) {
        // Implementa la lógica para obtener una instancia de SalidaInfoDAO
        // Esto puede ser una instancia creada aquí o pasada como argumento
        return new SalidaInfoDAO(conexion, bdDao);
    }

    // Métodos para dibujar tablas (debes implementarlos)
    private static void drawTable1(PDPageContentStream contentStream, float yStart, List<SalidaInfo> salidaInfos) throws IOException {
        // Implementa el dibujo de la tabla
    }

    private static void drawTable2(PDPageContentStream contentStream, float yStart, List<SalidaInfo> salidaInfos) throws IOException {
        // Implementa el dibujo de la tabla
    }

    private static void drawTable3(PDPageContentStream contentStream, PDPage page, float yStart, List<SalidaInfo> salidaInfos) throws IOException {
        // Implementa el dibujo de la tabla
    }
}

