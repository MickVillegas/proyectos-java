<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <!-- Definimos que la salida será un documento HTML -->
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <!-- Regla principal que coincide con la raíz del XML -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Lista de Libros</title>
                <style>
                    table { border-collapse: collapse; width: 100%; font-family: sans-serif; }
                    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
                    th { background-color: #4CAF50; color: white; }
                </style>
            </head>
            <body>
                <h2>Catálogo de la Librería</h2>
                <table>
                    <tr>
                        <th>Título</th>
                        <th>Autor</th>
                        <th>Precio (€)</th>
                    </tr>
                    <!-- Recorremos cada elemento <libro> -->
                    <xsl:for-each select="libreria/libro">
                        <tr>
                            <td><xsl:value-of select="titulo"/></td>
                            <td><xsl:value-of select="autor"/></td>
                            <td><xsl:value-of select="precio"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>