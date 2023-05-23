<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
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

                    <xsl:apply-templates select="empresa/departamento" />
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="empresa/departamento">
        <xsl:for-each select="empleado">
            <xsl:if test="trabajo = 'Programador'">
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
            </xsl:if>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>