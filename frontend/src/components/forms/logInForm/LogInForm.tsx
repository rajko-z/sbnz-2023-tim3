import {useState} from "react";
import Classes from "./LogInForm.module.scss";
import {Button, Col, Form, InputGroup, Row} from "react-bootstrap";
import {solid} from "@fortawesome/fontawesome-svg-core/import.macro";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {logIn} from "../../../services/auth/auth";
import {toast} from "react-toastify";
import {getRoleFromToken} from "../../../services/auth/jwtTokenUtils";
import {path} from "../../../model/auth/roles";
import {useNavigate} from "react-router-dom";
import {Response} from "../../../model/auth/auth";

const LogInForm = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [passwordShown, setPasswordShown] = useState(false);
    const [validated, setValidated] = useState(false);
    const navigate = useNavigate();

    const handlePasswordButton = (e: any) => {
        e.preventDefault();
        e.stopPropagation();
        setPasswordShown(!passwordShown);
    }

    const handleOnSubmit = async (event: any) => {
        event.preventDefault();
        event.stopPropagation();
        const success = await logIn({
            email: username,
            lozinka: password
        });
        if (success === Response.SUCCESS) {
            openUserHomePage();
        } else {
            toast.error(success, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            });
        }
        setValidated(true)
    }

    const openUserHomePage = () => {
        const role = getRoleFromToken();
        if (role) {
            const homePageLocation = path[role];
            if (!!homePageLocation) {
                navigate("/pacijent", {replace: true})
                navigate(0);
            }
        }
    }

    return (
        <div className={Classes.formCanvas}>
            <div className={Classes.header}>
                <h1>Prijava na sistem</h1>
            </div>
            <Form noValidate validated={validated} className={Classes.form} onSubmit={handleOnSubmit}>
                <Row className="mb-3">
                    <Form.Group as={Col} controlId="email">
                        <Form.Label className={Classes.label}>Korisničko ime</Form.Label>
                        <Form.Control
                            className={Classes.input_field}
                            required
                            type="email"
                            onChange={(e) => setUsername(e.target.value)}
                        />
                        <Form.Control.Feedback type="invalid">Molimo vas unesite korisničko ime</Form.Control.Feedback>
                    </Form.Group>
                </Row>
                <Row className="mb-3">
                    <Form.Group as={Col} controlId="password">
                        <Form.Label className={Classes.label}>Lozinka</Form.Label>
                        <InputGroup>
                            <Form.Control
                                className={Classes.input_field}
                                required
                                type={passwordShown ? "text" : 'password'}
                                onChange={(e) => setPassword(e.target.value)}
                            />
                            <Button className={Classes.input_field} onClick={handlePasswordButton}>
                                {!passwordShown ? <FontAwesomeIcon icon={solid("eye-slash")}/> :
                                    <FontAwesomeIcon icon={solid("eye")}/>}
                            </Button>
                        </InputGroup>
                        <Form.Control.Feedback type="invalid">Molimo vas unesite lozinku</Form.Control.Feedback>
                    </Form.Group>
                </Row>
                <div className={Classes.buttonSubmit}>
                    <Button type="submit" className={Classes.button}>Prijavi se</Button>
                </div>
            </Form>
        </div>
    );
}
export default LogInForm;