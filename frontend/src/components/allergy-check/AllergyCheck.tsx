import Classes from "./AllergyCheck.module.scss";
import {Button} from "react-bootstrap";
import {Checkbox, FormControlLabel, FormGroup} from "@mui/material";
import {useState} from "react";
import {useNavigate} from "react-router-dom";

interface IAllergyCheck {
    setShowModal: (show: boolean) => void;
    components: string[];
}

const AllergyCheck = ({setShowModal, components}: IAllergyCheck) => {
    const [selected, setSelected] = useState<string[]>();
    const navigate = useNavigate();

    const handleOnCloseModal = () => {
        //redirekt na drugu stranicu
        //poziv ka beku da se sacuvaju alergije
        setShowModal(false);
        // navigate("doktor/preporuceni-lekovi");
    }

    const handleChange = (value: any) => {
        const foundComponent = selected?.find((component) => component === value);
        let newValue: string[] = [];
        if (!foundComponent) {
            if (selected) {
                newValue = [...selected, value];
            } else {
                newValue.push(value);
            }
        } else {
            if (selected) {
                newValue = [...selected?.filter((component) => component !== value)];
            }
        }
        setSelected(newValue);
    }

    return (
        <div>
            <h2>Označite alergije koje pacijent ima:</h2>
            <FormGroup className={Classes.checkBox}>
                {components?.map((component) => <FormControlLabel
                    control={
                        <Checkbox value={component} onChange={(e) => handleChange(e.target.value)}
                                  name={component} className={Classes.box}/>
                    }
                    label={component} className={Classes.label} key={component}
                />)}
            </FormGroup>
            <div className={Classes.buttonSubmit}>
                <Button type="submit" className={Classes.button} onClick={handleOnCloseModal}>
                    Završi
                </Button>
            </div>
        </div>
    );
}
export default AllergyCheck;