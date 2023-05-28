import {useState} from "react";


export const useQuestionnaires = () => {
    const [showADHD, setShowADHD] = useState(false);
    const [showNesanica, setShowNesanica] = useState(false);
    const [showAlchajmer, setShowAlchajmer] = useState(false);
    const [showEpilepsija, setShowEpilepsija] = useState(false);
    const [disableADHD, setDisableADHD] = useState(false);
    const [disableNesanica, setDisableNesanica] = useState(false);
    const [disableAlchajmer, setDisableAlchajmer] = useState(false);
    const [disableEpilepsija, setDisableEpilepsija] = useState(false);

    function setADHD(prop: boolean){
        setShowADHD(prop);
        setDisableADHD(prop);
    }
    function setEpilepsija(prop: boolean){
        setShowEpilepsija(prop);
        setDisableEpilepsija(prop);
    }
    function setAlchajmer(prop: boolean){
        setShowAlchajmer(prop);
        setDisableAlchajmer(prop);
    }
    function setNesanica(prop: boolean){
        setShowNesanica(prop);
        setDisableNesanica(prop);
    }

    return {
        setADHD,
        setAlchajmer,
        setEpilepsija,
        setNesanica,
        showADHD,
        showAlchajmer,
        showEpilepsija,
        showNesanica,
        disableADHD,
        disableAlchajmer,
        disableEpilepsija,
        disableNesanica
    }

}