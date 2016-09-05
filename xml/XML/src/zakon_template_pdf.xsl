<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:my="http://www.parlament.gov.rs/propisi" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
    
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="zakon">
                    <fo:region-body margin="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="zakon">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block text-align="center" font-family="sans-serif" font-size="28px" font-weight="bold" padding="30px" >
                        <xsl:value-of select="string(/my:zakon[1]/@naziv)" />
                    </fo:block>
					<xsl:for-each select="/my:zakon/my:deo">
					     <fo:block text-align="center" font-family="sans-serif" font-size="24px" font-weight="bold" padding="30px">
							<xsl:value-of select="@naziv"/>
						</fo:block>
						<fo:block text-align="center" font-family="sans-serif" font-size="20px" font-weight="bold" padding="15px">
						    <xsl:for-each select="/my:zakon/my:deo/my:glava">
							    <xsl:value-of select="my:title"/>
								<xsl:for-each select="/my:zakon/my:deo/my:glava/my:clan">
							         <fo:block text-align="center" font-family="sans-serif" font-size="15px" font-weight="bold" padding="12px">
						                 <xsl:value-of select="my:naslov"/>
										 <fo:block text-align="center" font-family="sans-serif" font-size="15px" font-weight="bold" padding="5px">
						                     Clan <xsl:value-of select="position()"/>.
										 </fo:block>
										 <fo:block text-align="center" font-size="10px" padding="2px">
										     <xsl:value-of select="my:sadrzaj"/>
										 </fo:block>
									</fo:block>
                                </xsl:for-each>
							</xsl:for-each>
						</fo:block>
					</xsl:for-each>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
