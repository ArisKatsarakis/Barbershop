import {Button, Modal, Form} from "react-bootstrap";
import axios from "axios";

import {useState} from "react";

export const CreateBarber = () => {
    const [show, setShow] = useState(false);
    const [barberName, setBarberName] = useState();
    const handleShow = () => {setShow(true)};
    const handleClose = () => {setShow(false)};
    const barberNameInputHandler = (e) => {
        e.preventDefault();
        setBarberName(e.target.value);

    }
    const handleSubmit = async (e) => {
        e.preventDefault();
        const request  = await axios.post(`http://localhost:8080/api/v1/barber`,{
            name: barberName
        });
        console.log(request);
    }
    return (
        <>
            <Button onClick={handleShow}>
                Add Barber
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    New Barber
                </Modal.Header>
                <Modal.Body>
                    <Form method={'post'}  >
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Barber's Name</Form.Label>
                            <Form.Control type="email" placeholder="Enter Barber's Name " value={barberName} onChange={barberNameInputHandler}/>

                        </Form.Group>
                        <Button variant={'primary'} type={"submit"} onClick={handleSubmit}> Create Barber</Button>
                        <Button variant={'danger'} onClick={handleClose}> Close </Button>
                    </Form>
                </Modal.Body>
            </Modal>
         </>
    )
}