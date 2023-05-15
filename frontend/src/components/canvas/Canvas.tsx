import React, {ReactNode} from 'react';
import Classes from "./Canvas.module.scss";

interface ICanvas {
    children?: ReactNode
}

const Canvas = ({children}: ICanvas) => {
    return (
        <div className={Classes.canvas}>
            <div className={Classes.form}>
                {children}
            </div>
        </div>
    );
};

export default Canvas;