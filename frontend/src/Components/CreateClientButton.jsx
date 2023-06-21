import {Modal, Button, Form} from "react-bootstrap";
import {useState} from "react";

export const CreateClientButton = () => {
    const [show, setShow] = useState(false);
    const [clientsName, setClientsName] = useState('');
    const [clientsLastName, setClientsLastName] = useState('');
    const [clientsPhone, setClientsPhone] = useState('');
    const [clientsAddress, setClientsAddress] = useState('');
    const handleShow = () => {setShow(true);}
    const handleClose = () => {setShow(false);}
    const handleSubmit = (event) => {
        event.preventDefault();
        handleClose();
    }

    return (
        <>
            <Button onClick={handleShow} >Create Client</Button>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    Create a new Client
                </Modal.Header>
                <Modal.Body>
                    <Form className={'mb-2'}>
                        <Form.Group>
                            <Form.Label htmlFor={'client-first-name'}>Client's First Name</Form.Label>
                            <Form.Control type={'text'} id={'client-first-name'} value={clientsName} onChange={event => setClientsName(event.target.value)}>

                            </Form.Control>
                            <Form.Label htmlFor={'client-last-name'}>Client's Last Name</Form.Label>
                            <Form.Control  type={'text'} id={'client-last-name'} value={clientsLastName} onChange={event => setClientsLastName(event.target.value)}>

                            </Form.Control>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label htmlFor={'client-phone'}>Client's Phone</Form.Label>
                            <Form.Control type={'phone'} id={'client-phone'} value={clientsPhone} onChange={event => setClientsPhone(event.target.value)} placeholder={'Enter Phone'}>

                            </Form.Control>
                            <Form.Label htmlFor={'client-address'}>Client's Address</Form.Label>
                            <Form.Control type={'text'} id={'client-address'} value={clientsAddress} onChange={event => setClientsAddress(event.target.value)} placeholder={'Enter Phone'}>

                            </Form.Control>

                        </Form.Group>
                        <Form.Group className={'mt-2'}>
                            <Button type={'submit'}  onClick={handleSubmit}> Create </Button>
                            <Button onClick={handleClose} variant={'danger'}>Close</Button>
                        </Form.Group>
                    </Form>
                </Modal.Body>
            </Modal>
        </>
    )
}