insert into role(naziv) values ('ROLE_DOKTOR');
insert into role(naziv) values ('ROLE_PACIJENT');
-- -- password is 123 for all users
--
insert into doktori (email, adresa, datum_rodjenja, broj_telefona, ime, lozinka, prezime, rola_id, trenutni_pregled_id)
values
    ('lekar0@gmail.com', 'Banijsa 32, Novi Sad, Vojvodina', '1975-01-06', '+381634567811', 'Leka', '$2a$10$GWugnfZGCvK0X3W4NYXE5OYyfNvSaEvhlpK8zrdF0WVd3nvtLZfuG', 'Lekic', 1, null);

insert into pacijenti
    (email, ime, prezime, lozinka, broj_telefona, adresa, datum_rodjenja, rola_id)
values
    ('rajkozgrc4@gmail.com', 'Rajko', 'Zagorac', '$2a$10$GWugnfZGCvK0X3W4NYXE5OYyfNvSaEvhlpK8zrdF0WVd3nvtLZfuG', '+381634567811', 'Josicki put BB, Sombor', '2000-06-27', 2),
    ('nevenaaa@gmail.com', 'Nevena', 'Prokic', '$2a$10$GWugnfZGCvK0X3W4NYXE5OYyfNvSaEvhlpK8zrdF0WVd3nvtLZfuG', '+381634567811', 'Kosovska 30, Pozarevac', '2000-07-02', 2),
    ('mika@gmail.com', 'Mika', 'Mikic', '$2a$10$GWugnfZGCvK0X3W4NYXE5OYyfNvSaEvhlpK8zrdF0WVd3nvtLZfuG', '+381634567811', 'Bulevar Evrope 14, Novi Sad', '1998-01-06', 2),
    ('john@gmail.com', 'John', 'Johanson', '$2a$10$GWugnfZGCvK0X3W4NYXE5OYyfNvSaEvhlpK8zrdF0WVd3nvtLZfuG', '+381634567811', 'Trg Nikole Pasica 3, Beograd', '2000-01-06', 2);


insert into opisi_lekova(tip_bolesti, za_srednju_bolest, za_blagu_bolest, naziv, za_tesku_bolest)
values
    ('ADHD',true,false,'Methylphenidate-Ritalin',true),
    ('ADHD',true,false,'Amphetamine-Adderall',true),
    ('ADHD',true,true,'Atomoxetine-Strattera',true),
    ('ADHD',true,false,'Guanfacine-Intuniv',true),
    ('ADHD',true,true,'Clonidine-Kapvay',true),
    ('ALCHAJMER',true,true,'Donepezil-Aricept',false),
    ('ALCHAJMER',true,false,'Memantine-Namenda',true),
    ('ALCHAJMER',true,true,'Rivastigmine-Exelon',false),
    ('ALCHAJMER',true,true,'Galantamine-Razadyne',false),
    ('ALCHAJMER',true,false,'Combination therapy-Namzaric',true),
    ('NESANICA',true,true,'Zolpidem-Ambien',false),
    ('NESANICA',true,true,'Eszopiclone-Lunesta',false),
    ('NESANICA',true,true,'Zaleplon-Sonata',false),
    ('NESANICA',false,false,'Ramelteon-Rozerem',true),
    ('NESANICA',true,true,'Trazodone-Desyrel',false),
    ('EPILEPSIJA',true,true,'Levetiracetam-Keppra',true),
    ('EPILEPSIJA',true,true,'Lamotrigine-Lamictal',true),
    ('EPILEPSIJA',true,true,'Carbamazepine-Tegretol',true),
    ('EPILEPSIJA',true,true,'Valproic acid-Depakote',true),
    ('EPILEPSIJA',true,true,'Topiramate-Topamax',true);


insert into sastojci(naziv, opis_leka_id)
values
    ('Methylphenidate hydrochloride', 1),
    ('Dextroamphetamine saccharate', 2),
    ('Amphetamine aspartate', 2),
    ('Dextroamphetamine sulfate', 2),
    ('Amphetamine sulfate', 2),
    ('Atomoxetine hydrochloride', 3),
    ('Guanfacine hydrochloride', 4),
    ('Clonidine hydrochloride', 5),
    ('Zolpidem tartrate', 6),
    ('Eszopiclone', 7),
    ('Zaleplon', 8),
    ('Ramelteon', 9),
    ('Trazodone hydrochloride', 10),
    ('Donepezil hydrochloride', 11),
    ('Memantine hydrochloride', 12),
    ('Rivastigmine tartrate', 13),
    ('Galantamine hydrobromide', 14),
    ('Donepezil hydrochloride', 15),
    ('Memantine hydrochloride', 15),
    ('Levetiracetam', 16),
    ('Lamotrigine', 17),
    ('Carbamazepine', 18),
    ('Divalproex sodium', 19),
    ('Topiramate', 20);


