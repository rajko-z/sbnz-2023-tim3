import React, {ReactNode} from 'react';
import Classes from "./Canvas.module.scss";

interface ICanvas {
    image: string;
    children?: ReactNode
}

const Canvas = ({image, children}: ICanvas) => {
    return (
        <div className={Classes.canvas}>
            <div className={Classes.form}>
                {children}
            </div>
        </div>
    );
};

export default Canvas;