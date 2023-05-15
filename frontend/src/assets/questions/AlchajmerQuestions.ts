import {Questions, VremenskiOdgovor} from "../../model/questionnaire/questions";

export const AlchajmerQuestions: Questions[] = [
    {
        question: 'Da li ste primetili promene u pamćenju ili sposobnosti za učenje?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili da se te promene pogoršavaju s vremenom?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili poteškoće u svakodnevnim aktivnostima koje su pre bile rutinske za vas, kao što su obavljanje kućnih poslova, upravljanje finansijama ili vođenje dnevnih beleški?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili promene u vašem ponašanju ili emocionalnom stanju, kao što su zaboravnost, dezorijentacija u poznatom okruženju, promene raspoloženja ili povlačenje iz društvenih aktivnosti?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili probleme s verbalnim ili pismenim izražavanjem, kao što su poteškoće u traženju ili korištenju reči, gubitak sposobnosti pisanja ili govora, ili poteškoće u komunikaciji s drugima?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili probleme s orijentacijom u vremenu, mestu ili prostoru, kao što su gubitak svesti o trenutnom datumu, mestu ili nedostatak prepoznavanja poznatih mesta?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili poteškoće u donošenju odluka, planiranju ili organiziranju, kao što su poteškoće u obavljanju svakodnevnih zadataka ili rešavanju jednostavnih problema?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili promene u vašem sposobnosti upravljanja finansijskim sredstvima, kao što su zaboravljanje plaćanja računa, problema s upravljanjem bankovnim računima ili promenama u finansijskim navikama?\n',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili promene u vašem ponašanju u vezi s higijenom, kao što su poteškoće u održavanju lične higijene, zaboravljanje održavanja čistoće doma ili promene u svakodnevnim rutinama nege tela?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili promene u vašem ponašanju ili sposobnostima koje su uticale na vaše odnose s drugima, kao što su promene u socijalnom ponašanju, povlačenje iz društvenih aktivnosti ili poteškoće u održavanju socijalnih veza?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    }
];