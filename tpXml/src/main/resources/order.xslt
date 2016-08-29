<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version='2.0' 
				xmlns:o='http://www.afcepf.fr/2016/order' 
				xmlns:p='http://www.afcepf.fr/2016/product'
				xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>
	<xsl:template match="/o:order">
		<html>
			<head>
				<title>Test Xslt</title>
			</head>
			<body>
				
				<h2><font color="blue">Commande n° <xsl:value-of select="o:num" /></font></h2>
				<h4>Date : <xsl:value-of select="o:date" /></h4>
				<p style="text-decoration: underline;text-transform: capitalize;">produits commandés</p>
				<table border='1'>  
					<xsl:element name='tr'>
						<th><xsl:value-of select="o:products/@num|local-name()" /></th>
						<th><!-- <xsl:value-of select="p:description.text()" />-->description</th>
						<th><!-- <xsl:value-of select="p:price.text()" />-->prix</th>
						<th><!-- <xsl:value-of select="o:quantity.text()" />-->quantité</th>
					</xsl:element>
					<xsl:for-each select="o:products">
						<xsl:element name='tr'>
							<xsl:attribute name='bgcolor'>
					             <xsl:choose>
					             	<xsl:when test="position() mod 2 = 0">yellow</xsl:when> 
					                <xsl:otherwise>green</xsl:otherwise>
					              </xsl:choose>
					        </xsl:attribute>
					        <xsl:element name='td'>
								<xsl:value-of select="@num" />
							</xsl:element>
							<xsl:element name='td'>
								<xsl:value-of select="p:description" />
							</xsl:element>
							<xsl:element name='td'>
								<xsl:value-of select="p:price" />
							</xsl:element>
							<xsl:element name='td'>
								<xsl:value-of select="o:quantity" />
							</xsl:element>
						</xsl:element>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>