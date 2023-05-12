# Sistema Gestione Scolastica - Applicazione Web CRUD

```Applicazione Web presentata all'esame di maturità 2023```

Questo progetto è un'applicazione Web Spring Boot CRUD che offre funzionalità di paginazione e ordinamento dei dati utilizzando Spring Boot, ThymeLeaf, Spring Data JPA, Hibernate e un database MySQL.
Il lato frontend è stato realizzato con HTML, CSS E JavaScript.

## Prerequisiti

- Java 8 o superiore
- Maven
- MySQL


## Come eseguire l'applicazione

- Scaricare o clonare il repository
- Aprire il progetto con un compilatore (IntelliJ, Eclipse, ecc...)
- Creare un database MySQL chiamato "scuoladb"
- Modificare le credenziali di accesso al database nel file "application.properties"
- Eseguire all'interno di MySQL il codice con le query all'interno del file "queries.sql" all'interno della cartella "resources"
- Eseguire il comando:
```mvn clean install``` nella directory principale del progetto.
- Successivamente per avviare l'applicazione, eseguire il comando:
```mvn spring-boot:run```
- oppure premere "run" all'interno del compilatore
- Accedere all'applicazione dal browser all'indirizzo "http://localhost:8080/"
- Utilizzare le seguenti credenziali per l'autenticazione:
>Username: admin
||
>Password: admin

## Funzionalità

- Visualizzazione della lista degli studenti ed insegnanti
- Aggiunta di nuovi studenti/insegnanti
- Modifica di studenti/insegnanti esistenti
- Eliminazione di studenti/insegnanti
- Paginazione dei risultati
- Ordinamento dei risultati

## Tecnologie utilizzate

L'applicazione è sviluppata in Java utilizzando il framework Spring Boot e il motore di template ThymeLeaf per la gestione del frontend. Il CSS comprende anche l'utilizzo di Bootstrap, mentre per la logica di persistenza dei dati è stato utilizzato Spring Data JPA con il supporto del framework Hibernate. Il database utilizzato è MySQL.


## Licenza
Questo progetto è concesso in licenza ai sensi della Licenza MIT. Consulta il file LICENSE per ulteriori informazioni.
