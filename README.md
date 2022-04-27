# MorseTrainer
Sovelluksella käyttäjä voi tutustua morseaakkosiin, sekä harjoitella niiden kääntämistä. Sovelluksessa on ````Translate Mode````, jossa käyttäjä voi kirjoitella joko kirjaimia, numeroita tai Morsen aakkosia, jotka sovellus sitten kääntää käyttäjälle. Treenimuodossa `````Training Mode````` käyttäjä voi harjoitella Morsen aakkosten kääntämistä valitsemallaan vaikeustasolla. Sovellus tarjoaa mahdollisuuden luoda käyttäjän ja kirjautua sisään nähdäkseen oman parhaan suorituksensa.

## Dokumentaatio
* [Käyttöohje](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/kayttoohje.md)
* [vaatimusmaarittely](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/vaatimusmaarittely.md)
* [Arkkitehtuurikuvaus](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/arkkitehtuuri.md)
* [Testausdokumentti](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/testausdokumentti.md)
* [työaikakirjanpito](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/tyoaikakirjanpito.md)

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

Testikattavuusraporrti löytyy avaamalla  _target/site/jacoco/index.html_ selaimella

### Suoritettavan jarin generointi

```
mvn package
```

generoi hakemistoon _target_ suoritettavan _MorseTrainer-1.0-SNAPSHOT.jar_ -tiedoston

### JavaDoc

JavaDoc saadaan luotua komennolla

```
mvn javadoc:javadoc
```

JavaDocia voidaan tarkastella avaamalla tiedosto  _target/site/apidocs/index.html_ selaimella

### Checkstyle

Tiedostoon määrittelemät checkstyle tarkistukset voidaan suorittaa komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```
