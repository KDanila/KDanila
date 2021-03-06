<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <entries>
            <xsl:for-each select="//entry">
                <entry>
                    <xsl:attribute name="href">
                        <xsl:value-of select="sum(fields/value)"/>
                    </xsl:attribute>
                </entry>
            </xsl:for-each>
        </entries>
    </xsl:template>
</xsl:stylesheet>