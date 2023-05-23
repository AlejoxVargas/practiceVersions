<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" />
    <xsl:template match="/">
        <html>
            <head>
                <title>
                    <xsl:value-of select="empresa/@nombre" />
                </title>
                <link rel="stylesheet" href="style.css" />
            </head>
            <body>
                <div class="info">Datos del primer primer empleado</div>
                <table>
                    <caption>
                    </caption>
                    <tr>
                        <th>Nombre</th>
                        <th>Trabajo</th>
                        <th>Sueldo</th>
                    </tr>
                    <xsl:for-each select="empresa/departamento/empleado">
                        <tr>
                            <!-- Nombre del primer empleado -->
                            <td>
                                <xsl:value-of select="nombre" />
                            </td>
                            <!-- Trabajo del primer empleado -->
                            <td>
                                <xsl:value-of select="trabajo" />
                            </td>
                            <!-- Sueldo del primer empleado -->
                            <td class="number">
                                <xsl:value-of select="sueldo" />
                            </td>
                        </tr>
                    </xsl:for-each>
                    <tr>
                        <td colspan="2">TOTAL DE SUELDOS</td>
                        <td class="number">
                            <xsl:value-of
                                select="format-number(sum(empresa/departamento/empleado/sueldo),'#.00')" />
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>