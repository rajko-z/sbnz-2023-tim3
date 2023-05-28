import {useState} from "react";
import {Questions} from "../../model/questionnaire/questions";
import Classes from "./Questionnaire.module.scss";
import {Button} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {solid} from "@fortawesome/fontawesome-svg-core/import.macro";
import {ANSWER} from "../../constants/questionnaire/constants";
import {Answers} from "../../model/questionnaire/answers";
import {sendQuestionnaire} from "../../services/questionnaire/questionnaire";
import {Response} from "../../model/auth/auth";

export interface IQuestionnaire {
    questions: Questions[];
    disease: string;
    setShowModal: (show: boolean) => void;
}

const Questionnaire = ({questions, disease, setShowModal}: IQuestionnaire) => {
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
            const selectedAnswer = result[(ANSWER + (activeQuestion + 2))];
            setSelectedAnswer(selectedAnswer);
        }
    }

    const onClickPrevious = () => {
        if (activeQuestion !== 0) {
            setActiveQuestion((prev) => prev - 1);
            // @ts-ignore
            const selectedAnswer = result[(ANSWER + (activeQuestion))];
            setSelectedAnswer(selectedAnswer);
        }
    }

    const onclickFinish = async () => {
        //poziv ka beku sa podacima upitnika
        const success = await sendQuestionnaire(result, disease);
        if (success === Response.SUCCESS) {
            setShowModal(false);
        }
    }

    const setAnswer = (answer: string) => {
        const newResult = {...result};
        (Object.keys(newResult) as (keyof typeof newResult)[]).forEach((r) => {
            if (r === (ANSWER + (activeQuestion + 1))) {
                newResult[r] = answer;
            }
        });
        setResult(newResult);
        setSelectedAnswer(answer);
    }

    return (
        <div className={Classes.canvas}>
            <h2 className={Classes.header}>Upitnik za {disease}</h2>
            <div className={Classes.wrapperQuestion}>
                <p className={Classes.question}>{activeQuestion + 1}. {questions[activeQuestion].question}</p>
                <ul className={Classes.choices}>
                    {questions[activeQuestion].choices.map((item) => (
                        <li key={item} className={selectedAnswer === item ? Classes.choiceSelect : Classes.choice}
                            onClick={() => setAnswer(item)}>{item.includes("_") ? item.split("_").join(" ") : item}</li>
                    ))}
                </ul>
            </div>
            <div className={Classes.buttonWrapper}>
                {activeQuestion !== 0 && <Button className={Classes.buttonNext} onClick={onClickPrevious}>
                    <FontAwesomeIcon icon={solid('angle-up')}/>
                </Button>}
                {activeQuestion !== 9 && <Button className={Classes.buttonNext} onClick={onClickNext}>
                    <FontAwesomeIcon icon={solid('angle-down')}/>
                </Button>}
                {activeQuestion === 9 && <Button className={Classes.buttonFinish} onClick={onclickFinish}>
                    <FontAwesomeIcon icon={solid('check')}/>
                </Button>}
            </div>
        </div>
    );
}
export default Questionnaire;