insert into opis_leka_dozvoljeni_uzrasti(opis_leka_id, dozvoljeni_uzrasti)
values
    (1,'DETE'),
    (1,'ADOLESCENT'),
    (1,'ODRASTAO'),

    (2,'DETE'),
    (2,'ADOLESCENT'),
    (2,'ODRASTAO'),

    (3,'DETE'),
    (3,'ADOLESCENT'),
    (3,'ODRASTAO'),

    (4,'DETE'),
    (4,'ADOLESCENT'),

    (5,'DETE'),
    (5,'ADOLESCENT'),

    (6,'DETE'),
    (6,'ADOLESCENT'),
    (6,'ODRASTAO'),

    (7,'DETE'),
    (7,'ADOLESCENT'),
    (7,'ODRASTAO'),

    (8,'DETE'),
    (8,'ADOLESCENT'),
    (8,'ODRASTAO'),

    (9,'DETE'),
    (9,'ADOLESCENT'),
    (9,'ODRASTAO'),

    (10,'DETE'),
    (10,'ADOLESCENT'),
    (10,'ODRASTAO'),

    (11,'ADOLESCENT'),
    (11,'ODRASTAO'),

    (12,'ADOLESCENT'),
    (12,'ODRASTAO'),

    (13,'ADOLESCENT'),
    (13,'ODRASTAO'),

    (14,'ADOLESCENT'),
    (14,'ODRASTAO'),

    (15,'ADOLESCENT'),
    (15,'ODRASTAO'),

    (16,'DETE'),
    (16,'ADOLESCENT'),
    (16,'ODRASTAO'),

    (17,'DETE'),
    (17,'ADOLESCENT'),
    (17,'ODRASTAO'),

    (18,'DETE'),
    (18,'ADOLESCENT'),
    (18,'ODRASTAO'),

    (19,'DETE'),
    (19,'ADOLESCENT'),
    (19,'ODRASTAO'),

    (20,'DETE'),
    (20,'ADOLESCENT'),
    (20,'ODRASTAO');


insert into adhd_pitanja(redni_broj, kategorija, pitanje)
values
    (1,'NEPAZNJA', 'Da li ste primetili da imate poteškoća u održavanju pažnje na zadacima ili aktivnostima koje zahtevaju koncentraciju,kao što su školski zadaci, čitanje ili obavljanje kućnih poslova?'),
    (2,'NEPAZNJA', 'Da li ste primetili da često gubite stvari koje su vam potrebne za svakodnevne aktivnosti, kao što su ključevi, mobilnitelefon, novčanik ili školski materijali?'),
    (3,'NEPAZNJA', 'Da li ste primetili da često zaboravljate obaveze ili zadatke koje ste morali obaviti, kao što su dogovoreni sastanci,rokovi za predaju domaćeg ili obaveze kod kuće?'),
    (4,'NEPAZNJA', 'Da li ste primetili da često menjate aktivnosti ili zadatke, bez da završite ono što ste započeli?'),
    (5,'NEPAZNJA', 'Da li ste primetili da vam je teško da se organizujete ili organizujete svoje stvari, kao što su školska torba, radni prostor ili raspored obaveza?'),
    (6,'NEPAZNJA', 'Da li ste primetili da imate poteškoća u praćenju uputstava ili smernica koje vam se daju, kao što su učiteljeva uputstva u školi ili uputstva za obavljanje zadataka na poslu?'),
    (7,'IMPULSIVNOST', 'Da li ste primetili da često delujete impulsivno ili bez razmišljanja o mogućim posledicama, kao što su prekidanje drugih ili donošenje brzopletih odluka?'),
    (8,'HIPERAKTIVNOST', 'Da li ste primetili da često delujete nemirno ili ne možete ostati na mestu ili u miru, kao što se često pomera rukama ili nogama, prelazite sa jednog mesta na drugo ili imate potrebu za konstantnom aktivnošću?'),
    (9,'IMPULSIVNOST', 'Da li ste primetili da često govorite previše ili ne možete sačekati red dok drugi govore?'),
    (10,'NEPAZNJA', 'Da li ste primetili da imate poteškoća sa organizovanjem vlastitog vremena ili obaveza, kao što su planiranje, obavljanje zadataka ili držanje rasporeda?');


