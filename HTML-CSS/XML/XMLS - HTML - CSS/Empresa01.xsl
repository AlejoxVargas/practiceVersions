    <html>
        <head>
            <title>
            </title>
            <link rel="stylesheet" href="../CSS/style.css" />
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
                <tr>
                    <!-- Nombre del primer empleado -->
                    <td>
                       <xsl:value-of select="empresa/departamento/empleado[1]/nombre"/>
                    </td>
                    <!-- Trabajo del primer empleado -->
                    <xsl:value-of select="empresa/departamento/empleado[1]/trabajo"/>
                    <td>
                    </td>
                    <!-- Sueldo del primer empleado -->
                    <td class="number">
                    <xsl:value-of select="empresa/departamento/empleado[1]/sueldo"/>
                    </td>
                </tr>
            </table>

        </body>
    </html>