<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:my="http://www.parlament.gov.rs/propisi">

<xsl:template match="/">
  <html>
  <body style="text-align: center">
  <br />
  <h2><xsl:value-of select="/my:zakon[1]/@naziv" /></h2>
  <br />
  <xsl:for-each select="/my:zakon/my:deo">
      <h3><xsl:value-of select="@naziv"/></h3>
	  <xsl:for-each select="/my:zakon/my:deo/my:glava">
	       <h4><xsl:value-of select="my:title"/></h4>
		   <xsl:for-each select="/my:zakon/my:deo/my:glava/my:clan">
		       <xsl:value-of select="my:naslov"/>
			   <br />
			   Clan <xsl:value-of select="position()"/>.
			   <br />
			   <p><xsl:value-of select="my:sadrzaj"/></p>
			   <br />
		   </xsl:for-each>
	  </xsl:for-each>
  </xsl:for-each>
  
  
  
  
  
  <!--<table border="1">
    <tr bgcolor="#9acd32">
      <th>Title</th>
      <th>Artist</th>
    </tr>
    <xsl:for-each select="catalog/cd">
    <tr>
      <td><xsl:value-of select="title"/></td>
      <td><xsl:value-of select="artist"/></td>
    </tr>
    </xsl:for-each>
  </table>
  -->
  </body>
  </html>
</xsl:template>

</xsl:stylesheet> 