import {Button, Modal} from "react-bootstrap";
import {useState, useEffect} from "react";

export const AppointmentButton = () => {
    const [show, setShow] = useState(false);
    const handleShow = setShow(true);
    const handleClose = useState(false);
    return (
        <>
        <Button variant={'primary'} onClick={handleShow}> Book Appointment </Button>

        </>
    )
}