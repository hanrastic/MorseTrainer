# MorseTrainer
Sovelluksella käyttäjä voi tutustua morseaakkosiin ja harjoitella niiden kääntämistä molempiin suuntiin.

## Huomio
Sovelluksen nykyisessä versiossa sisäänkirjautuminen ei toimi.

## Dokumentaatio
* [vaatimusmaarittely](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/vaatimusmaarittely.md)
* [työaikakirjanpito](https://github.com/hanrastic/ot-harjoitustyo/blob/main/dokumentaatio/tyoaikakirjanpito.md)

## Releaset
[Viikko 5] (https://github.com/hanrastic/ot-harjoitustyo/releases/tag/viikko5)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _OtmTodoApp-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/mluukkai/OtmTodoApp/blob/master/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```
