import {Label, Line, LineChart, XAxis, YAxis} from 'recharts';
import {useEffect, useState} from "react";
import {finishEEGAppointment} from "../../services/appointment/appointment";
import Classes from "./EEGAppointment.module.scss";
import {Button} from "react-bootstrap";
import {SignalType} from "../../model/signals/signalType";
import {Signal} from "../../model/signals/signal";
import {Response} from "../../model/auth/auth";
import {useNavigate} from "react-router-dom";
import {Client} from "@stomp/stompjs";
import SockJS from "sockjs-client";

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
        const client = new Client({
            reconnectDelay: 5000,
            heartbeatIncoming: 4000,
            heartbeatOutgoing: 4000,
            webSocketFactory: () => {
                return new SockJS("http://localhost:8085/sbnz2023tim3/ws");
            },
        });

        client.onConnect = (frame) => {
            client.subscribe('/notifikacija', (message: any) => {
                handleWebSocketMessage(JSON.parse(message.body));
            });
        }

        client.activate()

        return () => {
            client.deactivate()
        };
    }, [signalsGraph]);

    const handleWebSocketMessage = (message: any) => {
        if(message?.signals){
            setSignalsGraph([...signalsGraph,
                {
                    name: new Date(),
                    a: message?.signals.filter((signal: Signal) => signal.tip === SignalType.ALFA).length !== 0 ?
                        message?.signals.filter((signal: Signal) => signal.tip === SignalType.ALFA)[0]?.amplituda : 0,
                    b: message?.signals.filter((signal: Signal) => signal.tip === SignalType.BETA).length !== 0 ?
                        message?.signals.filter((signal: Signal) => signal.tip === SignalType.BETA)[0]?.amplituda : 0,
                    g: message?.signals.filter((signal: Signal) => signal.tip === SignalType.GAMA).length !== 0 ?
                        message?.signals.filter((signal: Signal) => signal.tip === SignalType.GAMA)[0]?.amplituda : 0,
                    d: message?.signals.filter((signal: Signal) => signal.tip === SignalType.DELTA).length !== 0 ?
                        message?.signals.filter((signal: Signal) => signal.tip === SignalType.DELTA)[0]?.amplituda : 0,
                    t: message?.signals.filter((signal: Signal) => signal.tip === SignalType.TETA).length !== 0 ?
                        message?.signals.filter((signal: Signal) => signal.tip === SignalType.TETA)[0]?.amplituda : 0,
                }]);
        }
    };

    const handleOnZavrsiPregled = async () =>{
        const success = await finishEEGAppointment();
        if(success === Response.SUCCESS){
            navigate("/doktor/rezultati");
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