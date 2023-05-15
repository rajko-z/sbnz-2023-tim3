import {DaNeOdgovor, Questions, TrajanjeOdgovor, VremenskiOdgovor} from "../../model/questionnaire/questions";

export const NesanicaQuestions: Questions[] = [
    {
        question: 'Koliko često imate problema sa spavanjem, kao što su poteškoće održavanja sna, ranog buđenja ili teškog uspavljivanja?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Koliko dugo traje vaša nesanica, tj. koliko dugo imate problema sa spavanjem?',
        choices: [TrajanjeOdgovor.KRATKO, TrajanjeOdgovor.SREDNJE, TrajanjeOdgovor.DUGO]
    },
    {
        question: 'Da li ste primetili da se problemi sa spavanjem javljaju samo u određenim situacijama, kao što su stresni periodi, promene u rasporedu spavanja, ili uzimanje određenih lekova?',
        choices: [DaNeOdgovor.DA, DaNeOdgovor.NE]
    },
    {
        question: 'Da li ste primetili da nakon noći s lošim snom imate osećaj umora, pospanosti ili lošeg raspoloženja tokom dana?',
        choices: [DaNeOdgovor.DA, DaNeOdgovor.NE]
    },
    {
        question: 'Da li ste primetili da vaša nesanica utiče na svakodnevnu funkcionalnost, kao što su radna učinkovitost, emocionalno stanje ili kvalitet života?',
        choices: [DaNeOdgovor.DA, DaNeOdgovor.NE]
    },
    {
        question: 'Da li ste pokušali da primenite različite tehnike za poboljšanje sna, kao što su promene u prehrambenim navikama, fizička aktivnost, promene u okruženju spavaće sobe ili korištenje sredstava za spavanje?',
        choices: [DaNeOdgovor.DA, DaNeOdgovor.NE]
    },
    {
        question: 'Da li ste primetili da postoje određeni okidači ili faktori koji mogu pogoršati vašu nesanicu, kao što su konzumacija kofeina, alkohola ili stresne situacije pre spavanja?',
        choices: [DaNeOdgovor.DA, DaNeOdgovor.NE]
    },
    {
        question: 'Koliko često koristite sredstva za spavanje ili druge lekove kako biste lakše zaspali ili održavali san?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili da vaša nesanica utiče na vaše odnose s drugima, kao što su porodica, prijatelji ili kolege na poslu?',
        choices: [DaNeOdgovor.DA, DaNeOdgovor.NE]
    },
    {
        question: 'Da li ste primetili bilo kakve druge simptome koji se mogu povezati s nesanicom, kao što su noćne more, noćno znojenje, nemirne noge ili druge promene u ponašanju?',
        choices: [DaNeOdgovor.DA, DaNeOdgovor.NE]
    }
];