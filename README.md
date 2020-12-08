# MorseTrainer
Sovelluksella käyttäjä voi tutustua morseaakkosiin ja harjoitella niiden kääntämistä molempiin suuntiin.

## Huomio
Sovelluksen nykyisessä versiossa sisäänkirjautuminen ei toimi.

## Dokumentaatio
* [vaatimusmaarittely](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/vaatimusmaarittely.md)
* [työaikakirjanpito](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/tyoaikakirjanpito.md)

## Releaset
* [Viikko 5](https://github.com/hanrastic/ot-harjoitustyo/releases/tag/viikko5)
* [Viikko 6](https://github.com/hanrastic/ot-harjoitustyo/releases/tag/v2.0-beta)

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

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco.exec_

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
