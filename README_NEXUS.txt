Utilisation du repository Nexus sur gaia : 

1 - Ajouter un profile dans le settings.xml de votre Maven : 
		<profile>
			<id>nexus</id>
			<repositories>
				<repository>
					<id>central</id>
					<url>http://192.168.102.42:8081/nexus/content/groups/public/</url>
					<releases>
						<enabled>true</enabled>
						<updatePolicy>daily</updatePolicy>
					</releases>
					<snapshots>
						<enabled>true</enabled>
						<updatePolicy>daily</updatePolicy>
					</snapshots>
				</repository>
			</repositories>
			<pluginRepositories>
				<pluginRepository>
					<id>central</id>
					<url>http://192.168.102.42:8081/nexus/content/groups/public/</url>
					<releases>
						<enabled>true</enabled>
						<updatePolicy>daily</updatePolicy>
					</releases>
					<snapshots>
						<enabled>true</enabled>
						<updatePolicy>daily</updatePolicy>
					</snapshots>
				</pluginRepository>
			</pluginRepositories>
		</profile>

2 - Définir ce profil comme actif (en dernier element dans le settings): 

	<activeProfiles>
		<!--make the profile active all the time -->
		<activeProfile>nexus</activeProfile>
	</activeProfiles>
