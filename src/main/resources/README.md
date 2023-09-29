<h1 align="center">Anwendung CO2App</h1>


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