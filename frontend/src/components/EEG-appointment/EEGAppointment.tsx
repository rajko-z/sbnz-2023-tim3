import {LineChart, Line, CartesianGrid, XAxis, YAxis, Label} from 'recharts';
import {useEffect, useState} from "react";
import {getSignal} from "../../services/appointment/appointment";
import Classes from "./EEGAppointment.module.scss";
import {Button} from "react-bootstrap";

interface Signal {
    name: Date;
    a: number;
    b: number;
    g: number;
    d: number;
    t: number;
}

const label: any = {
    a : "Alfa signal",
    b : "Beta signal",
    g : "Gama signal",
    d : "Delta signal",
    t : "Teta signal"
}

const EEGAppointment = () => {
    const [signals, setSignals] = useState<Signal[]>([]);

    // useEffect(() => {
    //     const interval = setInterval(() => updateData(), 1000);
    //     return () => {
    //         clearInterval(interval);
    //     };
    // }, [signals]);

    const updateData = async () => {
        const newData = await getSignal();
        setSignals([...signals,
            {
                name: new Date(),
                a: newData?.alfaSignal?.amplituda ? newData?.alfaSignal?.amplituda : 0,
                b: newData?.betaSignal?.amplituda ? newData?.betaSignal?.amplituda : 0,
                g: newData?.gamaSignal?.amplituda ? newData?.gamaSignal?.amplituda : 0,
                d: newData?.deltaSignal?.amplituda ? newData?.deltaSignal?.amplituda : 0,
                t: newData?.tetaSignal?.amplituda ? newData?.tetaSignal?.amplituda : 0,
            }]);
    }

    const renderLineChart = (param: string) =>  (
        <LineChart width={500} height={300} data={signals}>
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
                <Button type="submit" className={Classes.button}>Zavrsi EEG pregled</Button>
            </div>
        </div>
    );
}
export default EEGAppointment;