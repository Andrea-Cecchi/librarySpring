# Spring Library

## Endpoint Web

- "/"
  - porta al login
- "/register"
  - porta alla pagina di registrazione
- "/listaLibri"
  - Mostra tutti i libri nel database
- "/myBooks"
  - Mostra tutti i libri pubblicati dall' utente loggato, se non e loggato rimanda al login
- "/aggiungiLibro"
  - permette di pubblicare un libro
- "/dettaglioLibro"
  - mostra i dati del libro
- "/dettaglioUtente"
  - mostra i dati dell'utente

 ## Endpoint Rest

 - "/libri"
   - mostra un json array di tutti i libri
 - "/libro"
   - mostra i dettagli del libro il cui titolo è pasatto come parametro
 - "/sincronizza"
   - immette nel database i libri dalle api di google books
