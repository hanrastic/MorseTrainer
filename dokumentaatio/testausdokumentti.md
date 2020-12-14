# Testausdokumentti
## Testaus
### Sovelluslogiikka
````morsetrainer.domain```` paketin luokille on tehty automaattisia testejä [MorseTrainerFunctionalityTest](https://github.com/hanrastic/ot-harjoitustyo/blob/main/MorseTrainer/src/test/java/MorseTrainerFunctionalityTest.java). Nämä testit testaavat sovelluksen tärkeintä logiikkaa eli merkkien kääntämistä, validointia ja tarkastamista.

### Tiedon pysyväistallennus tietokannassa
Tiedon pysyväistallennusta -ja yhteyden muodostamista tietokantaan on testattu [UserActionsTest](https://github.com/hanrastic/ot-harjoitustyo/blob/main/MorseTrainer/src/test/java/UserActionsTest.java) luokan testeillä. Nämä testit testaavat isompaa kokonaisuutta; yhteyden muodostamista tietokantaan, tietokantaan tiedon syöttämistä ja sieltä lukemista, sekä sovelluksen logiikan ja tietokannan väistä toimintaa.

## Testikattavuus
Nykyiset testit antavat 84% rivikattavuuden ja 73% haarautumakattavuuden. Käyttöliittymästä vastaavaa koodi on jätetty testikattavuuden ulkopuolelle.

<img src="https://user-images.githubusercontent.com/70371501/102016333-1948e480-3d69-11eb-8e85-8eec4a8be36d.png" widht=700>

## Testauksen heikkoudet
Tietokannan toiminnalle voisi luoda lisää testejä. Käyttöliittymän koodi sisältää jotain toiminnallisuutta jota ei ole testattu.

