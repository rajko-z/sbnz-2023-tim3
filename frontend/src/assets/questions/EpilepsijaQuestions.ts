import {DaNeOdgovor, Questions, UcestalostOdgovor, VremenskiOdgovor} from "../../model/questionnaire/questions";

export const EpilepsijaQuestions:Questions[] = [
    {
        question: 'Da li ste ikada imali napade u kojima ste izgubili svest ili postali dezorijentisani?',
        choices: [DaNeOdgovor.DA, DaNeOdgovor.NE]
    },
    {
        question: 'Koliko često imate napade?',
        choices: [UcestalostOdgovor.NIKAD, UcestalostOdgovor.PET_GODINA, UcestalostOdgovor.GODINA, UcestalostOdgovor.MESEC, UcestalostOdgovor.NEDELJA]
    },
    {
        question: 'Da li ste primetili da u toku vaših napada imate promene u ocećanjima ili promene u svesti?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili bilo kakve okidače koji prethode vašim napadima, kao što su manjak sna, emocionalni stres, alkohol, svetlost, zvukovi ili druge okolnosti?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili bilo kakve motoričke simptome, poput trzanja udova, gubitka ravnoteže ili slično, tokom vaših napada?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili bilo kakve senzorne simptome, poput promene vida, sluha, mirisa ili ukusa, tokom vaših napada?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li ste primetili bilo kakve promene u svesti, kao što su dezorijentacija, promene u ponašanju, gubitak kontakta s okolinom ili promene u svesti tokom vaših napada?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    },
    {
        question: 'Da li je neko u porodici imao epilepsiju ili druge neurološke bolesti?',
        choices: [DaNeOdgovor.DA, DaNeOdgovor.NE]
    },
    {
        question: 'Da li ste doživeli povrede mozga ili traume u prošlosti?',
        choices: [DaNeOdgovor.DA, DaNeOdgovor.NE]
    },
    {
        question: 'Da li ste primetili bilo kakve druge simptome, kao što su glavobolje, promene raspoloženja, promene u kognitivnim funkcijama, promene u ponašanju ili emocionalnoj stabilnosti?',
        choices: [VremenskiOdgovor.NIKAD, VremenskiOdgovor.RETKO, VremenskiOdgovor.PONEKAD, VremenskiOdgovor.CESTO]
    }
];