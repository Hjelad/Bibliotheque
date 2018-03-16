<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes" encoding="UTF-8" />
	<xsl:template match="bibliotheque">
		<html>
			<body>
				<p>
					Liste des premiers livres par auteur :
					<xsl:for-each select="Auteur">
						<ul>
							<li>
								<b>
									<xsl:value-of select="NomAuteur" />
								</b>
								:
								<i>
									<xsl:value-of select="Editeur/Ouvrage/Titre" />
								</i>
							</li>
						</ul>
					</xsl:for-each>
					
					Liste des livres de l'editeur Gallimard jeunesse :

							<ul>
								<li>
									<xsl:value-of select="Auteur/Editeur[nomEditeur='Gallimard jeunesse']/Ouvrage/Titre"/>
								</li>
							</ul>
				</p>

			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>

