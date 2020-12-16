# Arkkitehtuurikuvaus

## Rakenne
Pakkausrakenne on kolmiosainen **morsetrainer.ui** --> **morsetrainer.domain** --> **morsetrainer.dao**. Pakkausrakenteen ansiosta sovellusta on helppo laajentaa ja testata.
* **morsetrainer.ui** sisältää JavaFXML:llä toteutetun käyttöliittymän
* **morsetrainer.domain** sisältää suurimman osan ohjelman toiminnallisuudesta
* **morsetrainer.dao** sisältää tietojen pysyväistalletusksesta vastaavat luokat. Pysyväistallennus on toteutettu SQLite tietokantaa käyttäen.

<image src = "https://user-images.githubusercontent.com/70371501/102228121-02ce9480-3ef3-11eb-85e4-91a646035470.jpeg" height=500 widht=MAX>

## Käyttöliittymä
Käyttöliittymä on toteutettu JavaFX FXML:llää käyttäen SceneBuilderia.

Käyttöliittymä sisältää kolme eri näkymää
* MainView, joka on ohjelman päänäkymä. Kaikki toiminnallisuus on täällä.
* InfoView, joka sisältää informaatiota sovelluksen toiminnasta ja sen käytöstä.
* AlphabetView missä on taulukoituna kaikki aakkoset ja niitä vastaavat Morsen kirjaimet.

Jokaista näkymää vastaa oma Controller -luokka joka lukee omasta FXML -tiedostosta javaFX koodia. fxml tiedostot Controller luokille löytyy polusta ````Other Sources/src/main/recources/morsetrainer.ui````.  Käyttöliittymä on parhaan mukaan yritetty eriyttää sovelluslogiikasta, mutta toiminnallisuutta jäi MainViewController -luokkaan.

## Sovelluslogiikka
Sovelluksen päätoiminnallisuus sijaitsee TrainerFunctionality -luokassa, jossa sijatsee metodt merkkien kääntämiselle. Päänäkymän **MainVieWController** -luokka kutsuu merkkien kääntämisestä ja tarkistamisesta vastaavia metodeja ja näyttää käännökset ja tulokset käyttäjälle.

Kääntämistä vastaavia metodeja **TrainerFunctionality** -luokassa:
* String getMorsecodeFromAlphabet(String alphabetLetter)
* Sting getMorsecodeFromInteger(int inputNumber)
* String getAlphabetFromMorse(String morseCode)
* int getIntegerFromMorse(String morse)

Realiaikasesta kääntämisestä vastaa seuraavat metodit, jotka hyödyntävät yllä mainittuja apumetodeita:
* String convertMultipleMorsecodeToAlphabets(String input)
* String convertMultipleLettersToMorse(String input)

Luodessaan sovellukseen uuden käyttäjän, käyttäjän tiedot tallennetaan tietokantaan. Kirjautuessaan sisään tietokannasta haetaan käyttäjän tiedot ja asetetaan ne nykyisen käyttäjän tiedoiksi **UserInfo** -luokkaan. Tietokannan käsittelylle on on oma luokkansa **DBOperations**, mikä pitää sisällään SQL komennot eri toiminnoille. Tietokannan käsittelyn toiminnallisuutta on eriytetty lisää luomalla **UserActions** -luokka, mikä toimii välikätenä käyttöliittymän ja tietokantaa käsittelevien metodien välillä.

## Tietojen pysyväistallennus
Tietojen pysyväistalletuksesta vastaa pakkauksen **morsetrainer.dao** luokat **DBOperations** ja **DBConnection**. Tietokanta **database.db** on upotettu **.dao** -pakettiin.
**morsetrainer.domain** pakkauksen luokka **UserActions** toimii apuna tietokannan ja käyttöliittymän **MainViewController** -luokan välillä.

* **DBConnection** vastaa tietokannan alustamisesta ja siihen yhteyden muodostamisesta.
* **DBOperations** sisältää SQL-komennot tietokannan käsittelylle

## Heikkoudet
### Sovelluslogiikka
Toiminnallisuutta jäi jonkin verran **morsetrainer.ui** paketin alaisuuteen MainViewController -luokkaan. **initialize()** metodi on turhan pitkä ja se sisältää lähes kokonaan ohjelman käyttöliittymän päänäkymän koodin. Metodissa on myös vähän toisteista koodia. 






