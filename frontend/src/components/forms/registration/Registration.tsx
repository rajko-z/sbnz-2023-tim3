import {Button, Col, Form, Row} from "react-bootstrap";
import Classes from "./Registration.module.scss";
import {useState} from "react";

const Registration = () => {
    const [validated, setValidated] = useState(false);

    const handleOnSubmit = async (event: any) => {
        event.preventDefault();
        event.stopPropagation();

        setValidated(true)
    }

    return (
        <div className={Classes.canvas}>
            <div className={Classes.header}>
                <h1>Registracija pacijenta</h1>
            </div>
            <Form noValidate validated={validated} className={Classes.form} onSubmit={handleOnSubmit}>
                <Row className="mb-3">
                    <Form.Group as={Col} controlId="email">
                        <Form.Label className={Classes.label}>Korisničko ime</Form.Label>
                        <Form.Control
                            className={Classes.input_field}
                            required
                            type="email"
                            // onChange={(e) => setUsername(e.target.value)}
                        />
                        <Form.Control.Feedback type="invalid">Molimo vas unesite korisničko ime</Form.Control.Feedback>
                    </Form.Group>
                </Row>
                <Row className="mb-3">
                    <Form.Group as={Col} controlId="name">
                        <Form.Label className={Classes.label}>Ime</Form.Label>
                        <Form.Control
                            className={Classes.input_field}
                            required
                            type="text"
                            // onChange={(e) => setUsername(e.target.value)}
                        />
                        <Form.Control.Feedback type="invalid">Molimo vas unesite ime</Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group as={Col} controlId="lastName">
                        <Form.Label className={Classes.label}>Prezime</Form.Label>
                        <Form.Control
                            className={Classes.input_field}
                            required
                            type="text"
                            // onChange={(e) => setUsername(e.target.value)}
                        />
                        <Form.Control.Feedback type="invalid">Molimo vas unesite prezime</Form.Control.Feedback>
                    </Form.Group>
                </Row>
                <Row className="mb-3">
                    <Form.Group as={Col} controlId="phone">
                        <Form.Label className={Classes.label}>Broj telefona</Form.Label>
                        <Form.Control
                            className={Classes.input_field}
                            required
                            type="text"
                            // onChange={(e) => setUsername(e.target.value)}
                        />
                        <Form.Control.Feedback type="invalid">Molimo vas unesite broj telefona</Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group as={Col} controlId="address">
                        <Form.Label className={Classes.label}>Adresa</Form.Label>
                        <Form.Control
                            className={Classes.input_field}
                            required
                            type="text"
                            // onChange={(e) => setUsername(e.target.value)}
                        />
                        <Form.Control.Feedback type="invalid">Molimo vas unesite adresu</Form.Control.Feedback>
                    </Form.Group>
                </Row>
                <Row className="mb-3">
                    <Form.Group as={Col} controlId="date">
                        <Form.Label className={Classes.label}>Datum rođenja</Form.Label>
                        <Form.Control
                            className={Classes.input_field}
                            required
                            type="date"
                            // onChange={(e) => setUsername(e.target.value)}
                        />
                        <Form.Control.Feedback type="invalid">Molimo vas unesite datum rođenja</Form.Control.Feedback>
                    </Form.Group>
                </Row>
                <div className={Classes.buttonSubmit}>
                    <Button type="submit" className={Classes.button}>Registruj</Button>
                </div>
            </Form>
        </div>
    );
}

export default Registration;