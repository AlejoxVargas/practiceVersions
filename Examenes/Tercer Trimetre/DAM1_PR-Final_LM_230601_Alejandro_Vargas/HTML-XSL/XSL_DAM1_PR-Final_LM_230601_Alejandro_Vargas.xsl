<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Libreria</title>
      </head>
      <link rel="stylesheet" href="style.css"/>
      <body>
        <title>
          <xsl:value-of select="libreria/@categoria" />
        </title>
        <h1>Libros de Ficción</h1>
        <table>
          <tr>
            <th>Categoria</th>
            <th>Titulo</th>
            <th>Autor</th>
            <th>Precio</th>
          </tr>
        </table>

        <h1>Libros de No Ficción</h1>
        <table>
          <tr>
            <th>Categoria</th>
            <th>Titulo</th>
            <th>Autor</th>
            <th>Precio</th>
          </tr>
          <xsl:apply-templates select="libreria/libro"/>
        </table>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="libreria/libro">
    <xsl:for-each select="libro">
      <xsl:if test="categoria = 'No Ficción'">
        <tr>
          <td>
            <xsl:value-of select="categoria"/>
          </td>
          <td>
            <xsl:value-of select="titulo"/>
          </td>
          <td>
            <xsl:value-of select="autor"/>
          </td>
          <td>
            <xsl:value-of select="precio/@cantidad"/>
          </td>
        </tr>
      </xsl:if>
    </xsl:for-each>
  </xsl:template>

  <xsl:template match="libreria/libro">
    <xsl:for-each select="libro">
      <xsl:if test="categoria = 'Ficción'">
        <tr>
          <td>
            <xsl:value-of select="categoria"/>
          </td>
          <td>
            <xsl:value-of select="titulo"/>
          </td>
          <td>
            <xsl:value-of select="autor"/>
          </td>
          <td>
            <xsl:value-of select="precio/@cantidad"/>
          </td>
        </tr>
      </xsl:if>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>

