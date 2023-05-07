import ReactDOM from 'react-dom';
import styles from './Modal.module.scss';
import React, {ReactNode} from "react";

type Props = {
    show: boolean,
    children: ReactNode
}

const Modal = (props: Props) => {
    return ReactDOM.createPortal(
        <div className={styles[`modal--${props.show}`]}>
            <div onClick={(e) => e.stopPropagation()} className={styles.modalContent}>
                <div className={styles.modalBody}>{props.children}</div>
            </div>
        </div>,
        document.querySelector('#modal') as HTMLElement
    );
};
export default Modal;
