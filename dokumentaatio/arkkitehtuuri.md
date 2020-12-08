# Arkkitehtuurikuvaus
## Koodin luokka/pakkauskaavio
![20201122_133018618_iOS (2)](https://user-images.githubusercontent.com/70371501/99905760-8540ab80-2cdb-11eb-8ffc-62276bf0c930.jpg)

## Rakenne
Pakkausrakenne on kolmiosainen **morsetrainer.ui** --> **morsetrainer.domain** --> **morsetrainer.dao**
* **morsetrainer.ui** sisältää JavaFXML:llä toteutetun käyttöliittymän
* **morsetrainer.domain** sisältää suurimman osan ohjelman toiminnallisuudesta
* **morsetrainer.dao** sisältää tietojen pysyväistalletusksesta vastaavat luokat. Pysyväistallennus on toteutettu SQLite tietokantaa käyttäen.

## Käyttöliittymä
Käyttöliittymä on toteutettu Javan FXML:llää käyttäen SceneBuilderia.

Käyttöliittymä sisältää kolme eri näkymää
* MainView, joka on ohjelman päänäkymä. Kaikki toiminnallisuus on täällä.
* InfoView, joka sisältää informaatiota sovelluksen toiminnasta ja sen käytöstä.
* AlphabetView missä on taulukoituna kaikki aakkoset ja niitä vastaavat Morsen kirjaimet.

Jokaista näkymää vastaa oma Controller -luokka joka lukee omasta FXML -tiedostosta javaFX koodia. Käyttöliittymä on parhaan mukaan yritetty eriyttää sovelluslogiikasta, mutta toiminnallisuutta väkisinkin jäi MainViewController -luokkaan

## Sovelluslogiikka
Sovelluksen päätoiminnallisuus sijaitsee TrainerFunctionality -luokassa, jossa sijatsee metodt merkkien kääntämiselle. Päänäkymän **MainVieWController** -luokka kutsuu merkkien kääntämisestä ja tarkistamisesta vastaavia metodeja ja näyttää käännökset ja tulokset käyttäjälle.

Kääntämistä vastaavia metodeja **TrainerFunctionality** -luokassa:
* String getMorsecodeFromAlphabet(String alphabetLetter)
* Sting getMorsecodeFromInteger(int inputNumber)
* String getAlphabetFromMorse(String morseCode)
* String getAlphabetFromMorse(String morseCode)
* int getIntegerFromMorse(String morse)

Realiaikasesta kääntämisestä vastaa seuraavat metodit, jotka hyödyntävät yllä mainittuja apumetodeita:
* String convertMultipleMorsecodeToAlphabets(String input)
* String convertMultipleLettersToMorse(String input)

Luodessaan sovellukseen uuden käyttäjän, käyttäjän tiedot tallennetaan tietokantaan. Kirjautuessaan sisään tietokannasta haetaan käyttäjän tiedot ja asetetaan ne nykyisen käyttäjän tiedoiksi **UserInfo** -luokkaan. Tietokannan käsittelylle on on oma luokkansa **DBOperations**, mikä pitää sisällään SQL komennot eri toiminnoille. Tietokannan käsittelyn toiminnallisuutta on eriytetty lisää luomalla **UserActions** -luokka, mikä toimii välikätenä käyttöliittymän ja tietokantaa käsittelevien metodien välillä.

## Tietojen pysyväistallennus
Tietojen pysyväistalletuksesta vastaa pakkauksen **morsetrainer.dao** luokat **DBOperations** ja **DBConnection**.
**morsetrainer.domain** pakkauksen luokka **UserActions** toimii apuna tietokannan ja käyttöliittymän **MainViewController** -luokan välillä.

* **DBConnection** vastaa tietokannan alustamisesta ja siihen yhteyden muodostamisesta.
* **DBOperations** sisältää SQL-komennot tietokannan käsittelylle




