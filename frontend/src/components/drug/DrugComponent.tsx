import {DrugDescription} from "../../model/appointment/appointment";
import Classes from "./DrugComponent.module.scss";

interface IDrugComponent {
    drugs: DrugDescription[];
}

const DrugComponent = ({drugs}: IDrugComponent) => {

    const renderDrug = (drug: DrugDescription) => {
        return (
            <div key={drug.naziv} className={Classes.drug}>
                <h4>{drug.naziv}</h4>
                {!!drug.sastojci &&
                    <p className={Classes.components}>Sastojci:&nbsp;
                        {drug.sastojci?.map((sastojak, index) => sastojak + (index + 1 !== drug.sastojci.length ? ", " : " ")).slice()}
                    </p>}
                <p className={Classes.components}>Opis: {drug.opisDoze}</p>
            </div>
        );
    }

    return (
        <div className={Classes.canvas}>
            <h2>Preporučeni lekovi:</h2>
            <div>
                {drugs?.map((drug) => renderDrug(drug))}
            </div>
        </div>
    );
}
export default DrugComponent;