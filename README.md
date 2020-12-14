# MorseTrainer
Sovelluksella käyttäjä voi tutustua morseaakkosiin, sekä harjoitella niiden kääntämistä. Sovelluksessa on ````Translate Mode````, jossa käyttäjä voi kirjoitella joko kirjaimia, numeroita tai Morsen aakkosia, jotka sovellus sitten kääntää käyttäjälle. Treenimuodossa käyttäjä voi harjoitella Morsen aakkosten kääntämistä valitsemallaan vaikeustasolla. Sovellus tarjoaa mahdollisuuden luoda käyttäjän ja kirjautua sisän nähdäkseen oman parhaan suorituksensa.

## Dokumentaatio
* [Käyttöohje](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/kayttoohje.md)
* [vaatimusmaarittely](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/vaatimusmaarittely.md)
* [Arkkitehtuurikuvaus](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/arkkitehtuuri.md)
* [Testausdokumentti](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/testausdokumentti.md)
* [työaikakirjanpito](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/tyoaikakirjanpito.md)

## Releaset
* [Viikko 5](https://github.com/hanrastic/ot-harjoitustyo/releases/tag/viikko5)
* [Viikko 6](https://github.com/hanrastic/ot-harjoitustyo/releases/tag/v2.0-beta)
* [Loppupalautus](https://github.com/hanrastic/ot-harjoitustyo/releases/tag/v3.0)

## Komentorivitoiminnot

### Testaus

Testien suorittaminen tapahtuu komennolla
```
mvn test
```

Testikattavuusraportti voidaan luoda komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan _MorseTrainer-1.0-SNAPSHOT.jar_ -tiedoston

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedostoon määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```
