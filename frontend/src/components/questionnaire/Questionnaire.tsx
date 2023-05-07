import {useState} from "react";
import {Questions} from "../../model/questions/questions";
import Classes from "./Questionnaire.module.scss";
import {Button} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {solid} from "@fortawesome/fontawesome-svg-core/import.macro";

export interface IQuestionnaire {
    questions: Questions[];
    disease: string;
}

interface Answers {
    odgovor1: string;
    odgovor2: string;
    odgovor3: string;
    odgovor4: string;
    odgovor5: string;
    odgovor6: string;
    odgovor7: string;
    odgovor8: string;
    odgovor9: string;
    odgovor10: string;
}

const Questionnaire = ({questions, disease}: IQuestionnaire) => {
    const [activeQuestion, setActiveQuestion] = useState(0);
    const [selectedAnswer, setSelectedAnswer] = useState('');
    const [result, setResult] = useState<Answers>({
        odgovor1: '',
        odgovor2: '',
        odgovor3: '',
        odgovor4: '',
        odgovor5: '',
        odgovor6: '',
        odgovor7: '',
        odgovor8: '',
        odgovor9: '',
        odgovor10: '',
    });

    const onClickNext = () => {
        if (activeQuestion !== 9) {
            setActiveQuestion((prev) => prev + 1);
            // @ts-ignore
            const selectedAnswer = result[("odgovor" + (activeQuestion))];
            setSelectedAnswer(selectedAnswer);
        }
    }

    const onClickPrevious = () => {
        if (activeQuestion !== 0) {
            setActiveQuestion((prev) => prev - 1);
            // @ts-ignore
            const selectedAnswer = result[("odgovor" + (activeQuestion))];
            setSelectedAnswer(selectedAnswer);
        }
    }

    const setAnswer = (answer: string) => {
        const newResult = {...result};
        (Object.keys(newResult) as (keyof typeof newResult)[]).forEach((r) => {
            if (r === ("odgovor" + (activeQuestion + 1))) {
                newResult[r] = answer;
            }
        });
        setResult(newResult);
        setSelectedAnswer(answer);
        console.log(result);
    }

    return (
        <div className={Classes.canvas}>
            <h2 className={Classes.header}>Upitnik za {disease}</h2>
            <div className={Classes.wrapperQuestion}>
                <p className={Classes.question}>{activeQuestion + 1}. {questions[activeQuestion].question}</p>
                <ul className={Classes.choices}>
                    {questions[activeQuestion].choices.map((item) => (
                        <li className={selectedAnswer === item ? Classes.choiceSelect : Classes.choice}
                            onClick={() => setAnswer(item)}>{item}</li>
                    ))}
                </ul>
            </div>
            <div className={Classes.buttonWrapper}>
                {activeQuestion !== 9 && <Button className={Classes.buttonNext} onClick={onClickNext}>
                    <FontAwesomeIcon icon={solid('angle-down')}/>
                </Button>}
                {activeQuestion !== 0 && <Button className={Classes.buttonNext} onClick={onClickPrevious}>
                    <FontAwesomeIcon icon={solid('angle-up')}/>
                </Button>}
            </div>
        </div>
    );
}
export default Questionnaire;