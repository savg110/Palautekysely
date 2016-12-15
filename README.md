#Work in progress

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
* oAuth token systeemi luoada käyttäjille.

## Toteutettu tähän mennessä

### Spring boot / H2 Database / angularJS /spring security

Rest rajapinta on pystyssä ja kuuntelee get-pyyntöja osoitteessa '/'. Kun sovellus käynnistyy, Commandlinerunner luo 3 kysymystä H2-tietokantaan, jotka ohjelma sitten hakee ja tulostaa. Uusien kyselyiden luonti toimii, kysymysten luonti ja poisto toimii. Vastaaminen toimii. Kyselyn voi valita listalta ja frontti näyttää kysymykset. Muokkaus ei toimi. Paranneltu frontin visuaalista ilmettä.
oAuth token systeemi käyttäjille web rajapintaan ja muista web sovelluksista.

token request pyyntö esim.
http://localhost:8080/oauth/authorize?client_id=web&response_type=token

### Todo next
