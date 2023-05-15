import React from 'react';
import {solid} from "@fortawesome/fontawesome-svg-core/import.macro";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import Classes from './MenuDoctor.module.scss';
import {useNavigate} from "react-router-dom";

const MenuDoctor = () => {
    const navigate = useNavigate();

    const handleOnClickLogOut = () => {
        sessionStorage.removeItem("user");
        navigate('/');
        navigate(0);
    }
//istorija pregleda, registracija pacijenta, nov pregled
    return (
        <div className={Classes.menu}>
            <div className={Classes.logo}>
                <img className={Classes.logoIcon} src={require('../../assets/image/logo.jpeg')} alt="logo"/>
            </div>
            <ul className={Classes.menuItems}>
                <li className={Classes.menuItem}>
                    <FontAwesomeIcon className={Classes.icon} icon={solid('brain')}/>
                    <p className={Classes.itemTitle}>Pregled</p>
                </li>
                <li className={Classes.menuItem}>
                    <FontAwesomeIcon className={Classes.icon} icon={solid('plus')}/>
                    <p className={Classes.itemTitle}>Registruj pacijenta</p>
                </li>
                <li className={Classes.menuItem}>
                    <FontAwesomeIcon className={Classes.icon} icon={solid('history')}/>
                    <p className={Classes.itemTitle}>Istorija pregleda</p>
                </li>
            </ul>
            <div className={Classes.logOut} onClick={() => handleOnClickLogOut()}>
                <FontAwesomeIcon className={Classes.icon} icon={solid('right-to-bracket')}/>
                <p className={Classes.itemTitle}>Log out</p>
            </div>
        </div>
    );
};

export default MenuDoctor;
