import Classes from "./AllergyCheck.module.scss";
import {Button} from "react-bootstrap";
import {Checkbox, FormControlLabel, FormGroup} from "@mui/material";
import {useState} from "react";

interface IAllergyCheck {
    components: string[];
    handleOnClickButton: (selected: string[]) => void;
    disable: boolean;
}

const AllergyCheck = ({components, handleOnClickButton, disable}: IAllergyCheck) => {
    const [selected, setSelected] = useState<string[]>();

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
                <Button type="submit" disabled={disable} className={!disable ? Classes.button: Classes.buttonDisable} onClick={() => handleOnClickButton(selected || [])}>
                    Preporuči
                </Button>
            </div>
        </div>
    );
}
export default AllergyCheck;