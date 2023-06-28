import {useState, useEffect} from "react";
import {Button, Form, Modal} from "react-bootstrap";
import axios from 'axios';
export const CreateOrderButton = () => {
    const [customers, setCustomers] = useState([]);
    const [products, setProducts] = useState([]);
    const [productName, setProductName] = useState([]);
    const [clientName, setClientName] = useState('0');
    const [show, setShow] = useState(false);
    const handleShow = () => {
            setShow(true)
    }
    const handleClose = () => {
            setShow(false)
    }
    useEffect(
        () => {
            axios.get('http://localhost:8080/api/v1/clients').then(resposne => setCustomers(resposne.data))
            axios.get('http://localhost:8080/api/v1/products').then(response => setProducts(
                response.data
            ))
        }, []
    )
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(
            productName, clientName
        )
        handleClose();
    }
    return (
        <>
            <Button onClick={handleShow} >Create Order</Button>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    Create a new Order
                </Modal.Header>
                <Modal.Body>
                    <Form className={'mb-2'}>
                        <Form.Group>
                            <Form.Label htmlFor={'product-name'}>Product's Name</Form.Label>
                            <Form.Select multiple aria-label={'multiple'} type={'text'} id={'product-name'} value={productName} onChange={event => setProductName(event.target.value)
                            }>
                                        <option value={'0'}> Select a product</option>
                                {
                                    products.map(
                                        product =>
                                            <option value={product.id}>
                                                Name: {product.name} Cost: {product.cost}
                                            </option>
                                    )
                                }
                            </Form.Select>
                            <Form.Label htmlFor={'client-name'}>Client's Name</Form.Label>
                            <Form.Select type={'text'} id={'client-name'} value={clientName} onChange={event => setClientName(event.target.value)}>
                                <option value={'0'}> Select a Client</option>
                                {
                                    customers.map(
                                        customer => <option value={customer.id}>{customer.firstName} {customer.lastName}</option>
                                    )
                                }
                            </Form.Select>
                        </Form.Group>
                        <Form.Group className={'mt-2'}>
                            <Button type={'submit'}  onClick={handleSubmit}> Create </Button>
                            <Button onClick={handleClose} variant={'danger'}>Close</Button>
                        </Form.Group>
                    </Form>
                </Modal.Body>
            </Modal></>
    )
}