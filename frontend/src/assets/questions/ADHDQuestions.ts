import {Questions, VremenskiOdgovor} from "../../model/questionnaire/questions";

export const ADHDQuestions: Questions[] = [
    {
        question: 'Da li ste primetili da imate poteškoća u održavanju pažnje na zadacima ili aktivnostima koje zahtevaju koncentraciju, kao što su školski zadaci, čitanje ili obavljanje kućnih poslova?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili da često gubite stvari koje su vam potrebne za svakodnevne aktivnosti, kao što su ključevi, mobilni telefon, novčanik ili školski materijali?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili da često zaboravljate obaveze ili zadatke koje ste morali obaviti, kao što su dogovoreni sastanci, rokovi za predaju domaćeg ili obaveze kod kuće?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili da često menjate aktivnosti ili zadatke, bez da završite ono što ste započeli?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili da vam je teško da se organizujete ili organizujete svoje stvari, kao što su školska torba, radni prostor ili raspored obaveza?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili da imate poteškoća u praćenju uputstava ili smernica koje vam se daju, kao što su učiteljeva uputstva u školi ili uputstva za obavljanje zadataka na poslu?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili da često delujete impulsivno ili bez razmišljanja o mogućim posledicama, kao što su prekidanje drugih ili donošenje brzopletih odluka?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili da često delujete nemirno ili ne možete ostati na mestu ili u miru, kao što se često pomera rukama ili nogama, prelazite sa jednog mesta na drugo ili imate potrebu za konstantnom aktivnošću?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili da često govorite previše ili ne možete sačekati red dok drugi govore?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili da imate poteškoća sa organizovanjem vlastitog vremena ili obaveza, kao što su planiranje, obavljanje zadataka ili držanje rasporeda?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    }
];