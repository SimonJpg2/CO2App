<h1 align="left">Anwendung CO2App</h1>


<p><img align="center" src="https://github.com/SimonJpg2/CO2App/blob/main/src/main/resources/AsciiArt.PNG" /></p>

1. Projektbeschreibung

Projekt für das Fach Projektmanagemant an der 
<a href="https://www.lgs-dieburg.de/">Landrat-Gruber-Schule</a>

Im Rahmen des Unterrichts wurde diese Anwendung erstellt, um mit CO2 Daten ermitteln zu können, wie sich diese auf die Gesundheit auswirken.

Die CO2 Daten werden aus dem Excel Dokument des 
<a href="https://www.umweltbundesamt.de/sites/default/files/medien/384/bilder/dateien/de-en_indikator_klim-01_emission-treibhausgase_2023-04-11_0.xlsx">Umweltbundesamtes</a>
gewonnen.

## Inhaltsverzeichnis
1. Projektbeschreibung
2. Inhaltsverzeichnis
3. Installationsanleitung
4. Bekannte Fehler
5. Technologies

## Leitfaden für die Installation unter Windows:
<p><img align="center" src="https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white" /></p>

<h3 align="left">Schritt 1:</h3>
Zunächst wird der MySQL Server auf der offiziellen Herstellerseite heruntergeladen.

[https://dev.mysql.com/downloads/installer/]()

Auf der Installationsseite wird das Betriebssystem "Windows" angewählt und die Datei heruntergeladen.
### Schritt 2:

Anschließend wird der Installer ausgeführt und den Anweisungen des Installers Folge geleistet.

Folgende Informationen sind notwendig für die Installation:

Verwendeter Port : 3306

### Schritt 3:

Nachdem die Installation erfolgreich abgeschlossen wurde, muss ein neuer Datenbank Benutzer namens "java" angelegt werden.

Hierzu wird mit einer Shell im Installationsverzeichnis die Datei mysql.exe ausgeführt.

Das Standardverzeichnis ist: C:\Program Files\MySQL\MySQL-Server\bin\

Command : `mysql.exe -u root -p`

Bei erfolgreichem Login wird folgende Query ausgeführt:

`CREATE USER 'java'@'localhost' IDENTIFIED BY 'password';`

Es wird empfohlen, ein starkes Passwort zu vergeben.

Nun werden eine neue Datenbank und Tabelle für die CO2 Daten angelegt.

`CREATE DATABASE co2;`

`USE co2;`

`CREATE TABLE co2(id int(3) AUTO_INCREMENT, date DATE, value int(3), PRIMARY KEY (id));` 

Anschließend werden dem Benutzer Berechtigungen für die Datenbank erteilt.

`GRANT CREATE, INSERT, UPDATE, DELETE, SELECT ON co2.co2 TO 'java'@'localhost';`

Um die Konfiguration zu überprüfen kann folgender Befehl ausgeführt werden:

`SHOW GRANTS FOR 'java'@'localhost';`

Wenn die erwünschten Berechtigungen erteilt wurden und auf der Konsole angezeigt werden, wurde der Benutzer korrekt konfiguriert.

Nun kann sich über den eben angelegten Benutzer eingeloggt werden

<h2 align="left">Bekannte Fehler</h2>

<h2 align="left">Technologies</h2>

### Properties: 

source encoding : UTF-8

### dependencies

<a href="https://www.geeksforgeeks.org/java-program-to-extract-content-from-a-html-document/">Webcrawler</a>

<a href="https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core">Log4J Core</a>

<a href="https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api">Log4J</a>

<a href="https://mvnrepository.com/artifact/org.junit/junit5-engine">JUnit5</a>

Apache Poi
