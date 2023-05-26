import {Label, Line, LineChart, XAxis, YAxis} from 'recharts';
import {useEffect, useState} from "react";
import {finishEEGAppointment, getSignal} from "../../services/appointment/appointment";
import Classes from "./EEGAppointment.module.scss";
import {Button} from "react-bootstrap";
import {SignalType} from "../../model/signals/signalType";
import {Signal} from "../../model/signals/signal";
import {Response} from "../../model/auth/auth";
import {useNavigate} from "react-router-dom";

interface SignalGraph {
    name: Date;
    a: number;
    b: number;
    g: number;
    d: number;
    t: number;
}

const label: any = {
    a: "Alfa signal",
    b: "Beta signal",
    g: "Gama signal",
    d: "Delta signal",
    t: "Teta signal"
}

const EEGAppointment = () => {
    const [signalsGraph, setSignalsGraph] = useState<SignalGraph[]>([]);
    const navigate = useNavigate();

    useEffect(() => {
        const interval = setInterval(() => updateData(), 1000);
        return () => {
            clearInterval(interval);
        };
    }, [signalsGraph]);

    const updateData = async () => {
        const newData = await getSignal();
        setSignalsGraph([...signalsGraph,
            {
                name: new Date(),
                a: newData?.signals.filter((signal: Signal) => signal.tip === SignalType.ALFA).length !== 0 ?
                    newData?.signals.filter((signal: Signal) => signal.tip === SignalType.ALFA)[0]?.amplituda : 0,
                b: newData?.signals.filter((signal: Signal) => signal.tip === SignalType.BETA).length !== 0 ?
                    newData?.signals.filter((signal: Signal) => signal.tip === SignalType.BETA)[0]?.amplituda : 0,
                g: newData?.signals.filter((signal: Signal) => signal.tip === SignalType.GAMA).length !== 0 ?
                    newData?.signals.filter((signal: Signal) => signal.tip === SignalType.GAMA)[0]?.amplituda : 0,
                d: newData?.signals.filter((signal: Signal) => signal.tip === SignalType.DELTA).length !== 0 ?
                    newData?.signals.filter((signal: Signal) => signal.tip === SignalType.DELTA)[0]?.amplituda : 0,
                t: newData?.signals.filter((signal: Signal) => signal.tip === SignalType.TETA).length !== 0 ?
                    newData?.signals.filter((signal: Signal) => signal.tip === SignalType.TETA)[0]?.amplituda : 0,
            }]);
        console.log(signalsGraph);
    }

    const handleOnZavrsiPregled = async () =>{
        const success = await finishEEGAppointment();
        if(success === Response.SUCCESS){
            navigate("/doktor");
        }
    }

    const renderLineChart = (param: string) => (
        <LineChart width={450} height={300} data={signalsGraph}>
            <Line type="linear" dataKey={param} stroke="#6A8FD0" isAnimationActive={false} dot={false}/>
            <XAxis dataKey="name">
                <Label>{label[param]}</Label>
            </XAxis>
            <YAxis/>
        </LineChart>
    );

    return (
        <div>
            <div className={Classes.header}>
                <h1>EEG signali</h1>
            </div>
            <div className={Classes.signals}>
                {renderLineChart("a")}
                {renderLineChart("b")}
                {renderLineChart("g")}
                {renderLineChart("d")}
                {renderLineChart("t")}
            </div>
            <div className={Classes.buttonSubmit}>
                <Button type="submit" className={Classes.button} onClick={handleOnZavrsiPregled}>Zavrsi EEG pregled</Button>
            </div>
        </div>
    );
}
export default EEGAppointment;