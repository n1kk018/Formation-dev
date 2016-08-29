<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
               xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
               xmlns:xsd="http://www.w3.org/2001/XMLSchema">
               
      <xsl:template match="/pays">
           <html>
              
              <body>
                        <h3><font color='red'><u> <xsl:value-of select="@nom" /> </u></font></h3>
                                     
                         <xsl:apply-templates select="region" />
                                    
              </body>
           </html>
      </xsl:template>
      
      <xsl:template match="region">
            <h5> <font color='blue'><xsl:value-of select="@nom" /> </font> </h5>
                 <table border='1'>  
                             <tr><th><xsl:text ></xsl:text></th><th>departement</th><th>prefecture</th></tr>                                          
                             <xsl:for-each select="departement">
                             <xsl:element name='tr'>
                                  <xsl:attribute name='bgcolor'>
                                     <xsl:choose>
                                         <xsl:when test="position() mod 2 = 0">yellow</xsl:when> 
                                         <xsl:otherwise>green</xsl:otherwise>
                                     </xsl:choose>
                                  </xsl:attribute>
                                  <td> <xsl:value-of select="@num" /></td>
                                  <td> <xsl:value-of select="@nom" /></td>
                                  <td> <xsl:value-of select="@prefecture" /></td>
                              </xsl:element>
                             </xsl:for-each> 
                 </table>
     
      </xsl:template>
               
</xsl:stylesheet>              