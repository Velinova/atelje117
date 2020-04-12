# atelje117
Viktorija Velinova 161011
Ime na aplikacijata: Atelje 117

Kratok opis
Proektot e veb aplikacija. Ima dva tipovi na korisnici: artisti i sorabotnici. 
Aplikacijata e platforma koja ovozmozuva komunikacija pomegju artistite i sorabotnicite takasto, 
sorabotnicite mozat da pravat dva tipa na naracki (porcelanski i granitni) kaj artistite so koi sorabotuvaat
(artistite i sorabotnicite se povrzani so many to many vrska).
Tabeli vo baza:
  -users
  -artists
  -coworkers 
  -inventories
  -plates
  -attachments
  -clients
  -reports
  -granite orders
  -porcelain orders
  -roles
  -user_role 
  -artist_coworker
  
Aplikacijata ima sloevita aritektura:
  -backend(database -> persistence (JPA repositories) -> service -> mappers -> viewmodels -> web(rest controllers) ->)
  -frontend(-> angular routing module -> service -> components -> html views (bootstrap and angular material))

Funkcionalnosti:
-avtentikacija i avtorizacija so Spring Security i JWT bearer token.
-profiliranje vo odnos na user role
-pregled na crud tabeli kaj user so ROLE_ARTIST: 
   -my coworkers(lista na sorabotnici za najaveniot artist, brisenje)
   -my inventory( inventory za porcelanski cinii za sekoj artist, dodavanje na inventory za nova porcelanska cinija i editiranje na inventory)
   -my orders( pregled na naracki za sekoj artist(porcelanski i granitni),
    brisenje, menuvanje na statusot na narackite, editiranje na narackite (dodavanje na note i cena), pregled na narackite spored status i sorabotnik)
   -my reports (mesecni izvestai za artistot)
- pregled na tabeli na user so ROLE_COWORKER
   -my artist(lista na artisti za sorabotnikot, dodavanje na nov artist, brisenje na artist)
   -my granite orders (pregled na granitni naracki, dodavanje a granitni naracki, menuvanje na status na granitni naracki)
   -my porcelain orders (pregled na porcelanski naracki, dodavanje a porcelanski naracki, menuvanje na status na porcelanski naracki)

Startuvanje na aplikacijata
1.Backend application - Microsoft SQL so Java Spring framework. Za da se podigne bekend aplikacijata potrebno e SQL studio i SQL server.
Konfiguracijata za povrzuvanje so bazata e napravena vo application.properties fajlot. 
Tamu se podeseni username i password na sql user-ot so koj se najavuvame na SQL serverot so SQL server avtentikacija. 
Bidejki mapiranjeto do baza e implementirano so hibernate, za da se generiraat domenskite tabeli vo baza treba 
samo da se kreira database so imme Atelje117, user (sql server user) i da se promenat slednite linii vo application.properties.
    spring.datasource.url=jdbc:sqlserver://localhost;databaseName=Atelje117
    spring.datasource.username=viktorija
    spring.datasource.password=Viktorija123?
    spring.jpa.hibernate.ddl-auto = create-drop (otkako se kreiraat tabelite za da ne gi rekreira se postavuva na none)
Kako inicijalni podatoci vo baza treba da se vnesat samo ulogite vo roles tabelata
    (1, ROLE_ARTIST)
    (2, ROLE_COWORKER)
Backend aplikacijata se startuva na porta 8080.
2.Frontend application - Angular so Angular Material. Za da se podigne frontend apliacijata potrebno e npm komandna linija.
Najprvo treba da se instaliraat site zavisnosti so 
    npm install naredbata, a potoa da se pogidne so 
    ng serve naredbata.
Frontend aplikacijata se startuva na porta 4200.