insert into alchajmer_pitanja(redni_broj,kategorija, pitanje)
values
    (1,'KOGNITIVNA','Da li ste primetili promene u pamćenju ili sposobnosti za učenje?'),
    (2,'KOGNITIVNA','Koliko dugo primećujete promene u pamćenju ili učenju? Da li ste primetili da se te promene pogoršavaju s vremenom?'),
    (3,'SVAKODNEVNICA','Da li ste primetili poteškoće u svakodnevnim aktivnostima koje su pre bile rutinske za vas, kao što su obavljanje kućnih poslova, upravljanje finansijama ili vođenje dnevnih beleški?'),
    (4,'SOCIJALNO_EMITVNO','Da li ste primetili promene u vašem ponašanju ili emocionalnom stanju, kao što su zaboravnost, dezorijentacija upoznatom okruženju, promene raspoloženja ili povlačenje iz društvenih aktivnosti?'),
    (5,'SOCIJALNO_EMITVNO','Da li ste primetili probleme s verbalnim ili pismenim izražavanjem, kao što su poteškoće u traženju ili korištenju reči, gubitak sposobnosti pisanja ili govora, ili poteškoće u komunikaciji s drugima?'),
    (6,'KOGNITIVNA','Da li ste primetili probleme s orijentacijom u vremenu, mestu ili prostoru, kao što su gubitak svesti o trenutnom datumu, mestu ili nedostatak prepoznavanja poznatih mesta?'),
    (7,'KOGNITIVNA','Da li ste primetili poteškoće u donošenju odluka, planiranju ili organiziranju, kao što su poteškoće u obavljanju svakodnevnih zadataka ili rešavanju jednostavnih problema?'),
    (8,'SVAKODNEVNICA','Da li ste primetili promene u vašem sposobnosti upravljanja finansijskim sredstvima, kao što su zaboravljanje plaćanja računa, problema s upravljanjem bankovnim računima ili promenama u finansijskim navikama?'),
    (9,'SVAKODNEVNICA','Da li ste primetili promene u vašem ponašanju u vezi s higijenom, kao što su poteškoće u održavanju lične higijene, zaboravljanje održavanja čistoće doma ili promene u svakodnevnim rutinama nege tela?'),
    (10,'SOCIJALNO_EMITVNO','Da li ste primetili promene u vašem ponašanju ili sposobnostima koje su uticale na vaše odnose s drugima, kao što su promene u socijalnom ponašanju, povlačenje iz društvenih aktivnosti ili poteškoće u održavanju socijalnih veza?');

insert into nesanica_pitanja(redni_broj,pitanje)
values
    (1,'Koliko često imate problema sa spavanjem, kao što su poteškoće održavanja sna, ranog buđenja ili teškog uspavljivanja?'),
    (2,'Koliko dugo traje vaša nesanica, tj. koliko dugo imate problema sa spavanjem?'),
    (3,'Da li ste primetili da se problemi sa spavanjem javljaju samo u određenim situacijama, kao što su stresni periodi, promene u rasporedu spavanja, ili uzimanje određenih lekova?'),
    (4,'Da li ste primetili da nakon noći s lošim snom imate osećaj umora, pospanosti ili lošeg raspoloženja tokom dana?'),
    (5,'Da li ste primetili da vaša nesanica utiče na svakodnevnu funkcionalnost, kao što su radna učinkovitost, emocionalno stanje ili kvalitet života?'),
    (6,'Da li ste pokušali da primenite različite tehnike za poboljšanje sna, kao što su promene u prehrambenim navikama, fizička aktivnost, promene u okruženju spavaće sobe ili korištenje sredstava za spavanje?'),
    (7,'Da li ste primetili da postoje određeni okidači ili faktori koji mogu pogoršati vašu nesanicu, kao što su konzumacija kofeina, alkohola ili stresne situacije pre spavanja?'),
    (8,'Koliko često koristite sredstva za spavanje ili druge lekove kako biste lakše zaspali ili održavali san?'),
    (9,'Da li ste primetili da vaša nesanica utiče na vaše odnose s drugima, kao što su porodica, prijatelji ili kolege na poslu?'),
    (10,'Da li ste primetili bilo kakve druge simptome koji se mogu povezati s nesanicom, kao što su noćne more, noćno znojenje, nemirne noge ili druge promene u ponašanju?');

insert into epilepsija_pitanja(redni_broj,kategorija, pitanje)
values
    (1,'SIMPTOMI_NAPADA','Da li ste ikada imali napade u kojima ste izgubili svest ili postali dezorijentisani?'),
    (2,'UCESTALOST_NAPADA','Koliko često imate napade?'),
    (3,'SIMPTOMI_NAPADA','Da li ste primetili da u toku vaših napada imate promene u ocećanjima ili promene u svesti?'),
    (4,'OKIDACI_NAPADA','Da li ste primetili bilo kakve okidače koji prethode vašim napadima, kao što su manjak sna, emocionalni stres, alkohol, svetlost, zvukovi ili druge okolnosti?'),
    (5,'SIMPTOMI_NAPADA','Da li ste primetili bilo kakve motoričke simptome, poput trzanja udova, gubitka ravnoteže ili slično, tokom vaših napada?'),
    (6,'SIMPTOMI_NAPADA','Da li ste primetili bilo kakve senzorne simptome, poput promene vida, sluha, mirisa ili ukusa, tokom vaših napada?'),
    (7,'SIMPTOMI_NAPADA','Da li ste primetili bilo kakve promene u svesti, kao što su dezorijentacija, promene u ponašanju, gubitak kontakta s okolinom ili promene u svesti tokom vaših napada?'),
    (8,'FAKTORI_RIZIKA','Da li je neko u porodici imao epilepsiju ili druge neurološke bolesti?'),
    (9,'FAKTORI_RIZIKA','Da li ste doživeli povrede mozga ili traume u prošlosti?'),
    (10,'DODATNI_SIMPTOMI','Da li ste primetili bilo kakve druge simptome, kao što su glavobolje, promene raspoloženja, promene u kognitivnim funkcijama, promene u ponašanju ili emocionalnoj stabilnosti?');