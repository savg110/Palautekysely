# Work in progress

Haaga-Helian ohjelmistoprojekti-kurssilla toteutettavan Palautekyselylomakkeen back end. 

## Rajapinnan kautta voi ainakin
* Lisätä feedback-kyselyn, jossa on kysymyksiä. Kysymykset voivat olla (prioriteettijärjestyksessä) tyyppiä skaala 1-5, multiple choice, checkbox, avoin teksti. Kysymykset voivat olla vapaaehtoisia tai pakollisia
* Kyselyyn annetut yksittäiset vastaukset voi tallentaa
* Kyselyyn annetut kaikki vastaukset voi hakea
* Kyselyn kysymykset voi hakea
* Kyselyyn voi lisätä kysymyksiä
* Kyselyn voi laittaa näkyviin / poistaa näkyvistä
* Kyselyn muokkaus ja siihen liittyvä autentikointi (vain kyselyn luoja voi muokata)
* Digiprojekti 1 -kurssilta esitetään lisätoiveita ja muutostarpeita kurssin edetessä

## Toteutettu tähän mennessä

### Spring boot

Rest rajapinta on pystyssä ja kuuntelee get-pyyntöja osoitteessa '/'. Kun sovellus käynnistyy, Commandlinerunner luo 3 kysymystä H2-tietokantaan, jotka ohjelma sitten hakee ja tulostaa. Vastaus toimii ja tallentaa tiedot kantaan. Uuden kysymyksen luonti ei toimi, eikä kysymyksen poisto. 

### Todo next

rakentaa kysymyksen luontilogiikka. rakentaa kysymysten poistologiikka.  
