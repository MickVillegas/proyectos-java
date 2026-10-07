<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Lista de Buhos</title>

                <style>
                    body {
                        background: linear-gradient(135deg, #1e293b, #0f172a);
                        color: #f8fafc;
                        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                        text-align: center;
                        max-width: 650px;
                        margin: 40px auto;
                        padding: 20px;
                    }

                    /* Estilo para el título principal */
                    h1 {
                        background-color: #3b82f6;
                        color: #ffffff;
                        padding: 15px;
                        border-radius: 10px;
                        letter-spacing: 2px;
                        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
                        margin-bottom: 30px;
                    }

                    /* Estilo para cada búho */
                    h2 {
                        color: #38bdf8;
                        border-bottom: 2px solid #334155;
                        padding-bottom: 5px;
                        margin-top: 25px;
                    }

                    /* Estilo para los textos */
                    p {
                        font-size: 1.1em;
                        color: #cbd5e1;
                        margin: 6px 0;
                    }
                </style>

            </head>
            <body>
                <h1>LISTA DE BUHOS</h1>
                <xsl:apply-templates />
            </body>
        </html>
    </xsl:template>

    <xsl:template match="buho">
        <h2>Nombre: <xsl:value-of select="nombre_comun"/> - <xsl:value-of select="nombre_cientifico"/></h2>
        <p>Vive en: <xsl:value-of select="habitat"/></p>
        <p>Mide: <xsl:value-of select="envergadura_cm"/> centímetros</p>
        <p>Estado de conservación: <xsl:value-of select="estado_conservacion"/></p>
        <br/>
    </xsl:template>

</xsl:stylesheet>